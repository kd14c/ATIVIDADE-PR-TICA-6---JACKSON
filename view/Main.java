package view;

import controller.EmailController;

public class Main {
    public static void main(String[] args) {
        EmailController controller = new EmailController();
        controller.executar();
    }
}