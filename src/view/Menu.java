package view;

public class Menu {
    public static void imprimirDados(){
        try{
            JogadorView.imprimirDados();
            JogoView.imprimirDados();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
