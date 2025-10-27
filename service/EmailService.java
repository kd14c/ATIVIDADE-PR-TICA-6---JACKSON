package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Email;
import model.EmailStatus;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailService {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    public List<Email> buscarEmailsDaAPI() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("https://jsonplaceholder.typicode.com/comments");
        JsonNode root = mapper.readTree(url);

        List<Email> listaEmails = new ArrayList<>();

        for (JsonNode node : root) {
            Optional<String> emailOpt = Optional.ofNullable(node.get("email"))
                                                .map(JsonNode::asText);

            emailOpt.ifPresent(email -> {
                Matcher matcher = EMAIL_PATTERN.matcher(email);
                EmailStatus status = matcher.matches() ? EmailStatus.VALIDO : EmailStatus.INVALIDO;
                listaEmails.add(new Email(email, status));
            });
        }
        return listaEmails;
    }
}