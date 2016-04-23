package services.model;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONObject;

import mvc.model.abstrct.AbstractModel;
import persistence.dao.impl.MessageDAO;
import persistence.entity.impl.Message;

public class MessageModel extends AbstractModel {
	MessageDAO msgDAO = new MessageDAO();

	@Override
	protected void initDefault() {
		//
	}

	/**
	 * @return a Message Object
	 * @throws SQLException
	 */
	public Message getLastMessage() throws SQLException {
		return msgDAO.getLastMsg();
	}

	public JSONObject getAllMessages() throws SQLException{
		List<Message> lMsg = msgDAO.findAll();
		JSONObject jObj = new JSONObject();
			for(Message msg: lMsg){
				jObj.put(msg.getId().toString(), msg.getMsg_text());
			}
		return jObj;	
	}

	/**
	 * @param text
	 *            Der neue Massage-Text
	 * @return True, wenn der neue Text ordnungsgemäß in die Datenbank
	 *         eingetragen wurde Fals, wenn es zu Fehlern kam
	 */
	public boolean newMsg(String text) {
		try {
			msgDAO.create(text);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
