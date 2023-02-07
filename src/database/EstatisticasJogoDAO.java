package database;

import enums.Estado;
import model.EstatisticasJogo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EstatisticasJogoDAO {
    private static EstatisticasJogoDAO instance;
    private List<EstatisticasJogo> estatisticasJogos;

    private EstatisticasJogoDAO(){
        estatisticasJogos = new ArrayList<>();
        carregarListaEstatisticaJogos();
    }

    public void carregarListaEstatisticaJogos(){
        try{
            String urlString = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/master/campeonato-brasileiro-full.csv";
            final String CSV_SEPARATOR = ",";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if(connection.getResponseCode() == 200){
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader br = new BufferedReader(streamReader);

                Stream<String> linhasStream = br.lines();

                List<String> linhasList = linhasStream.map(s -> s.replaceAll("\"", "")).toList();

                for(String linha: linhasList.subList(1, linhasList.size())){

                    String[] dados = linha.split(CSV_SEPARATOR);

                    LocalDate dataPartida = LocalDate.parse(dados[2], DateTimeFormatter.ofPattern("d/M/yyyy"));
                    String clubeMandante = dados[4];
                    String clubeVisitante = dados[5];
                    String clubeVencedor = dados[10];
                    Estado estado = Estado.valueOf(dados[14]);
                    Integer mandantePlacar = Integer.parseInt(dados[12]);
                    Integer visitantePlacar = Integer.parseInt(dados[13]);

                    EstatisticasJogo estatisticasJogo = new EstatisticasJogo(dataPartida, clubeVencedor, estado, mandantePlacar, visitantePlacar, clubeMandante, clubeVisitante);

                    estatisticasJogos.add(estatisticasJogo);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//// add essa linha para evitar o replace em todas as linhas de vetor List<String> linhas = lines.map(s -> s.replaceAll("\"", "")).toList();
}
