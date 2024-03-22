package pl.jslowiak.creditcard;

import java.util.Collections;

public class App {
    public static void main(String[] args)
    {
        var name = "Jakub";
        var message = String.format("Hello %s", name);

        var names = Collections.singletonList("Jakub Slowiak");

        System.out.println(message);
    }
}