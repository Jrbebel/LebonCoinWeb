/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oh.daos;

import fr.oh.utils.HibernateUtil;
import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author formation
 */
public class DAOGeneric<T> implements IDAO<T>, Closeable {

    private T dto;
    private Transaction tx;
    private Session session;

    public DAOGeneric(T dto) throws InstantiationException, IllegalAccessException {
        this.dto = dto;
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    /**
     *
     * @return List<T> Liste de DTO
     */
    @Override
    public List<T> findAll() {
        Query q = session.createQuery(new StringBuilder("FROM ").append(dto.getClass().getName()).toString());
        List lDto = q.list();
        return lDto;
    }

    @Override
    public T findOne(int pk) {

        String hql = new StringBuilder("FROM ")
                .append(dto.getClass().getSimpleName())
                .append(" WHERE ")
                .append(dto.getClass().getDeclaredFields()[0].getName())
                .append("=" + pk)
                .toString();

        Query q = session.createQuery(hql);
//       q.setString(1, String.valueOf(pk));
        return (T) q.uniqueResult();
    }

    /**
     *
     * @param map
     * @return
     */
    @Override
    public T findbyOne(TreeMap<String, String> map) {
        String hql1 = "";
        String hql2 = "";
        String hql3 = "";
        int index = 0;
        String hql = new StringBuilder("FROM ")
                .append(dto.getClass().getSimpleName()).append(" WHERE ")
                .toString();
        for (Map.Entry<String, String> element : map.entrySet()) {

            hql2 += element.getKey() + "=" + " '" + element.getValue() + "'";
            if (element.getKey() != map.lastKey()) {
                hql2 += " AND ";
            }
        }
        hql3 = new StringBuilder().append(hql2).toString();

        Query q = session.createQuery(hql + hql3);
        return (T) q.uniqueResult();
    }

    /**
     *
     * @param map
     * @return
     */
    @Override
    public List<T> findby(TreeMap<String, String> map) {
        String hql1 = "";
        String hql2 = "";
        String hql3 = "";
        int index = 0;
        String hql = new StringBuilder("FROM ")
                .append(dto.getClass().getSimpleName()).append(" WHERE ")
                .toString();
        for (Map.Entry<String, String> element : map.entrySet()) {

            hql2 += element.getKey() + "=" + " '" + element.getValue() + "'";
            if (element.getKey() != map.lastKey()) {
                hql2 += " AND ";
            }
        }
        hql3 = new StringBuilder().append(hql2).toString();
        Query q = session.createQuery(hql + hql3);
        List lDto = q.list();
        return lDto;

    }

    public List<T> RechercheProduit(String mot) {
        System.out.println("FROM WHERE designationProduit LIKE '%voiture%'");
        Query q = session.createQuery("FROM WHERE designationProduit like %voiture%");
        List lDto = q.list();
        return lDto;

    }

    @Override
    public int insert(T obj) {

        int generatedId = 0;

        try {
            session.save(obj);
            session.flush();
            tx.commit();
        } catch (SecurityException ex) {
            Logger.getLogger(DAOGeneric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DAOGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }

        return generatedId;
    }

    @Override
    public int update(T obj) {
        int generatedId = 0;

        try {
            session.update(obj);
            session.flush();
            //  session.connection().commit();

        } catch (SecurityException ex) {
            Logger.getLogger(DAOGeneric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DAOGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }

        return generatedId;
    }

    @Override
    public int delete(T obj) {
        int generatedId = 0;

        try {
            session.delete(obj);
            session.flush();
            //    session.connection().commit();

        } catch (SecurityException ex) {
            Logger.getLogger(DAOGeneric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DAOGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }

        return generatedId;
    }

    @Override
    public void close() throws IOException {
        session.close();
    }

}
