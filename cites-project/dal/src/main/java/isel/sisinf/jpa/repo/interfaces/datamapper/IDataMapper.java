package isel.sisinf.jpa.repo.interfaces.datamapper;

public interface IDataMapper<T> {
    T Create(T entity);
    T Update(T entity);
    T Delete(T entity);
}
