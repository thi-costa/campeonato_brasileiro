import util.ConsoleUIHelper;
import view.Menu;

public class App {
    public static void main(String[] args) {
        ConsoleUIHelper.drawHeader("Programa - Estatísticas do Brasileirão (2003-2022)", 80);

        Menu.imprimirDados();

        ConsoleUIHelper.drawHeader("PROGRAMA FINALIZADO!", 80);
    }
}
