package projeto.repository;

import projeto.domain.Estatistica;
import projeto.domain.Partida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class EstatisticaRepository {

    public static void main(String[] args) throws IOException {
        Path pathEstatistica = Paths.get("projeto/repository/campeonato-brasileiro-full.csv");
        Stream<String> lines = Files.lines(pathEstatistica);

        //lines.forEach(System.out::println);

        lines.skip(1).forEach(string -> {
            String[] estatisticas = string.split(",");
//"partida_id","rodata","clube","chutes","chutes_no_alvo","posse_de_bola","passes","precisao_passes","faltas","cartao_amarelo","cartao_vermelho","impedimentos","escanteios"
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

            System.out.println(estatistica);});
    }
}
