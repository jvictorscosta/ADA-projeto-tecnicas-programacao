package projeto.repository;

import projeto.domain.Cartao;
import projeto.domain.Partida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class CartaoRepository {
    public static void main(String[] args) throws IOException {
        Path pathCartao = Paths.get("projeto/repository/campeonato-brasileiro-full.csv");
        Stream<String> lines = Files.lines(pathCartao);

        //lines.forEach(System.out::println);

        lines.skip(1).forEach(string -> {
            String[] cartoes = string.split(",");
        //(String partidaId, String rodada, String clube, String cartao, String atleta, String numCamisa, String posicao, String minuto)
            Cartao cartao = new Cartao();
           cartao.setPartidaId(cartoes[0].replaceAll("\"", ""));
           cartao.setRodada(cartoes[1].replaceAll("\"", ""));
           cartao.setClube(cartoes[2].replaceAll("\"", ""));
           cartao.setCartao(cartoes[3].replaceAll("\"", ""));
           cartao.setAtleta(cartoes[4].replaceAll("\"", ""));
           cartao.setNumCamisa(cartoes[5].replaceAll("\"", ""));
           cartao.setPosicao(cartoes[6].replaceAll("\"", ""));
           cartao.setMinuto(cartoes[7].replaceAll("\"", ""));
            System.out.println(cartao);});
    }
}
