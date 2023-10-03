package projeto.repository;

import projeto.domain.Gol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class GolsRepository {
    public static void main(String[] args) throws IOException{
        Path pathGol = Paths.get("projeto/repository/campeonato-brasileiro-gols.csv");
        Stream<String> lines = Files.lines(pathGol);
        //lines.forEach(System.out::println);

        lines.skip(1).forEach(string -> {
                    String[] gols = string.split(",");

                    Gol gol = new Gol();
                    gol.setPartida_id(gols[0].replaceAll("\"", ""));
                    gol.setRodada(gols[1].replaceAll("\"", ""));
                    gol.setClube(gols[2].replaceAll("\"", ""));
                    gol.setAtleta(gols[3].replaceAll("\"", ""));
                    gol.setMinuto(gols[4].replaceAll("\"", ""));
                    gol.setTipo_de_gol(gols[5].replaceAll("\"", ""));
            System.out.println(gol);});
    }
      /* Path pathGol = Paths.get("projeto/repository/campeonato-brasileiro-gols.csv");
    Stream<String> lines = Files.lines(pathGol);
    public golsRepository() throws IOException {
        lines.forEach(System.out::println);
    }*/

}
