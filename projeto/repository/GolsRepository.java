package projeto.repository;

import projeto.domain.Gol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GolsRepository {

    public List<Gol> obterGols() throws IOException {
        Path pathGol = Paths.get("projeto/repository/campeonato-brasileiro-gols.csv");

        return Files.lines(pathGol)
                .skip(1) // Pular o cabeçalho
                .map(line -> line.split(","))
                .map(this::criarGol)
                .collect(Collectors.toList());
    }

    private Gol criarGol(String[] gols) {
        Gol gol = new Gol();
        gol.setPartida_id(gols[0].replaceAll("\"", ""));
        gol.setRodada(gols[1].replaceAll("\"", ""));
        gol.setClube(gols[2].replaceAll("\"", ""));
        gol.setAtleta(gols[3].replaceAll("\"", ""));
        gol.setMinuto(gols[4].replaceAll("\"", ""));
        gol.setTipo_de_gol(gols[5].replaceAll("\"", ""));
        return gol;
    }
}


