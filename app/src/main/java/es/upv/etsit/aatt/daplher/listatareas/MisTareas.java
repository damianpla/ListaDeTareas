package es.upv.etsit.aatt.daplher.listatareas;

public class MisTareas {

    String titletareas;
    String  fechatareas;
    String desctareas;

    public MisTareas() {
    }

    public MisTareas(String titletareas, String fechatareas, String desctareas) {
        this.titletareas = titletareas;
        this.fechatareas = fechatareas;
        this.desctareas = desctareas;
    }

    public String getTitletareas() {
        return titletareas;
    }

    public void setTitletareas(String titletareas) {
        this.titletareas = titletareas;
    }

    public String getFechatareas() {
        return fechatareas;
    }

    public void setFechatareas(String fechatareas) {
        this.fechatareas = fechatareas;
    }

    public String getDesctareas() {
        return desctareas;
    }

    public void setDesctareas(String desctareas) {
        this.desctareas = desctareas;
    }
}
