package model.Entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Sedes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_sede")
    private int idSede;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "mts")
    private BigDecimal mts;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "id_ong")
    private int idOng;

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getMts() {
        return mts;
    }

    public void setMts(BigDecimal mts) {
        this.mts = mts;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdOng() {
        return idOng;
    }

    public void setIdOng(int idOng) {
        this.idOng = idOng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sedes sedes = (Sedes) o;

        if (idSede != sedes.idSede) return false;
        if (idOng != sedes.idOng) return false;
        if (nombre != null ? !nombre.equals(sedes.nombre) : sedes.nombre != null) return false;
        if (direccion != null ? !direccion.equals(sedes.direccion) : sedes.direccion != null) return false;
        if (mts != null ? !mts.equals(sedes.mts) : sedes.mts != null) return false;
        if (telefono != null ? !telefono.equals(sedes.telefono) : sedes.telefono != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSede;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (mts != null ? mts.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + idOng;
        return result;
    }
}
