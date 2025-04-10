import controller.JogoCacaPalavrasController;
import model.Usuario;
import view.JogoCacaPalavrasView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        Usuario usuario = new Usuario(nome);
        JogoCacaPalavrasView view = new JogoCacaPalavrasView();
        JogoCacaPalavrasController controller = new JogoCacaPalavrasController(usuario, view);

        controller.iniciarJogo();
    }
}
