package controller.jogoDaDescoberta;

import model.Palavra;
import model.Usuario;
import view.jogoDaDescobertaView.JogoDaDescobertaView;

import java.util.List;
import java.util.Random;

public class JogoDaDescoberta {
    private JogoDaDescobertaView view = new JogoDaDescobertaView();
    private Usuario usuario;

    public JogoDaDescoberta(Usuario usuario) {
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
                view.mostrarMensagem("Você desistiu! A palavra era: " + palavra.getTexto());
                break;
            }

            if (palpite.equalsIgnoreCase(palavra.getTexto())) {
                view.mostrarMensagem("Parabéns! Você acertou!");
                break;
            } else {
                view.mostrarMensagem("Errado! Tente novamente.");
            }
        }
    }

    private String escolherPalavra() {
        Random random = new Random();
        List<String> banco = Palavra.getPalavradoBanco();
        return banco.get(random.nextInt(banco.size()));
    }
}
