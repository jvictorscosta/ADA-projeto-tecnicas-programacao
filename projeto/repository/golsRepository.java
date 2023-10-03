package projeto.repository;

import projeto.domain.Gol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class golsRepository {
    public static void main(String[] args) throws IOException{
        Path pathGol = Paths.get("projeto/repository/campeonato-brasileiro-gols.csv");
        Stream<String> lines = Files.lines(pathGol);
        //lines.forEach(System.out::println);

        lines.skip(1).forEach(string -> {
                    String[] gols = string.split(",");

                    Gol gol = new Gol();
                    //int partida_id, int rodada, String clube, String atleta, int minuto, String tipo_de_gol
                    gol.setPartida_id(gols[0]);
                    gol.setRodada(gols[1]);
                    gol.setClube(gols[2]);
                    gol.setAtleta(gols[3]);
                    gol.setMinuto(gols[4]);
                    gol.setTipo_de_gol(gols[5]);
            System.out.println(gol);});
    }
    private String[] removerAspas(String[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replaceAll("\"", "");  // Remove aspas
        }
        return data;
    }
   /* Path pathGol = Paths.get("projeto/repository/campeonato-brasileiro-gols.csv");
    Stream<String> lines = Files.lines(pathGol);
    public golsRepository() throws IOException {
        lines.forEach(System.out::println);
    }*/

}
