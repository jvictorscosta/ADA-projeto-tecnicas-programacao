package projeto;

import projeto.controllers.CampeonatoBrasileiro;
import projeto.repository.CartaoRepository;
import projeto.repository.EstatisticaRepository;
import projeto.repository.GolsRepository;
import projeto.repository.PartidaRepository;
import projeto.service.employee.Service;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        CampeonatoBrasileiro campeonatoBrasileiro = new CampeonatoBrasileiro();
        campeonatoBrasileiro.execute();
    }
}
