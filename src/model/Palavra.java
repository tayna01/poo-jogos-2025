package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public String embaralhar() {
        List<Character> letras = new ArrayList<>();
        for (char c : texto.toCharArray()) {
            letras.add(c);
        }
        String embaralhada;
        do {
            Collections.shuffle(letras);
            embaralhada = getTextoEmbaralhado(letras);
        } while (texto.equals(embaralhada));

        return embaralhada;
    }

    private String getTextoEmbaralhado(List<Character> letras) {
        StringBuilder sb = new StringBuilder();
        for (char c : letras) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String getDica() {
        return "Dica: começa com '" + texto.charAt(0) + "' e termina com '" + texto.charAt(texto.length() - 1) + "'";
    }

    public static List<String> getPalavradoBanco() {
        return List.of("JAVA", "PROGRAMA", "CLASSE", "OBJETO", "ENCAPSULAMENTO", "HERANÇA", "FUNÇÃO");
    }
}
