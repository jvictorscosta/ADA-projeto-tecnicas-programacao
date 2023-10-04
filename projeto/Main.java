package projeto;

import projeto.controllers.CampeonatoBrasileiro;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CampeonatoBrasileiro campeonatoBrasileiro = new CampeonatoBrasileiro();
        campeonatoBrasileiro.execute();
    }
}
