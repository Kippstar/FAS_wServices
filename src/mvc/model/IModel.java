package mvc.model;

import java.beans.PropertyChangeListener;

public interface IModel {
	
	void addPropertyChangeListener(PropertyChangeListener listener);

	void removePropertyChangeListener(PropertyChangeListener listener);

}
