package view;

import java.util.Scanner;

public class JogoCacaPalavrasView {
    private Scanner scanner = new Scanner(System.in);

    public String pedirPalpite() {
        System.out.print("Qual é a palavra escondida? ");
        return scanner.nextLine();
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }

    public boolean desejaDica() {
        System.out.print("Deseja uma dica? (s/n): ");
        return scanner.nextLine().equalsIgnoreCase("s");
    }
}
