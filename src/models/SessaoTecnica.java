package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class SessaoTecnica {
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public SessaoTecnica(LocalDate data, LocalTime horaInicio, LocalTime horaFim) {
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    @Override
    public String toString() {
        return "SessaoTecnica{" +
                "data=" + data +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                '}';
    }
}
