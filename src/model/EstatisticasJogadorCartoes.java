package model;

public class EstatisticasJogadorCartoes {
    private final Integer partidaId;
    private final Integer rodada;
    private final String clube;
    private final String cartao;
    private final String atleta;
    private final String posicao;

    public EstatisticasJogadorCartoes(Integer partidaId, Integer rodada, String clube, String cartao, String atleta, String posicao) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.cartao = cartao;
        this.atleta = atleta;
        this.posicao = posicao;
    }

    public Integer getPartidaId() {
        return partidaId;
    }


    public Integer getRodada() {
        return rodada;
    }

    public String getClube() {
        return clube;
    }

    public String getCartao() {
        return cartao;
    }

    public String getAtleta() {
        return atleta;
    }

    public String getPosicao() {
        return posicao;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EstatisticasJogadorCartoes{");
        sb.append("partidaId=").append(partidaId);
        sb.append(", rodada=").append(rodada);
        sb.append(", clube='").append(clube).append('\'');
        sb.append(", cartao='").append(cartao).append('\'');
        sb.append(", atleta='").append(atleta).append('\'');
        sb.append(", posicao='").append(posicao).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
