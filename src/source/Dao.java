package source;

import java.util.List;
import java.util.Optional;

public interface Dao <T> {
	
	T get(long id); //get by id
	
	List<T> getAll(); 
	
	void save(T t);
	
	void update(T t, String[] tData);
	
	void delete(T t);
	
	
}
