package projeto.service.employee;

import projeto.repository.CartaoRepository;
import projeto.repository.EstatisticaRepository;
import projeto.repository.GolsRepository;
import projeto.repository.PartidaRepository;

public class Service {
    private CartaoRepository cartaoRepository;
    private EstatisticaRepository estatisticaRepository;
    private GolsRepository golsRepository;
    private PartidaRepository partidaRepository;

    public Service(CartaoRepository cartaoRepository, EstatisticaRepository estatisticaRepository, GolsRepository golsRepository, PartidaRepository partidaRepository) {
        this.cartaoRepository = cartaoRepository;
        this.estatisticaRepository = estatisticaRepository;
        this.golsRepository = golsRepository;
        this.partidaRepository = partidaRepository;
    }
    public String mostrarTimeComMaisVitoria ( ){
        String ano="2008";
        //partidaRepository.obterPartidas().stream().filter(partida -> partida.getData().)


        return null;
    }
}
