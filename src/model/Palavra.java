package model;

public class Palavra {
    private String texto;

    public Palavra(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public char getPrimeiraLetra() {
        return texto.charAt(0);
    }

    public char getUltimaLetra() {
        return texto.charAt(texto.length() - 1);
    }
}
