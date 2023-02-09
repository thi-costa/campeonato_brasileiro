package controller;

import model.EstatisticasJogadorCartoes;
import model.EstatisticasJogadorGols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstatisticasJogadorController {
    private static final String CSV_SEPARATOR = ",";

    public List<EstatisticasJogadorGols> getEstatisticasJogadorGols() throws IOException {
        Path path = Paths.get("src/dados/campeonato-brasileiro-gols.csv");
        List<EstatisticasJogadorGols> listaEstatisticasJogadorGols = new ArrayList<>();

        try (Stream<String> lines = Files.lines(path)) {

            List<String> linhas = lines.map(s -> s.replaceAll("\"", "")).collect(Collectors.toList());
            linhas.remove(0);

            for (String linha : linhas) {
                String [] dados = linha.split(CSV_SEPARATOR, -1);

                Integer partidaId = Integer.parseInt(dados[0]);
                Integer rodada = Integer.parseInt(dados[1]);
                String clube = dados[2];
                String atleta = dados[3];
                String minuto = dados[4];
                String tipoGol = dados[5];

                EstatisticasJogadorGols gol = new EstatisticasJogadorGols(partidaId, rodada, clube, atleta, minuto, tipoGol);
                listaEstatisticasJogadorGols.add(gol);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaEstatisticasJogadorGols;
    }

    public Map<String, Long> getJogadorComMaisGols(String tipoDeGol) throws IOException {
        List<EstatisticasJogadorGols> listaEstatisticasJogadorGols = getEstatisticasJogadorGols();

        Map<String, Long> mapJogadorEGols = listaEstatisticasJogadorGols.stream()
                .filter(j -> j.getTipoDeGol().contains(tipoDeGol))
                .collect(Collectors.groupingBy(EstatisticasJogadorGols::getAtleta, Collectors.counting()));

        return mapJogadorEGols.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                ));
    }
    public List<EstatisticasJogadorCartoes> getEstatisticasJogadorCartoes() throws IOException {
        List<EstatisticasJogadorCartoes> listaEstatisticasJogadorCartoes = new ArrayList<>();
        Path path = Paths.get("src/dados/campeonato-brasileiro-cartoes.csv");

        try (
                Stream<String> lines = Files.lines(path)) {

            List<String> linhas = lines.map(s -> s.replaceAll("\"", "")).collect(Collectors.toList());
            linhas.remove(0);

            for (String linha : linhas) {
                String[] dados = linha.split(CSV_SEPARATOR, -1);

                Integer partidaId = Integer.parseInt(dados[0]);
                Integer rodada = Integer.parseInt(dados[1]);
                String clube = dados[2];
                String tipoCartao = dados[3];
                String atleta = dados[4];
                String posicao = dados[6];

                EstatisticasJogadorCartoes estatisticasJogadorCartoes = new EstatisticasJogadorCartoes(partidaId, rodada, clube, tipoCartao, atleta, posicao);
                listaEstatisticasJogadorCartoes.add(estatisticasJogadorCartoes);
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return listaEstatisticasJogadorCartoes;

    }

    public Map<String, Long> getJogadorComMaisCartoes(String cartao) throws IOException{
        List<EstatisticasJogadorCartoes> listaEstatisticasJogadorCartoes = getEstatisticasJogadorCartoes();

        Map<String, Long> mapJogadorECartoes = listaEstatisticasJogadorCartoes.stream()
                .filter(j -> j.getCartao().contains(cartao))
                .collect(Collectors.groupingBy(EstatisticasJogadorCartoes::getAtleta, Collectors.counting()));

        return mapJogadorECartoes.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                ));
    }
}
