package controller;

import model.Palavra;
import model.Tabuleiro;
import model.Usuario;
import view.JogoCacaPalavrasView;

import java.util.List;
import java.util.Random;

public class JogoCacaPalavrasController {
    private Usuario usuario;
    private JogoCacaPalavrasView view;
    private Tabuleiro tabuleiro;
    private Palavra palavraEscolhida;

    private List<String> bancoDePalavras = List.of("JAVA", "PROGRAMA", "CLASSE", "OBJETO", "ENCAPSULAMENTO", "HERANÇA", "FUNÇÃO");

    public JogoCacaPalavrasController(Usuario usuario, JogoCacaPalavrasView view) {
        this.usuario = usuario;
        this.view = view;
    }

    public void iniciarJogo() {
        palavraEscolhida = new Palavra(escolherPalavraAleatoria());
        tabuleiro = new Tabuleiro(10);
        tabuleiro.esconderPalavra(palavraEscolhida);

        view.mostrarMensagem("Bem-vindo, " + usuario.getNome() + "!");
        tabuleiro.exibir();

        if (view.desejaDica()) {
            view.mostrarMensagem("Dica: começa com '" + palavraEscolhida.getPrimeiraLetra() +
                    "' e termina com '" + palavraEscolhida.getUltimaLetra() + "'");
        }

        String palpite = view.pedirPalpite();
        if (palpite.equalsIgnoreCase(palavraEscolhida.getTexto())) {
            view.mostrarMensagem("Parabéns, você acertou!");
        } else {
            view.mostrarMensagem("Palavra errada. A palavra era: " + palavraEscolhida.getTexto());
        }
    }

    private String escolherPalavraAleatoria() {
        Random random = new Random();
        return bancoDePalavras.get(random.nextInt(bancoDePalavras.size()));
    }
}
