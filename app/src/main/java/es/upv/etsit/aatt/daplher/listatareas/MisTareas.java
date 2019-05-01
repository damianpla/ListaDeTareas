package es.upv.etsit.aatt.daplher.listatareas;

public class MisTareas {

    String titulotareas;
    String fechatareas;
    String descripciontareas;

    public MisTareas() {
    }

    public MisTareas(String titulotareas, String fechatareas, String descripciontareas) {
        this.titulotareas = titulotareas;
        this.fechatareas = fechatareas;
        this.descripciontareas = descripciontareas;
    }

    public String getTitulotareas() {
        return titulotareas;
    }

    public void setTitulotareas(String titulotareas) {
        this.titulotareas = titulotareas;
    }

    public String getFechatareas() {
        return fechatareas;
    }

    public void setFechatareas(String fechatareas) {
        this.fechatareas = fechatareas;
    }

    public String getDescripciontareas() {
        return descripciontareas;
    }

    public void setDescripciontareas(String descripciontareas) { this.descripciontareas = descripciontareas;
    }
}
