package model;

import enums.Estado;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EstatisticasJogo {
    private final LocalDate dataPartida;
    private final String clubeVencedor;
    private final Estado estado;
    private final Integer mandantePlacar;
    private final Integer visitantePlacar;
    private final Integer totalGols;
    private final String clubeMantante;
    private final String clubeVisitante;


    public EstatisticasJogo(LocalDate dataPartida, String clubeVencedor, Estado estado, Integer mandantePlacar,
                            Integer visitantePlacar, String clubeMandante, String clubeVisitante) {
        this.dataPartida = dataPartida;
        this.clubeVencedor = clubeVencedor;
        this.estado = estado;
        this.mandantePlacar = mandantePlacar;
        this.visitantePlacar = visitantePlacar;
        this.totalGols = mandantePlacar + visitantePlacar;
        this.clubeMantante = clubeMandante;
        this.clubeVisitante = clubeVisitante;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    /*public void setDataPartida(LocalDate dataPartida) {
        this.dataPartida = dataPartida;
    }*/

    public String getClubeVencedor() {
        return clubeVencedor;
    }

    /*public void setClubeVencedor(String clubeVencedor) {
        this.clubeVencedor = clubeVencedor;
    }*/

    public Estado getEstado() {
        return estado;
    }

    /*public void setEstado(Estado estado) {
        this.estado = estado;
    }*/

    public Integer getMandantePlacar() {
        return mandantePlacar;
    }

    /*public void setMandantePlacar(Integer mandantePlacar) {
        this.mandantePlacar = mandantePlacar;
    }*/

    public Integer getVisitantePlacar() {
        return visitantePlacar;
    }

    /*public void setVisitantePlacar(Integer visitantePlacar) {
        this.visitantePlacar = visitantePlacar;
    }*/

    public Integer getTotalGols() {
        return totalGols;
    }

    /*public void setTotalGols(Integer totalGols) {
        this.totalGols = totalGols;
    }*/

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EstatisticasJogo{");
        sb.append("dataPartida=").append(dataPartida);
        sb.append(", clubeVencedor='").append(clubeVencedor).append('\'');
        sb.append(", estado=").append(estado);
        sb.append(", mandantePlacar=").append(mandantePlacar);
        sb.append(", visitantePlacar=").append(visitantePlacar);
        sb.append(", totalGols=").append(totalGols);
        sb.append('}');
        return sb.toString();
    }

    public String getClubeMantante() {
        return clubeMantante;
    }

    /*public void setClubeMantante(String clubeMantante) {
        this.clubeMantante = clubeMantante;
    }*/

    public String getClubeVisitante() {
        return clubeVisitante;
    }

    /*public void setClubeVisitante(String clubeVisitante) {
        this.clubeVisitante = clubeVisitante;
    }*/
}
