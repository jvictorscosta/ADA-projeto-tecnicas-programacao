package projeto.domain;

public class Gol {
    private String partida_id;
    private String rodada;
    private String clube;
    private String atleta;
    private String minuto;
    private String tipo_de_gol;

    public Gol(String partida_id, String rodada, String clube, String atleta, String minuto, String tipo_de_gol) {
        this.partida_id = partida_id;
        this.rodada = rodada;
        this.clube = clube;
        this.atleta = atleta;
        this.minuto = minuto;
        this.tipo_de_gol = tipo_de_gol;
    }

    public Gol() {

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

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getTipo_de_gol() {
        return tipo_de_gol;
    }

    public void setTipo_de_gol(String tipo_de_gol) {
        this.tipo_de_gol = tipo_de_gol;
    }
    @Override
    public String toString() {
        return "DadosPartida{" +
                "Id da partida=" + partida_id +
                ", rodada=" + rodada +
                ", clube='" + clube +'\''  +
                ", atleta='" + atleta + '\'' +
                ", minuto=" + minuto +
                ", tipoDeGol='" + tipo_de_gol + '\'' +
                '}';
    }
}
