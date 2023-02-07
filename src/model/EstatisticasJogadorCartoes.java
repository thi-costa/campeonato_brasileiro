package model;

public class EstatisticasJogadorCartoes {
    private Integer partidaId;
    private Integer rodada;
    private String clube;
    private String cartao;
    private String atleta;
    private Integer numCamisa;
    private String posicao;
    private String minuto;

    public EstatisticasJogadorCartoes(Integer partidaId, Integer rodada, String clube, String cartao, String atleta, Integer numCamisa, String posicao, String minuto) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.cartao = cartao;
        this.atleta = atleta;
        this.numCamisa = numCamisa;
        this.posicao = posicao;
        this.minuto = minuto;
    }

    public Integer getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Integer partidaId) {
        this.partidaId = partidaId;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public Integer getNumCamisa() {
        return numCamisa;
    }

    public void setNumCamisa(Integer numCamisa) {
        this.numCamisa = numCamisa;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EstatisticasJogadorCartoes{");
        sb.append("partidaId=").append(partidaId);
        sb.append(", rodada=").append(rodada);
        sb.append(", clube='").append(clube).append('\'');
        sb.append(", cartao='").append(cartao).append('\'');
        sb.append(", atleta='").append(atleta).append('\'');
        sb.append(", numCamisa=").append(numCamisa);
        sb.append(", posicao='").append(posicao).append('\'');
        sb.append(", minuto='").append(minuto).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
