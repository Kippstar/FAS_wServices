package webservices.impl;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import services.controller.MessageController;


/**
 * @author Kipker
 *
 */
@Path("")
public class FasRestImpl {

//	public Boolean sendMessageText(String text) {
//
//		return MessageController.getInstance().sendMessageText(text);
//	}

	/**
	 * @return
	 */
	@GET
	@Path("/getnewest")
//	@Produces("getNewest/")
	public Response getNewMessage() {
		String name = "test";
		String toReturn;
		try {
			toReturn = MessageController.getInstance().getNewMessage(name);
		} catch (SQLException e) {
			e.printStackTrace();
			toReturn = "Schwerwiegender Serverfehler.\n"
					+ "Wir entschuldigen uns für diese Unanehmlichkeit."
					+ "\n\nViele Grüße\nDas FAS-Team";
		}
		return Response.status(200).entity(toReturn).build();
	}
	
	
	
	/**
	 * @return
	 * @discription Test-Methode
	 * Path legt den Pfad fest. Über diesen URL wird diese Methode angesprochen
	 * GET gibt Auskunft über die allgemeine Funktion der Methode 
	 * Produce (optional) gibt an, was für ein Typ die Antwort(Response) ist
	 */
	@Path("/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response test() {	
		JSONObject jObj = new JSONObject();
		jObj.put("Test1", 555);
		jObj.put("Test2", 333);
		int i = 33;
		System.out.println(i);
//		return Response.status(200).
//				entity("Super. \nHat funktioniert.").build();
		String result = "@Produces(\"test/json\") Output: \n\nF to C Converter Output: \n\n" + jObj;
		// MessageController.getInstance().getNewMessage(name);
		return Response.status(200).
				entity(result).build();
	}
	
	@Path("/getAllMsgs")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMessages() {
//		JSONObject jObj = MessageController.getInstance().getAllMessages();
		String toReturn = MessageController.getInstance().getAllMessages().toString();
		toReturn = toReturn.replaceAll(",", "\n");
		return Response.status(200).entity(toReturn).build();
	}
	
	/**
	 * @param msg
	 * @return
	 */
	@GET
	@Path("/newtext/{f}")
	public Response sendMessageText(@PathParam("f") String msg){
	System.out.println("GV: New Message");
	System.out.println("Msg-Text: " + msg);
		boolean b = MessageController.getInstance().sendMessageText(msg);
//		JSONObject jOb = new JSONObject();
		if(b){
			return Response.status(200).entity("Neue Message wurde angelegt.").build();
		}else{
			return Response.status(200).entity("Fehler beim anlegen der neuen Message.").build();
		}
	}

}
