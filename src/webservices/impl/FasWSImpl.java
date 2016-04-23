package webservices.impl;

import java.sql.SQLException;

import javax.jws.WebService;

import services.controller.MessageController;
import webservices.FasWS;

@WebService(endpointInterface = "Webservice.FasWS")
public class FasWSImpl implements FasWS{

	@Override
	public Boolean sendMessageText(String text) {
		
		return MessageController.getInstance().sendMessageText(text);
	}

	@Override
	public String getNewMessage(String name) throws SQLException {
		return MessageController.getInstance().getNewMessage(name);
	}

	@Override
	public String getAllMessages(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
