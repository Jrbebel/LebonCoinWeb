package fr.oh.daos;

import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author formation
 */
public interface IDAO<T> {

    public abstract List<T> findAll();

    public abstract T findOne(int pk);

    public abstract int insert(T obj);

    public abstract int update(T obj);

    public abstract int delete(T obj);

    public abstract T findbyOne(TreeMap<String, String> map);

    public abstract List<T>findby(TreeMap<String, String> map);
}
