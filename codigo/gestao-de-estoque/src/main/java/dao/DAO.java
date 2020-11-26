package dao;
import java.util.List;

/**
 * Interface data access object (DAO)
 * 
 * @author diogo
 *
 * Última alteração 15/10/2020
 */
public interface DAO<T> {
	public T get(int key);
	public void add(T p);
	public void update(T p);
	public void delete(T p);
	public T[] getAll();
	public int getIdMax();
}
