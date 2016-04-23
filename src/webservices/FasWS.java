package webservices;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface FasWS {
	
	@WebMethod Boolean sendMessageText(String text);
	
	@WebMethod String getNewMessage(String name) throws SQLException;
	
	@WebMethod String getAllMessages(String name);
}
