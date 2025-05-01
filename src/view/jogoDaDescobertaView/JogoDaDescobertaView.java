package view.jogoDaDescobertaView;

import java.util.Scanner;

public class JogoDaDescobertaView {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public String solicitarPalpite() {
        System.out.print("Digite seu palpite (ou 'sair' para desistir): ");
        return scanner.nextLine();
    }

    public boolean desejaDica() {
        System.out.print("Deseja uma dica? (s/n): ");
        String resposta = scanner.nextLine();
        return resposta.equalsIgnoreCase("s");
    }
}

