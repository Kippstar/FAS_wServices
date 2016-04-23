package persistence.dao;

import persistence.dao.IDAO;
import persistence.entity.IEntity;

public abstract class AbstractDAO <T extends IEntity> implements IDAO<T> {


}
