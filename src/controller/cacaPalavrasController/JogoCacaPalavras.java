package controller.cacaPalavrasController;

import model.Palavra;
import model.Tabuleiro;
import model.Usuario;
import view.jogoCacaPalavrasView.JogoCacaPalavrasView;

import java.util.List;
import java.util.Random;

public class JogoCacaPalavras {
    private Usuario usuario;
    private JogoCacaPalavrasView view;
    private Tabuleiro tabuleiro;
    private Palavra palavraEscolhida;


    public JogoCacaPalavras(Usuario usuario) {
        this.usuario = usuario;
        this.view = new JogoCacaPalavrasView();
    }

    public void iniciarJogo() {
        palavraEscolhida = new Palavra(escolherPalavraAleatoria());
        tabuleiro = new Tabuleiro(10);
        tabuleiro.esconderPalavra(palavraEscolhida);

        view.mostrarMensagem("Bem-vindo, " + usuario.getNome() + "!");
        tabuleiro.exibir();

        if (view.desejaDica()) {
            view.mostrarMensagem("Dica: começa com '" + palavraEscolhida.getPrimeiraLetra() +
                    "' e termina com '" + palavraEscolhida.getUltimaLetra() + "'.");
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
        List<String> banco = Palavra.getPalavradoBanco();
        return banco.get(random.nextInt(banco.size())); //usa o numero como indice para pegar um elemento
    }
}
