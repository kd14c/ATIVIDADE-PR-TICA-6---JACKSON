package view;

import model.Email;

import java.util.List;

public class EmailView {

    public void exibirResultado(List<Email> validos, List<Email> invalidos) {
        System.out.println("E-mails válidos: " + validos.size());
        System.out.println("E-mails inválidos: " + invalidos.size());
        System.out.println("\nLista de e-mails válidos:");
        validos.forEach(e -> System.out.println(e.getEndereco()));
    }

    public void exibirErro(String mensagem) {
        System.err.println("ERRO: " + mensagem);
    }
}
