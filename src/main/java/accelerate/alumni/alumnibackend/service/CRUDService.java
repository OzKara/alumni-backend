package accelerate.alumni.alumnibackend.service;

import java.util.Collection;

public interface CRUDService <T, ID>{
    T findById(ID id);
    Collection<T> findAll();
    T add(T object);
    T update(T object);
    boolean existsById(ID id);
    void deleteById(ID id);
}