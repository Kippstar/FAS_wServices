package util;

import java.sql.SQLException;
import java.text.ParseException;

import persistence.dao.impl.MessageDAO;
import persistence.entity.impl.Message;

public class Test_App {

	public static void main(String[] args) throws SQLException, ParseException {
//		Server-Start
//		Endpoint.publish("http://localhost:8080/ws/hello", 
//				new HelloWorldImpl());
//		
//		--Test-Message erstellen--		
		Message msg = new MessageDAO().create("Test");
		System.out.println(msg);
//		try {
//			msg = new MessageDAO().getById(1);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		if(msg !=null){
//			Testnachricht
		msg.setMsg_text("Msg: 03 - Hoch die Hände, Wochenende =)  ");
		new MessageDAO().persist(msg);
		   System.out.println("Message wurde gespeichert.");
		}else{
			System.out.println("Speichervorgang nicht angestoßen,\n"
					+ "da Message-Objekt leer ist:");
			System.out.println("Message-Objekt:" + msg);
		}
		
		msg = new MessageDAO().getById(msg.getId());
		System.out.println(msg);
		
		System.out.println(new MessageDAO().getLastMsg());
		
//		
//	FasWSImpl test = new FasWSImpl();
//	String message = test.getNewMessage("Kip");
//	System.out.println(message);
	
//	System.out.println(MessageController.getInstance().getNewMessage("das"));
	
	}	
}
