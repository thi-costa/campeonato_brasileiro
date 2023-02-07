package model;

public class EstatisticasJogadorGols {
    private Integer partidaId;
    private Integer rodada;
    private String clube;
    private String atleta;
    private String minuto;
    private String tipoDeGol;

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

    public String getTipoDeGol() {
        return tipoDeGol;
    }

    public void setTipoDeGol(String tipoDeGol) {
        this.tipoDeGol = tipoDeGol;
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
