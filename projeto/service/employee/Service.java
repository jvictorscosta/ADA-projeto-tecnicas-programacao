package projeto.service.employee;

import projeto.domain.Cartao;
import projeto.repository.CartaoRepository;
import projeto.repository.EstatisticaRepository;
import projeto.repository.GolsRepository;
import projeto.repository.PartidaRepository;
import projeto.domain.Partida;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
    public String mostrarTimeComMaisVitoria ( ) throws IOException {
        String ano="2008";
        Map<String, Long> vitoriasPorTime = partidaRepository.obterPartidas().stream()
                .filter(partida -> {
                    LocalDate data = partida.getData();
                    return data != null && data.getYear() == Integer.parseInt(ano);
                })
                .filter(partida -> !partida.getVencedor().equalsIgnoreCase("-"))
                .collect(Collectors.groupingBy(Partida::getVencedor, Collectors.counting()));

        Long maximoVitorias = vitoriasPorTime.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L);

        List<String> timesComMaisVitorias = vitoriasPorTime.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maximoVitorias))
                .map(Map.Entry::getKey)
                .toList();

        return timesComMaisVitorias.toString();
    }

    public String estadiosComMenosJogos() throws IOException {
        Map<String, Long> estadioComMenosJogos = partidaRepository.obterPartidas().stream()
                .collect(Collectors.groupingBy(Partida::getArena, Collectors.counting()));

        Long menosJogos = Collections.min(estadioComMenosJogos.values());

        List<String> arenaComMenosJogos = estadioComMenosJogos.entrySet().stream()
                .filter(entry -> entry.getValue().equals(menosJogos))
                .map(Map.Entry::getKey)
                .toList();

        return arenaComMenosJogos.toString();
    }

    public String jogadorComMaisAmarelos() throws IOException {
        Map<String, Long> maisAmarelos = cartaoRepository.obterCartoes().stream()
                .filter(cartao -> "Amarelo".equalsIgnoreCase(cartao.getCartao()))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()));

        Long maxAmarelosValue = Collections.max(maisAmarelos.values());
        List<String> jogadoresComMaxAmarelos = maisAmarelos.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxAmarelosValue))
                .map(Map.Entry::getKey)
                .toList();

        return jogadoresComMaxAmarelos.toString();
    }

    public String jogadorComMaisVermelhos() throws IOException {
        Map<String, Long> maisVermelhos = cartaoRepository.obterCartoes().stream()
                .filter(cartao -> "Vermelho".equalsIgnoreCase(cartao.getCartao()))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()));

        Long maxVermelhosValue = Collections.max(maisVermelhos.values());
        List<String> jogadoresComMaxVermelhos = maisVermelhos.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxVermelhosValue))
                .map(Map.Entry::getKey)
                .toList();

        return jogadoresComMaxVermelhos.toString();
    }


}
