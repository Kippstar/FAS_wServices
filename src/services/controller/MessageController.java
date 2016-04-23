package services.controller;

import java.beans.PropertyChangeEvent;
import java.sql.SQLException;

import org.json.JSONObject;

import mvc.controller.abstrct.AbstractController;
import persistence.entity.impl.Message;
import services.model.MessageModel;

public class MessageController extends AbstractController<MessageModel>{

	private static MessageController instance;
	
//	Singleton
	public static MessageController getInstance(){
		if(instance == null){
			MessageModel model = new MessageModel();
			instance = new MessageController(model);
		}
		return instance;
	}

	
	public MessageController(MessageModel model) {
		super(model);
	}

	
//	?? Gute Frage... Wenn sich Eigenschaften vom Model verändern???
//	Eher sekundär interessant
	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public String getNewMessage(String name) throws SQLException{
		Message msg = registeredModel.getLastMessage();
		return msg.getMsg_text();
	}
	
	/**
	 * @param text
	 * @return
	 */
	public boolean sendMessageText(String text){
		return registeredModel.newMsg(text);
	}
	
	public JSONObject getAllMessages(){
		JSONObject jObj = new JSONObject();
		try {
			 jObj = registeredModel.getAllMessages();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jObj;
	}

	
}
