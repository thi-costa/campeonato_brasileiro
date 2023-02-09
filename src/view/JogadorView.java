package view;

import controller.EstatisticasJogadorController;
import controller.EstatisticasJogoController;
import util.ConsoleUIHelper;

import java.io.IOException;
import java.util.Map;

public class JogadorView {
    private static EstatisticasJogadorController estatisticasJogadorController;

    public JogadorView() {
        if (estatisticasJogadorController == null) {
            estatisticasJogadorController = new EstatisticasJogadorController();
        }
    }

    public static void imprimirDados() throws IOException {

        ConsoleUIHelper.drawHeader("ESTATÍSTICAS - JOGADORES", 80);

        imprimirDadosJogadorComMaisGols("");
        imprimirDadosJogadorComMaisGols("Penalty");
        imprimirDadosJogadorComMaisGols("Gol Contra");

        imprimirDadosJogadorComMaisCartoes("Amarelo");
        imprimirDadosJogadorComMaisCartoes("Vermelho");

    }
    public static void imprimirDadosJogadorComMaisGols(String tipoDeGol) throws IOException {
        String descricaoGol = "";

        if(!tipoDeGol.equals("")){
            descricaoGol = descricaoGol + "de " + tipoDeGol + " ";
        }

        Map<String, Long> mapJogadorEGols = estatisticasJogadorController.getJogadorComMaisGols(tipoDeGol);

        Long qtdeGolsJogadorComMaisGols = mapJogadorEGols.get(mapJogadorEGols.keySet().iterator().next());

        System.out.println("Jogador com + gols " + descricaoGol + "(Jogador | Gols):");
        
        for(Map.Entry<String, Long> entry: mapJogadorEGols.entrySet()){
            if(qtdeGolsJogadorComMaisGols.equals(entry.getValue())){
                System.out.printf("\t%s | %d gols\n", entry.getKey(), entry.getValue());
            }
        }
    }

    public static void imprimirDadosJogadorComMaisCartoes(String tipoDeCartao) throws IOException {

        Map<String, Long> mapJogadorECartoes = estatisticasJogadorController.getJogadorComMaisCartoes(tipoDeCartao);

        Long qtdeCartoesJogadorComMaisCartoes = mapJogadorECartoes.get(mapJogadorECartoes.keySet().iterator().next());

        System.out.println("Jogador com + cartões " + tipoDeCartao + "s (Jogador | Cartões):");
        
        for(Map.Entry<String, Long> entry: mapJogadorECartoes.entrySet()){
            if(qtdeCartoesJogadorComMaisCartoes.equals(entry.getValue())){
                System.out.printf("\t%s | %d\n", entry.getKey(), entry.getValue());
            }
        }
    }
}
