package view;

public class Menu {
    public static void imprimirDados(){
        JogadorView jogadorView = new JogadorView();
        JogoView jogoView = new JogoView();
        try{
            jogadorView.imprimirDados();
            jogoView.imprimirDados();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
