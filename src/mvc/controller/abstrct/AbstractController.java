package mvc.controller.abstrct;

import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;

import mvc.controller.IController;
import mvc.model.abstrct.AbstractModel;

public abstract class AbstractController<M extends AbstractModel> implements
		IController<M>, PropertyChangeListener {

	public M registeredModel;

	public AbstractController(M model) {
		setModel(model);
	}

	@Override
	public void setModel(M model) {
		if (model == null)
			return;

		this.registeredModel = model;
		model.addPropertyChangeListener(this);
	}

	protected void setModelProperty(String propertyName, Object newValue) {

		try {
			Method method = registeredModel.getClass().getMethod(
					"set" + propertyName, new Class[] { newValue.getClass() }

			);
			method.invoke(registeredModel, newValue);

		} catch (Exception ex) {

		}
	}

}
