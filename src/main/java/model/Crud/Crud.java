package model.Crud;

import model.Entities.Ong;
import model.Entities.Proyectos;
import model.Entities.Sedes;
import model.Entities.Trabajadores;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Crud {


    public static void crear(Object o) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(o);

        transaction.commit();
    }

    public static List listar(Object o) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        //System.out.println(o.getClass());

        if( o instanceof Proyectos) {
            Query query = entityManager.createQuery("Select p from Proyectos p");

            List<Proyectos> list=new ArrayList();
            list = query.getResultList();

           /* for(Proyectos p :list ){
                System.out.println("ID Proyecto: " + p.getIdproyectos());
                System.out.println("Pais Proyecto: " + p.getPais());
            }*/
            return list;


        }
        if( o instanceof Trabajadores) {
            Query query = entityManager.createQuery("Select t from Trabajadores t");

            List<Trabajadores> list= new ArrayList();

            list = query.getResultList();

           /*for(Trabajadores t :list ){
                System.out.println("ID Trabajador: " + t.getId());
                System.out.println("Nombre: " + t.getNombre());
                System.out.println("Edad: " + t.getEdad());
            }*/
            return list;
        }
        if( o instanceof Sedes) {
            Query query = entityManager.createQuery("Select s from Sedes s");

            List<Sedes> list=new ArrayList();
            list = query.getResultList();

            /*for(Sedes s :list ){
                System.out.println("ID Sede: " + s.getIdSede());
                System.out.println("Nombre: " + s.getNombre());
                System.out.println("MTS: " + s.getMts());
                System.out.println("Telefono: " + s.getTelefono());
            }*/
            return list;

        }
        transaction.commit();
        return null;

    }

    public static Object leer(Object o) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        if( o instanceof Proyectos) {
            Proyectos p = (Proyectos)o;
            p = entityManager.find(Proyectos.class, p.getIdproyectos());
            transaction.commit();
            return p;

        }else if( o instanceof Trabajadores) {

            Trabajadores t = (Trabajadores)o;
            t = entityManager.find(Trabajadores.class, t.getId());
            transaction.commit();
            return t;

        }else if( o instanceof Sedes) {
            Sedes s = (Sedes)o;
            s = entityManager.find(Sedes.class, s.getIdSede());
            transaction.commit();
            return s;
        }else {
           transaction.commit();
            return null;
        }

    }

    public static void actualizar(Object o) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        if( o instanceof Proyectos) {
            Proyectos p = (Proyectos)o;
            p = entityManager.find(Proyectos.class, p.getIdproyectos());
            p.setPais(((Proyectos) o).getPais());

        }else if( o instanceof Trabajadores) {
            Trabajadores t =(Trabajadores) o;
            t = entityManager.find(Trabajadores.class, t.getId());
            t.setNombre("Nombre_Actualizado");

        }else if( o instanceof Sedes) {
            Sedes s = (Sedes)o;
            s = entityManager.find(Sedes.class, s.getIdSede());
            s.setNombre("Nombre_Actualizado");

        }else if( o instanceof Ong) {
            Ong on = (Ong) o;
            on = entityManager.find(Ong.class, on.getIdOng());
            on.setNombre("Nombre_Actualizado");

        }
        transaction.commit();
    }

    public static void borrar(Object o) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        transaction.begin();

        if( o instanceof Proyectos) {
            Proyectos p =(Proyectos) o;
            p = entityManager.find(Proyectos.class, p.getIdproyectos());
            entityManager.remove(p);

        }else if( o instanceof Trabajadores) {

            Trabajadores t = (Trabajadores)o;
            t = entityManager.find(Trabajadores.class, t.getId());
            entityManager.remove(t);

        }else if( o instanceof Sedes) {
            Sedes s = (Sedes)o;
            s = entityManager.find(Sedes.class, s.getIdSede());
            entityManager.remove(s);

        }else if( o instanceof Ong) {
            Ong on = (Ong)o;
            on = entityManager.find(Ong.class, on.getIdOng());
            entityManager.remove(on);

        }
        transaction.commit();



    }
}
