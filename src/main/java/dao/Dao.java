package dao;

public interface Dao<T, K> {

	public T create(T entity);

	public T findById(K id);
	
	public T update(T entity);
	
	public void delete(T entity);
}
