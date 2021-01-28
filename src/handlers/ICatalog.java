package handlers;

import java.util.List;

public interface ICatalog<T> {

	public T add(T obj);

	public T remove(T obj);

	public List<T> list();

}
