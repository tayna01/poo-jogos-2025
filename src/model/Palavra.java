package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Palavra {
    private String texto;
    private String textoOriginal;


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

    public String getTextoOriginal() {
        return textoOriginal;
    }

    public String embaralhar() {
        List<Character> letras = new ArrayList<>();
        for (char c : textoOriginal.toCharArray()) {
            letras.add(c);
        }
        do {
            Collections.shuffle(letras);
        } while (textoOriginal.equals(getTextoEmbaralhado(letras)));

        return getTextoEmbaralhado(letras);
    }

    private String getTextoEmbaralhado(List<Character> letras) {
        StringBuilder sb = new StringBuilder();
        for (char c : letras) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String getDica() {
        return "Dica: começa com '" + textoOriginal.charAt(0) + "' e termina com '" + textoOriginal.charAt(textoOriginal.length() - 1) + "'";
    }


    public static List<String> getPalavradoBanco(){
        return List.of("JAVA", "PROGRAMA", "CLASSE", "OBJETO", "ENCAPSULAMENTO", "HERANÇA", "FUNÇÃO");
    }

}
