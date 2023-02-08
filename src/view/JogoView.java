package view;

import controller.EstatisticasJogoController;
import enums.Estado;
import util.ConsoleUIHelper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JogoView {
    private static EstatisticasJogoController estatisticasJogoController;

    public JogoView() {
        if(estatisticasJogoController == null) {
            estatisticasJogoController = new EstatisticasJogoController();
        }
    }

    public static void imprimirDados() throws IOException {

        ConsoleUIHelper.drawHeader("ESTATÍSTICAS - TIMES | ESTADOS | OUTROS:", 80);

//        List<EstatisticasJogoController>

        imprimirDadosTimeQueMaisVenceu();

        imprimirDadosEstadoComMenosJogos();

        imprimirDadosMaiorPlacar();

    }

    private static void imprimirDadosTimeQueMaisVenceu() throws IOException {

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

        Map<Estado, Long> mapJogosPorEstado = estatisticasJogoController.getEstadoComMenosJogos();
        Long numeroJogosMenosEstado = mapJogosPorEstado.get(mapJogosPorEstado.keySet().iterator().next());
        System.out.println("Estado que teve menos jogos entre 2003-2022 (Estado | Jogos):");
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

        System.out.println("Placar da partida com mais gols(Time | Placar Mandante X Placar | Time Visitante):");
        for(String placar: maioresPlacares){
            System.out.println("\t" + placar);
        }
//        System.out.println(mapTimeQueMaisVenceu);
    }
}
