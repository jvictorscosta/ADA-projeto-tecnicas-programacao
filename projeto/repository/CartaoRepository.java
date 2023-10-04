package projeto.repository;

import projeto.domain.Cartao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class CartaoRepository {

    public List<Cartao> obterCartoes() throws IOException {
        Path pathCartao = Paths.get("projeto/repository/campeonato-brasileiro-cartoes.csv");

        return Files.lines(pathCartao)
                .skip(1) // Pular o cabeçalho
                .map(line -> line.split(","))
                .map(this::criarCartao)
                .collect(Collectors.toList());
    }

    private Cartao criarCartao(String[] cartoes) {
        Cartao cartao = new Cartao();
        cartao.setPartidaId(cartoes[0].replaceAll("\"", ""));
        cartao.setRodada(cartoes[1].replaceAll("\"", ""));
        cartao.setClube(cartoes[2].replaceAll("\"", ""));
        cartao.setCartao(cartoes[3].replaceAll("\"", ""));
        cartao.setAtleta(cartoes[4].replaceAll("\"", ""));
        cartao.setNumCamisa(cartoes[5].replaceAll("\"", ""));
        cartao.setPosicao(cartoes[6].replaceAll("\"", ""));
        cartao.setMinuto(cartoes[7].replaceAll("\"", ""));
        return cartao;
    }
}
