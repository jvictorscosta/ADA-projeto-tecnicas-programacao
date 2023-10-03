package projeto.repository;

import projeto.domain.Estatistica;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


    public class EstatisticaRepository {

        public List<Estatistica> obterEstatisticas() throws IOException {
            Path pathEstatistica = Paths.get("projeto/repository/campeonato-brasileiro-full.csv");

            return Files.lines(pathEstatistica)
                    .skip(1) // Pular o cabeçalho
                    .map(line -> line.split(","))
                    .map(this::criarEstatistica)
                    .collect(Collectors.toList());
        }

        private Estatistica criarEstatistica(String[] estatisticas) {
            Estatistica estatistica = new Estatistica();
            estatistica.setPartida_id(estatisticas[0].replaceAll("\"", ""));
            estatistica.setRodada(estatisticas[1].replaceAll("\"", ""));
            estatistica.setClube(estatisticas[2].replaceAll("\"", ""));
            estatistica.setChutes(estatisticas[3].replaceAll("\"", ""));
            estatistica.setChutes_no_alvo(estatisticas[4].replaceAll("\"", ""));
            estatistica.setPosse_de_bola(estatisticas[5].replaceAll("\"", ""));
            estatistica.setPasses(estatisticas[6].replaceAll("\"", ""));
            estatistica.setPrecisao_passes(estatisticas[7].replaceAll("\"", ""));
            estatistica.setFaltas(estatisticas[8].replaceAll("\"", ""));
            estatistica.setCartao_amarelo(estatisticas[9].replaceAll("\"", ""));
            estatistica.setCartao_vermelho(estatisticas[10].replaceAll("\"", ""));
            estatistica.setImpedimentos(estatisticas[11].replaceAll("\"", ""));
            estatistica.setEscanteios(estatisticas[12].replaceAll("\"", ""));
            return estatistica;
        }
    }
