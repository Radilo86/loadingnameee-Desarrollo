package model.Entities;

import javax.persistence.*;

@Entity
public class Proyectos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproyectos")
    private int idproyectos;
    @Basic
    @Column(name = "pais")
    private String pais;

    public int getIdproyectos() {
        return idproyectos;
    }

    public void setIdproyectos(int idproyectos) {
        this.idproyectos = idproyectos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Proyectos proyectos = (Proyectos) o;

        if (idproyectos != proyectos.idproyectos) return false;
        if (pais != null ? !pais.equals(proyectos.pais) : proyectos.pais != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idproyectos;
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        return result;
    }
}
