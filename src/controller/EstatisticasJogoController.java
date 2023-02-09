package controller;

import enums.Estado;
import model.EstatisticasJogo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstatisticasJogoController {
    private static final String CSV_SEPARATOR = ",";
    public List<EstatisticasJogo> getEstatisticasJogos() throws IOException {
        Path path = Paths.get("src/dados/campeonato-brasileiro-full.csv");
        List<EstatisticasJogo> listaEstatisticasJogos = new ArrayList<>();

        try (Stream<String> lines = Files.lines(path)) {
            List<String> linhas = lines.map(s -> s.replaceAll("\"", "")).collect(Collectors.toList());
            linhas.remove(0);

            for (String linha : linhas) {
                String[] dados = linha.split(CSV_SEPARATOR, -1);

                LocalDate dataPartida = LocalDate.parse(dados[2], DateTimeFormatter.ofPattern("d/M/yyyy"));
                String clubeMandante = dados[4];
                String clubeVisitante = dados[5];
                String clubeVencedor = dados[10];
                Estado estado = Estado.valueOf(dados[14]);
                Integer mandantePlacar = Integer.parseInt(dados[12]);
                Integer visitantePlacar = Integer.parseInt(dados[13]);

                EstatisticasJogo estatisticasJogo = new EstatisticasJogo(dataPartida, clubeVencedor, estado, mandantePlacar, visitantePlacar, clubeMandante, clubeVisitante);

                listaEstatisticasJogos.add(estatisticasJogo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaEstatisticasJogos;
    }

    public Map<Estado, Long> getEstadoComMenosJogos() throws IOException {
        List<EstatisticasJogo> listaEstatisticasJogo = getEstatisticasJogos();

        Map<Estado, Long> mapEstadoJogos = listaEstatisticasJogo.stream()
                .collect(Collectors.groupingBy(EstatisticasJogo::getEstado, Collectors.counting()));

        return mapEstadoJogos.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                ));
    }

    public Map<String, Long> getTimeQueMaisVenceu(Integer year) throws IOException {
        List<EstatisticasJogo> listaEstatisticasJogo = getEstatisticasJogos();

        Map<String, Long> mapTimeJogos = listaEstatisticasJogo.stream()
                .filter(jogo -> year.equals(jogo.getDataPartida().getYear()) )
                .filter(jogo -> !(jogo.getClubeVencedor().equals("-")) )
                .collect(Collectors.groupingBy(EstatisticasJogo::getClubeVencedor, Collectors.counting()));

        return mapTimeJogos.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                ));
    }

    public List<String> getMaioresPlacares() throws IOException {
        List<EstatisticasJogo> listaEstatisticasJogo = getEstatisticasJogos();

        return listaEstatisticasJogo.stream()
                .max(Comparator.comparing(EstatisticasJogo::getTotalGols))
                .map(jogo -> (jogo.getClubeMantante() + " " + jogo.getMandantePlacar() + " X "
                        + jogo.getVisitantePlacar() + " " + jogo.getClubeVisitante()))
                .stream().toList();
    }
}

