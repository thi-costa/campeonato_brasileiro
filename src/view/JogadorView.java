package view;

import controller.EstatisticasJogadorController;

import java.io.IOException;
import java.util.Map;

public class JogadorView {
    public static void imprimirDados() throws IOException {
        System.out.println("ESTATÍSTICAS - JOGADORES");
        System.out.println("-=".repeat(45));

        imprimirDadosJogadorComMaisGols("");
        imprimirDadosJogadorComMaisGols("Penalty");
        imprimirDadosJogadorComMaisGols("Gol Contra");

        imprimirDadosJogadorComMaisCartoes("Amarelo");
        imprimirDadosJogadorComMaisCartoes("Vermelho");

    }
    public static void imprimirDadosJogadorComMaisGols(String tipoDeGol) throws IOException {
        EstatisticasJogadorController estatisticasJogadorController = new EstatisticasJogadorController();
        String descricaoGol = "";

        if(!tipoDeGol.equals("")){
            descricaoGol = descricaoGol + "de " + tipoDeGol + " ";
        }

        Map<String, Long> mapJogadorEGols = estatisticasJogadorController.getJogadorComMaisGols(tipoDeGol);
        System.out.println("Jogador com + gols " + descricaoGol + "(Jogador | Gols): \n\t"
                + mapJogadorEGols.keySet().iterator().next() +" | "
                + mapJogadorEGols.get(mapJogadorEGols.keySet().iterator().next()) + " gols");
//            System.out.println(mapJogadorEGols);
    }

    public static void imprimirDadosJogadorComMaisCartoes(String tipoDeCartao) throws IOException {
        EstatisticasJogadorController estatisticasJogadorController = new EstatisticasJogadorController();

        Map<String, Long> mapJogadorECartoesAmarelos = estatisticasJogadorController.getJogadorComMaisCartoes(tipoDeCartao);
        System.out.println("Jogador com + cartões " + tipoDeCartao + "s (Jogador | Cartões): \n\t"
                + mapJogadorECartoesAmarelos.keySet().iterator().next() + " | "
                + mapJogadorECartoesAmarelos.get(mapJogadorECartoesAmarelos.keySet().iterator().next()) + " cartões" );
    }
}
