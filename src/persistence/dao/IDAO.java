package persistence.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import persistence.entity.IEntity;

public interface IDAO<T extends IEntity> {

	public T create();

	public void delete(T entity);

	public List<T> findAll() throws SQLException, ParseException;

	public T getById(long id) throws SQLException, ParseException;

	public void persist(T entity) throws SQLException;

	public void reload(T entity) throws SQLException;
}
