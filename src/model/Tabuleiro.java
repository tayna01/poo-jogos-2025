package model;

import java.util.Random;

public class Tabuleiro {
    private char[][] matriz;
    private int tamanho;

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        this.matriz = new char[tamanho][tamanho];
        preencherComLetrasAleatorias();
    }

    private void preencherComLetrasAleatorias() {
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = (char) ('A' + random.nextInt(26));
            }
        }
    }

    public void esconderPalavra(Palavra palavra) {
        String texto = palavra.getTexto().toUpperCase();
        Random random = new Random();
        int linha = random.nextInt(tamanho);
        int coluna = random.nextInt(tamanho - texto.length());

        for (int i = 0; i < texto.length(); i++) {
            matriz[linha][coluna + i] = texto.charAt(i);
        }
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
