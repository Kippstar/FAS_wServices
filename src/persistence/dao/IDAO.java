package persistence.dao;

import java.sql.SQLException;
import java.util.List;

import persistence.entity.IEntity;

public interface IDAO<T extends IEntity> {

	public T create();

	public void delete(T entity);

	public List<T> findAll();

	public T getById(long id) throws SQLException;

	public void persist(T entity) throws SQLException;

	public void reload(T entity) throws SQLException;
}
