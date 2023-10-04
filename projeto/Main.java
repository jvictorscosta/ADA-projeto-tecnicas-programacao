package projeto;

import projeto.repository.CartaoRepository;
import projeto.repository.EstatisticaRepository;
import projeto.repository.GolsRepository;
import projeto.repository.PartidaRepository;
import projeto.service.employee.Service;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CartaoRepository cartaoRepository = new CartaoRepository();
        EstatisticaRepository estatisticaRepository = new EstatisticaRepository();
        GolsRepository golsRepository = new GolsRepository();
        PartidaRepository partidaRepository = new PartidaRepository();

        Service service = new Service(cartaoRepository, estatisticaRepository, golsRepository, partidaRepository);

        System.out.println(service.mostrarTimeComMaisVitoria());
        System.out.println(service.estadiosComMenosJogos());
        System.out.println(service.jogadorComMaisAmarelos());
        System.out.println(service.jogadorComMaisVermelhos());
    }
}
