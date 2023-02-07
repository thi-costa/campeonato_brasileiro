package controller;

import model.EstatisticasJogadorCartoes;
import model.EstatisticasJogadorGols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstatisticasJogadorController {
    public List<EstatisticasJogadorGols> getEstatisticasJogadorGols() throws IOException {
        List<EstatisticasJogadorGols> listaEstatisticasJogadorGols = new ArrayList<>();

        String urlString = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/master/campeonato-brasileiro-gols.csv";
        final String CSV_SEPARATOR = ",";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();



        if(connection.getResponseCode() == 200){
            try(InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader br = new BufferedReader(streamReader);
                Stream<String> lines = br.lines()){

                List<String> linhas = lines.toList();
                int contLinhas = 0;

                for(String linha: linhas){
                    if(contLinhas == 0){
                        contLinhas++;
                        continue;
                    }
                    String[] dados = linha.split(CSV_SEPARATOR);

                    Integer partidaId = Integer.parseInt(dados[0].replace("\"", ""));
                    Integer rodada = Integer.parseInt(dados[1].replace("\"", ""));
                    String clube = dados[2].replace("\"", "");
                    String atleta = dados[3].replace("\"", "");
                    String minuto = dados[4].replace("\"", "");
                    String tipoDeGol = dados[5].replace("\"", "");

                    EstatisticasJogadorGols estatisticasJogadorGols = new EstatisticasJogadorGols(partidaId, rodada, clube, atleta, minuto, tipoDeGol);

                    listaEstatisticasJogadorGols.add(estatisticasJogadorGols);
                }

            } catch (IOException e){
                e.printStackTrace();
            }
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

        String urlString = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/master/campeonato-brasileiro-cartoes.csv";
        final String CSV_SEPARATOR = ",";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        if(connection.getResponseCode() == 200) {
            try (InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                 BufferedReader br = new BufferedReader(streamReader);
                 Stream<String> lines = br.lines()) {

                List<String> linhas = lines.toList();
                int contLinhas = 0;

                for (String linha : linhas) {
                    if (contLinhas == 0) {
                        contLinhas++;
                        continue;
                    }
                    String[] dados = linha.split(CSV_SEPARATOR);

                    Integer partidaId = Integer.parseInt(dados[0].replace("\"", ""));
                    Integer rodada = Integer.parseInt(dados[1].replace("\"", ""));
                    String clube = dados[2].replace("\"", "");
                    String cartao = dados[3].replace("\"", "");
                    String atleta = dados[4].replace("\"", "");
                    Integer numCamisa = 1;
                    String posicao = dados[5].replace("\"", "");
                    String minuto = dados[5].replace("\"", "");

                    EstatisticasJogadorCartoes estatisticasJogadorCartoes = new EstatisticasJogadorCartoes(
                            partidaId, rodada, clube, cartao, atleta, numCamisa, posicao, minuto
                    );

                    listaEstatisticasJogadorCartoes.add(estatisticasJogadorCartoes);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
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
