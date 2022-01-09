package model.Entities;

import javax.persistence.*;

@Entity
@Table(name = "trabajadores_proyectos", schema = "loadingname")
public class TrabajadoresProyectos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_trab_proy")
    private int idTrabProy;
    @Basic
    @Column(name = "id_trabajador")
    private int idTrabajador;
    @Basic
    @Column(name = "id_proyecto")
    private int idProyecto;

    public int getIdTrabProy() {
        return idTrabProy;
    }

    public void setIdTrabProy(int idTrabProy) {
        this.idTrabProy = idTrabProy;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrabajadoresProyectos that = (TrabajadoresProyectos) o;

        if (idTrabProy != that.idTrabProy) return false;
        if (idTrabajador != that.idTrabajador) return false;
        if (idProyecto != that.idProyecto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTrabProy;
        result = 31 * result + idTrabajador;
        result = 31 * result + idProyecto;
        return result;
    }
}
