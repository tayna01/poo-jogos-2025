package controller.jogoDaDescoberta;

import model.jogoDaDescoberta.Palavra;
import model.jogoDaDescoberta.User;
import view.jogoDaDescobertaView.JogoDaDescobertaView;

import java.util.List;
import java.util.Random;

public class JogoDaDescobertaController {
    private List<String> bancoDePalavras = List.of("JAVA", "PROGRAMA", "CÓDIGO", "OBJETO", "FUNÇÃO", "MÉTODO");
    private JogoDaDescobertaView view = new JogoDaDescobertaView();
    private User usuario;

    public JogoDaDescobertaController(User usuario) {
        this.usuario = usuario;
    }

    public void iniciarJogo() {
        view.mostrarMensagem("Olá, " + usuario.getNome() + "! Vamos jogar!");

        Palavra palavra = new Palavra(escolherPalavra());
        String embaralhada = palavra.embaralhar();

        view.mostrarMensagem("Palavra embaralhada: " + embaralhada);

        if (view.desejaDica()) {
            view.mostrarMensagem(palavra.getDica());
        }

        while (true) {
            String palpite = view.solicitarPalpite();

            if (palpite.equalsIgnoreCase("sair")) {
                view.mostrarMensagem("Você desistiu! A palavra era: " + palavra.getTextoOriginal());
                break;
            }

            if (palpite.equalsIgnoreCase(palavra.getTextoOriginal())) {
                view.mostrarMensagem("Parabéns! Você acertou!");
                break;
            } else {
                view.mostrarMensagem("Errado! Tente novamente.");
            }
        }
    }

    private String escolherPalavra() {
        Random random = new Random();
        return bancoDePalavras.get(random.nextInt(bancoDePalavras.size()));
    }
}
