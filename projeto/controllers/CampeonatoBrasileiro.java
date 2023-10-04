package projeto.controllers;

import projeto.repository.CartaoRepository;
import projeto.repository.EstatisticaRepository;
import projeto.repository.GolsRepository;
import projeto.repository.PartidaRepository;
import projeto.service.employee.Service;

import java.io.IOException;

public class CampeonatoBrasileiro {

    public void execute() throws IOException {
    showMenu();
        CartaoRepository cartaoRepository = new CartaoRepository();
        EstatisticaRepository estatisticaRepository = new EstatisticaRepository();
        GolsRepository golsRepository = new GolsRepository();
        PartidaRepository partidaRepository = new PartidaRepository();
        Service service = new Service(cartaoRepository,estatisticaRepository, golsRepository,  partidaRepository);
        System.out.println(service.mostrarTimeComMaisVitoria());
        System.out.println(service.mostrarJogadorComMaisGols());
        System.out.println(service.mostrarJogadorComMaisGolsPenaltis());
        System.out.println(service.mostrarJogadorComMaisGolsContra());
        System.out.println(service.mostrarPartidasComMaisGols());
        System.out.println(service.estadiosComMenosJogos());
        System.out.println(service.jogadorComMaisAmarelos());
        System.out.println(service.jogadorComMaisVermelhos());

    }
    public void showMenu(){
        System.out.println("Olá, bem vindo ao portal do Campeonato Brasileiro");
        System.out.println("Selecione uma opção abaixo:");
        System.out.println();
        System.out.println("O time que mais venceu jogos no ano 2008");
        System.out.println("O Estado que teve menos jogos dentro do período 2003 e 2022");
        System.out.println("O jogador que mais fez gols");
        System.out.println("O jogador que mais fez gols de pênaltis");
        System.out.println("O jogador que mais fez gols contras");
        System.out.println("O jogador que mais recebeu cartões amarelos");
        System.out.println("O jogador que mais recebeu cartões vermelhos");
        System.out.println("O placar da partida com mais gols.");

    }






}
