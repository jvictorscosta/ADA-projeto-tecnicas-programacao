package projeto.domain;

public class Estatistica {
    private String partida_id;
    private String rodada;
    private String clube;
    private String chutes;
    private String chutes_no_alvo;
    private String posse_de_bola;
    private String passes;
    private String precisao_passes;
    private String faltas;
    private String cartao_amarelo;
    private String cartao_vermelho;
    private String impedimentos;
    private String escanteios;

    public Estatistica() {
    }

    public String getPartida_id() {
        return partida_id;
    }

    public void setPartida_id(String partida_id) {
        this.partida_id = partida_id;
    }

    public String getRodada() {
        return rodada;
    }

    public void setRodada(String rodada) {
        this.rodada = rodada;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getChutes() {
        return chutes;
    }

    public void setChutes(String chutes) {
        this.chutes = chutes;
    }

    public String getChutes_no_alvo() {
        return chutes_no_alvo;
    }

    public void setChutes_no_alvo(String chutes_no_alvo) {
        this.chutes_no_alvo = chutes_no_alvo;
    }

    public String getPosse_de_bola() {
        return posse_de_bola;
    }

    public void setPosse_de_bola(String posse_de_bola) {
        this.posse_de_bola = posse_de_bola;
    }

    public String getPasses() {
        return passes;
    }

    public void setPasses(String passes) {
        this.passes = passes;
    }

    public String getPrecisao_passes() {
        return precisao_passes;
    }

    public void setPrecisao_passes(String precisao_passes) {
        this.precisao_passes = precisao_passes;
    }

    public String getFaltas() {
        return faltas;
    }

    public void setFaltas(String faltas) {
        this.faltas = faltas;
    }

    public String getCartao_amarelo() {
        return cartao_amarelo;
    }

    public void setCartao_amarelo(String cartao_amarelo) {
        this.cartao_amarelo = cartao_amarelo;
    }

    public String getCartao_vermelho() {
        return cartao_vermelho;
    }

    public void setCartao_vermelho(String cartao_vermelho) {
        this.cartao_vermelho = cartao_vermelho;
    }

    public String getImpedimentos() {
        return impedimentos;
    }

    public void setImpedimentos(String impedimentos) {
        this.impedimentos = impedimentos;
    }

    public String getEscanteios() {
        return escanteios;
    }

    public void setEscanteios(String escanteios) {
        this.escanteios = escanteios;
    }

    @Override
    public String toString() {
        return "Estatistica{" +
                "Partida ID='" + partida_id + '\'' +
                ", Rodada='" + rodada + '\'' +
                ", Clube='" + clube + '\'' +
                ", Chutes='" + chutes + '\'' +
                ", Chutes no Alvo='" + chutes_no_alvo + '\'' +
                ", Posse de Bola='" + posse_de_bola + '\'' +
                ", Passes='" + passes + '\'' +
                ", Precisao passes='" + precisao_passes + '\'' +
                ", Faltas='" + faltas + '\'' +
                ", Cartao_amarelo='" + cartao_amarelo + '\'' +
                ", Cartao_vermelho='" + cartao_vermelho + '\'' +
                ", Impedimentos='" + impedimentos + '\'' +
                ", Escanteios='" + escanteios + '\'' +
                '}';
    }
}
