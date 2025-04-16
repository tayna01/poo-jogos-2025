package model.jogoDaDescoberta;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Palavra {
    private String textoOriginal;

    public Palavra(String textoOriginal) {
        this.textoOriginal = textoOriginal;
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
}

