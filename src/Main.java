import controller.cacaPalavrasController.JogoCacaPalavrasController;
import model.jogoCacaPalavras.Usuario;
import view.jogoCacaPalavrasView.JogoCacaPalavrasView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();

            Usuario usuario = new Usuario(nome);
            JogoCacaPalavrasView view = new JogoCacaPalavrasView();
            JogoCacaPalavrasController controller = new JogoCacaPalavrasController(usuario, view);

            controller.iniciarJogo();

            System.out.println("Você deseja jogar novamente? (s/n)");
            continuar = scanner.nextLine();
        } while (!continuar.equalsIgnoreCase("n"));

        scanner.close();
        System.out.println("Jogo finalizado. Até a próxima!");
    }
}
