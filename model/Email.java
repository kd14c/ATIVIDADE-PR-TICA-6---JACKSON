package model;

public class Email {
    private String endereco;
    private EmailStatus status;

    public Email(String endereco, EmailStatus status) {
        this.endereco = endereco;
        this.status = status;
    }

    public String getEndereco() {
        return endereco;
    }

    public EmailStatus getStatus() {
        return status;
    }
}