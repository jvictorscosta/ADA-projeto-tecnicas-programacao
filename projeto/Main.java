package projeto;

import projeto.controllers.CampeonatoBrasileiro;
import projeto.repository.CartaoRepository;
import projeto.repository.EstatisticaRepository;
import projeto.repository.GolsRepository;
import projeto.repository.PartidaRepository;
import projeto.service.employee.Service;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        CartaoRepository cartaoRepository = new CartaoRepository();
        EstatisticaRepository estatisticaRepository = new EstatisticaRepository();
        GolsRepository golsRepository = new GolsRepository();
        PartidaRepository partidaRepository = new PartidaRepository();
        Service service = new Service(cartaoRepository,estatisticaRepository, golsRepository,  partidaRepository);

        CampeonatoBrasileiro campeonatoBrasileiro = new CampeonatoBrasileiro();
        campeonatoBrasileiro.showMenu();
        Scanner sc = new Scanner(System.in);
        Integer opcaoDesejada = sc.nextInt();

        while (opcaoDesejada != 0){
            switch (opcaoDesejada){
                case 1:
                    System.out.println("Os times que mais venceram no ano de 2008: ");
                    String nomesDosTimes = String.join(", ", service.mostrarTimeComMaisVitoria());
                    System.out.println(nomesDosTimes);
                    break;
                case 2:
                    System.out.println("Os estados com menos jogos no período de 2003 - 2008: ");
                    String estadosComMenosJogos = String.join(", ", service.estadoComMenosJogos());
                    System.out.println(estadosComMenosJogos);
                    break;
                case 3:
                    System.out.println("O jogador que mais fez gols: ");
                    String nomeDoJogador = String.join(", ", service.jogadorComMaisGols());
                    System.out.println(nomeDoJogador);
                    break;
                case 4:
                    System.out.println("O jogador que mais fez gols de pênalti: ");
                    String nomeDoJogadorPenalti = String.join(", ", service.jogadorComMaisGolsPenaltis());
                    System.out.println(nomeDoJogadorPenalti);
                    break;
                case 5:
                    System.out.println("Os jogadores que mais fizeram gols contras: ");
                    String nomeDoJogadorGolContra = String.join(", ", service.jogadorComMaisGolsContra());
                    System.out.println(nomeDoJogadorGolContra);
                    break;
                case 6:
                    System.out.println("O jogador que mais recebeu cartões amarelos: ");
                    String nomeDoJogadorAmarelo = String.join(", ", service.jogadorComMaisAmarelos());
                    System.out.println(nomeDoJogadorAmarelo);
                    break;
                case 7:
                    System.out.println("O jogador que mais recebeu cartões vermelhos: ");
                    String nomeDoJogadorVermelho = String.join(", ", service.jogadorComMaisVermelhos());
                    System.out.println(nomeDoJogadorVermelho);
                    break;
                case 8:
                    service.mostrarPartidasComMaisGols();
                    break;
                default:
                    System.out.println("Opção inválida. Tente noamente.");
            }
            System.out.println("Informe a próxima opção(ou 0 para sair): ");
            opcaoDesejada = sc.nextInt();
        }

        sc.close();
    }
}
