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

                List<String> linhasList = linhasStream.toList();

                for(String linha: linhasList.subList(1, linhasList.size())){
                    String[] dados = linha.split(CSV_SEPARATOR);

                    LocalDate dataPartida = LocalDate.parse(dados[2].replace("\"", ""), DateTimeFormatter.ofPattern("d/M/yyyy"));
                    String clubeMandante = dados[4].replace("\"", "");
                    String clubeVisitante = dados[5].replace("\"", "");
                    String clubeVencedor = dados[10].replace("\"", "");
                    Estado estado = Estado.valueOf(dados[14].replace("\"", ""));
                    Integer mandantePlacar = Integer.parseInt(dados[12].replace("\"", ""));
                    Integer visitantePlacar = Integer.parseInt(dados[13].replace("\"", ""));

                    EstatisticasJogo estatisticasJogo = new EstatisticasJogo(dataPartida, clubeVencedor, estado, mandantePlacar, visitantePlacar, clubeMandante, clubeVisitante);

                    estatisticasJogos.add(estatisticasJogo);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
