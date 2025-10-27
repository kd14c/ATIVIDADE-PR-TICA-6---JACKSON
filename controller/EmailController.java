package controller;

import model.Email;
import model.EmailStatus;
import service.EmailService;
import view.EmailView;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class EmailController {

    private final EmailService service;
    private final EmailView view;

    public EmailController() {
        this.service = new EmailService();
        this.view = new EmailView();
    }

    public void executar() {
        try {
            List<Email> emails = service.buscarEmailsDaAPI();

            List<Email> validos = emails.stream()
                    .filter(e -> e.getStatus() == EmailStatus.VALIDO)
                    .collect(Collectors.toList());

            List<Email> invalidos = emails.stream()
                    .filter(e -> e.getStatus() == EmailStatus.INVALIDO)
                    .collect(Collectors.toList());

            view.exibirResultado(validos, invalidos);

        } catch (IOException e) {
            view.exibirErro("Erro ao acessar API: " + e.getMessage());
        }
    }
}