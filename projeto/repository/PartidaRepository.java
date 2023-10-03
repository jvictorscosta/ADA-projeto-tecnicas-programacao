package projeto.repository;


import projeto.domain.Partida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;



    public class PartidaRepository {

        public List<Partida> obterPartidas() throws IOException {
            Path pathfull = Paths.get("projeto/repository/campeonato-brasileiro-full.csv");

            return Files.lines(pathfull)
                    .skip(1) // Pular o cabeçalho
                    .map(line -> line.split(","))
                    .map(this::criarPartida)
                    .collect(Collectors.toList());
        }
        private Partida criarPartida(String[] partidas) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");

            Partida partida = new Partida();
            partida.setId(partidas[0].replaceAll("\"", ""));
            partida.setRodada(partidas[1].replaceAll("\"", ""));
            partida.setData(LocalDate.parse(partidas[2].replaceAll("\"", ""), formatter));
            partida.setHora(LocalTime.parse(partidas[3].replaceAll("\"", ""), formatterTime));
            partida.setMandante(partidas[4].replaceAll("\"", ""));
            partida.setVisitante(partidas[5].replaceAll("\"", ""));
            partida.setFormacaoMandante(partidas[6].replaceAll("\"", ""));
            partida.setFormacaoVisitante(partidas[7].replaceAll("\"", ""));
            partida.setTecnicoMandante(partidas[8].replaceAll("\"", ""));
            partida.setTecnicoVisitante(partidas[9].replaceAll("\"", ""));
            partida.setVencedor(partidas[10].replaceAll("\"", ""));
            partida.setArena(partidas[11].replaceAll("\"", ""));
            partida.setMandantePlacar(partidas[12].replaceAll("\"", ""));
            partida.setVisitantePlacar(partidas[13].replaceAll("\"", ""));
            partida.setMandanteEstado(partidas[14].replaceAll("\"", ""));
            partida.setVisitanteEstado(partidas[15].replaceAll("\"", ""));
            return partida;
        }
}
