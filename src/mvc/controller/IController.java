package mvc.controller;

import java.beans.PropertyChangeListener;

import mvc.model.abstrct.AbstractModel;

public interface IController<M extends AbstractModel> extends
		PropertyChangeListener {

	void setModel(M Model);
}
