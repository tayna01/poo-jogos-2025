import controller.cacaPalavrasController.JogoCacaPalavras;
import controller.jogoDaDescoberta.JogoDaDescoberta;
import model.Usuario;
import view.jogoCacaPalavrasView.JogoCacaPalavrasView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            System.out.println("=== MENU DE JOGOS ===");
            System.out.println("1 - Jogo Caça-Palavras");
            System.out.println("2 - Jogo da Descoberta");
            System.out.print("Escolha o número do jogo: ");
            String opcao = scanner.nextLine();

            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            Usuario usuario = new Usuario(nome);

            switch (opcao) {
                case "1":
                    JogoCacaPalavrasView viewCaca = new JogoCacaPalavrasView();
                    JogoCacaPalavras controllerCaca = new JogoCacaPalavras(usuario, viewCaca);
                    controllerCaca.iniciarJogo();
                    break;
                case "2":
                    JogoDaDescoberta controllerDescoberta = new JogoDaDescoberta(usuario);
                    controllerDescoberta.iniciarJogo();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.print("Deseja jogar novamente? (s/n): ");
            continuar = scanner.nextLine();
        } while (!continuar.equalsIgnoreCase("n"));

        scanner.close();
        System.out.println("Jogo finalizado. Até a próxima!");
    }
}
