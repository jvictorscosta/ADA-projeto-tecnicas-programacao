package projeto.service.employee;

import projeto.domain.Gol;
import projeto.repository.CartaoRepository;
import projeto.repository.EstatisticaRepository;
import projeto.repository.GolsRepository;
import projeto.repository.PartidaRepository;
import projeto.domain.Partida;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
        System.out.println("Time com Mais Vitorias em "+ ano);
        return timesComMaisVitorias.toString();
    }
    public List<String> mostrarJogadorComMaisGols() throws IOException {
        Map<String,Long> jogadorPorGol = golsRepository.obterGols().stream()
                .filter(gol -> !gol.getTipo_de_gol().equalsIgnoreCase("Penalty"))
                .collect(Collectors.groupingBy(Gol::getAtleta,Collectors.counting()));
        Long maximoGols = jogadorPorGol.values().stream().max(Comparator.naturalOrder()).orElse(0L);
        List<String> jogadorComMaisGols = jogadorPorGol.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maximoGols))
                .map(Map.Entry::getKey).toList();
        System.out.println("Jogador ou Jogadores com mais Gols: ");
        return jogadorComMaisGols;
    }


}
