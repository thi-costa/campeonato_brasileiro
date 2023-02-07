package view;

import controller.EstatisticasJogoController;
import enums.Estado;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JogoView {
    public static void imprimirDados() throws IOException {

        System.out.println("-=".repeat(45));
        System.out.println("ESTATÍSTICAS - TIMES | Estados | Outros:");
        System.out.println("-=".repeat(45));

//        List<EstatisticasJogoController>

        imprimirDadosTimeQueMaisVenceu();

        imprimirDadosEstadoComMenosJogos();

        imprimirDadosMaiorPlacar();

    }

    private static void imprimirDadosTimeQueMaisVenceu() throws IOException {
        EstatisticasJogoController estatisticasJogoController = new EstatisticasJogoController();

        Map<String, Long> mapTimeQueMaisVenceu = estatisticasJogoController.getTimeQueMaisVenceu(2008);
        Long numeroDeVitorias = mapTimeQueMaisVenceu.get(mapTimeQueMaisVenceu.keySet().iterator().next());

        System.out.println("Time que mais venceu jogos em 2008 (Estado | Vitórias):");
        for(Map.Entry<String, Long> entry: mapTimeQueMaisVenceu.entrySet()){
            if(numeroDeVitorias.equals(entry.getValue())){
                System.out.println("\t" + entry.getKey() + " | " + entry.getValue());
            }
        }
//        System.out.println(mapTimeQueMaisVenceu);
    }

    public static void imprimirDadosEstadoComMenosJogos() throws IOException {
        EstatisticasJogoController estatisticasJogoController = new EstatisticasJogoController();

        Map<Estado, Long> mapJogosPorEstado = estatisticasJogoController.getEstadoComMenosJogos();
        Long numeroJogosMenosEstado = mapJogosPorEstado.get(mapJogosPorEstado.keySet().iterator().next());
        System.out.println("O Estado que teve menos jogos entre 2003-2022 (Estado | Jogos):");
        for(Map.Entry<Estado, Long> entry: mapJogosPorEstado.entrySet()){
            if(numeroJogosMenosEstado.equals(entry.getValue())){
                System.out.println("\t" + entry.getKey() + " | " + entry.getValue());
            }
        }
//        System.out.println(mapJogosPorEstado);
    }

    public static void imprimirDadosMaiorPlacar() throws  IOException{
        EstatisticasJogoController estatisticasJogoController = new EstatisticasJogoController();

        List<String> maioresPlacares = estatisticasJogoController.getMaioresPlacares();

        System.out.println("O placar da partida com mais gols (Time Mandante Placar Mandante X Placar Visitante Time Visitante):");
        for(String placar: maioresPlacares){
            System.out.println("\t" + placar);
        }
//        System.out.println(mapTimeQueMaisVenceu);
    }
}
