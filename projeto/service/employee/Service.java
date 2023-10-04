package projeto.service.employee;

import projeto.domain.Gol;
import projeto.domain.Cartao;
import projeto.repository.CartaoRepository;
import projeto.repository.EstatisticaRepository;
import projeto.repository.GolsRepository;
import projeto.repository.PartidaRepository;
import projeto.domain.Partida;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
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
    public List<String> mostrarTimeComMaisVitoria ( ) throws IOException {
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

        return timesComMaisVitorias;
    }
    public List<String> jogadorComMaisGols() throws IOException {
        Map<String,Long> jogadorPorGol = golsRepository.obterGols().stream()
                .filter(gol -> !gol.getTipo_de_gol().equalsIgnoreCase("Gol Contra"))
                .collect(Collectors.groupingBy(Gol::getAtleta,Collectors.counting()));

        Long maximoGols = jogadorPorGol.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L);

        List<String> jogadorComMaisGols = jogadorPorGol.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maximoGols))
                .map(Map.Entry::getKey)
                .toList();

        return jogadorComMaisGols;
    }
    public List<String> jogadorComMaisGolsPenaltis() throws IOException {
        Map<String,Long> jogadorPorGol = golsRepository.obterGols().stream()
                .filter(gol -> gol.getTipo_de_gol().equalsIgnoreCase("Penalty"))
                .collect(Collectors.groupingBy(Gol::getAtleta,Collectors.counting()));

        Long maximoGols = jogadorPorGol.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L);

        List<String> jogadorComMaisGolsPenaltis = jogadorPorGol.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maximoGols))
                .map(Map.Entry::getKey).toList();

        return jogadorComMaisGolsPenaltis;
    }
    public List<String> jogadorComMaisGolsContra() throws IOException {
        Map<String,Long> jogadorPorGol = golsRepository.obterGols().stream()
                .filter(gol -> gol.getTipo_de_gol().equalsIgnoreCase("Gol Contra"))
                .collect(Collectors.groupingBy(Gol::getAtleta,Collectors.counting()));

        Long maximoGols = jogadorPorGol.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L);

        List<String> jogadorComMaisGols = jogadorPorGol.entrySet().stream()
                .filter(j -> j.getValue().equals(maximoGols))
                .map(Map.Entry::getKey).toList();

        return jogadorComMaisGols;
    }
    public List<String> mostrarPartidasComMaisGols() throws IOException {
        Map<String,Long> placar = golsRepository.obterGols().stream().collect(Collectors.groupingBy(Gol::getPartida_id,Collectors.counting()));

        Long maximoGols = placar.values().stream().max(Comparator.naturalOrder()).orElse(0L);
        List<String> partidasComMaisGols =  placar.entrySet().stream().filter(p -> p.getValue().equals(maximoGols))
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Placar das partidas com maior quantidade de gols");
        mostrarPlacar(partidasComMaisGols);
        return partidasComMaisGols;
    }

    private void mostrarPlacar(List<String> p) throws IOException {
        for (String partid:p) {
            partidaRepository.obterPartidas().stream().filter(partida->partida.getId().equalsIgnoreCase(partid)).forEach(partida -> {
                System.out.print(partida.getMandante() + " " + partida.getMandantePlacar());
                System.out.println("-" + partida.getVisitantePlacar() + " " + partida.getVisitante());
            });
        }
    }

    public String estadoComMenosJogos() throws IOException {
        Map<String, Long> estadoComMenosJogos = partidaRepository.obterPartidas().stream()
                .collect(Collectors.groupingBy(Partida::getMandanteEstado, Collectors.counting()));

        Long menosJogos = Collections.min(estadoComMenosJogos.values());

        List<String> estadosComMenosJogos = estadoComMenosJogos.entrySet().stream()
                .filter(entry -> entry.getValue().equals(menosJogos))
                .map(Map.Entry::getKey)
                .toList();

        return estadosComMenosJogos.toString();
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