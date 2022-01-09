package model.Entities;

import javax.persistence.*;

@Entity
public class Ong {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ong")
    private int idOng;
    @Basic
    @Column(name = "nombre")
    private String nombre;

    public int getIdOng() {
        return idOng;
    }

    public void setIdOng(int idOng) {
        this.idOng = idOng;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ong ong = (Ong) o;

        if (idOng != ong.idOng) return false;
        if (nombre != null ? !nombre.equals(ong.nombre) : ong.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOng;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
