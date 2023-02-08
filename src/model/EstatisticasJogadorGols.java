package model;

public class EstatisticasJogadorGols {
    private final Integer partidaId;
    private final Integer rodada;
    private final String clube;
    private final String atleta;
    private final String minuto;
    private final String tipoDeGol;

    public EstatisticasJogadorGols(Integer partidaId, Integer rodada, String clube, String atleta, String minuto, String tipoDeGol) {
        this.partidaId = partidaId;
        this.rodada = rodada;
        this.clube = clube;
        this.atleta = atleta;
        this.minuto = minuto;
        this.tipoDeGol = tipoDeGol;
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

    public String getAtleta() {
        return atleta;
    }

    public String getMinuto() {
        return minuto;
    }

    public String getTipoDeGol() {
        return tipoDeGol;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EstatisticasJogadorGols{");
        sb.append("partidaId=").append(partidaId);
        sb.append(", rodada=").append(rodada);
        sb.append(", clube='").append(clube).append('\'');
        sb.append(", atleta='").append(atleta).append('\'');
        sb.append(", minuto='").append(minuto).append('\'');
        sb.append(", tipoDeGol='").append(tipoDeGol).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
