package persistence.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.AbstractDAO;
import persistence.dao.IDAO;
import persistence.entity.impl.Message;
import util.DBUtil;

public class MessageDAO extends AbstractDAO<Message> implements IDAO<Message> {

	
	public Message create(String text) throws SQLException {
		Message msg = new Message();
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			ResultSet result;

			PreparedStatement statement = conn.prepareStatement("INSERT INTO fas_message (TEXT) VALUES (?);",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, "");
			// High-TS
			// statement.setTimestamp(1, new Timestamp(-1));
			statement.execute();
			result = statement.getGeneratedKeys();
			if (result.next() && result != null) {
				msg.setId(Long.valueOf(result.getInt(1)));
				msg.setMsg_date(0); // Erstellungsdatum
				msg.setMsg_text(text);
				msg.setHistorisiert(2145744061000L);
				// acc.setLastTime(1429303464l);
			}


			//Message direkt in die Datenbank richtig formatiert speichern
			//Muss noch mit ins Insert intigriert werden
			persist(msg);
			statement.close();
			System.out.println("Message angelegt!");
		}
		finally {
			if (conn instanceof Connection) {
				conn.close();
			}
		}


		return msg;
	}

	@Override
	public void delete(Message entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Message> findAll() throws SQLException, ParseException{
		List<Message> lMsg = new ArrayList<Message>();

		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM fas_message;");
			ResultSet result;
			SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-DD HH:MM:SS");
			result = statement.executeQuery();

			while (result.next()) {
				// KIP Deklaration vll vor der Schleife? Performance
				Message msg = new Message();
				msg.setId(Long.valueOf(result.getInt(1)));
				msg.setMsg_date(tf.parse(result.getString(2)).getTime());
				msg.setMsg_text(result.getString(3));
				msg.setHistorisiert(tf.parse(result.getString(4)).getTime());
				// msg.setLastTime(result.getLong(5));
				lMsg.add(msg);
			}
			statement.close();
		}
		finally {
			if (conn instanceof Connection) {
				conn.close();
			}
		}

		return lMsg;
	}

	@Override
	public Message getById(long id) throws SQLException, ParseException {
		Message msg = new Message();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();

			PreparedStatement statement =  conn.prepareStatement("SELECT * FROM fas_message WHERE id = " + id + ";");
			ResultSet result;
			SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-DD HH:MM:SS");
			result = statement.executeQuery();

			while (result.next()) {
				msg.setId(Long.valueOf(result.getInt(1)));
				msg.setMsg_date(tf.parse(result.getString(2)).getTime());
				msg.setMsg_text(result.getString(3));
				msg.setHistorisiert(tf.parse(result.getString(4)).getTime());
				// msg.setLastTime(result.getLong(5));
				return msg;
			}
			statement.close();
		}
		finally {
			if (conn instanceof Connection) {
				conn.close();
			}
		}

		return null;
	}

	// Klassenspezifische Methode
	public Message getLastMsg() throws SQLException, ParseException {
		Message msg = new Message();
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM fas_message"
					+ " ORDER BY MSG_DATE DESC" + ";");
			ResultSet result;

			SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-DD HH:MM:SS");
			result = statement.executeQuery();

			while (result.next()) {
				msg.setId(Long.valueOf(result.getInt(1)));
				msg.setMsg_date(tf.parse(result.getString(2)).getTime());
				msg.setMsg_text(result.getString(3));
				msg.setHistorisiert(tf.parse(result.getString(4)).getTime());
				// msg.setLastTime(result.getLong(5));
				return msg;
			}
			statement.close();
		}
		finally {
			if (conn instanceof Connection) {
				conn.close();
			}
		}

		return null;
	}

	@Override
	public void persist(Message entity) throws SQLException {


		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(
					"UPDATE fas_message SET " + "TEXT = ?, HISTORISIERT = ? " + "WHERE id = " + entity.getId());
			statement.setString(1, entity.getMsg_text());
			statement.setTimestamp(2, new Timestamp(entity.getHistorisiert()));
			// statement.setLong(4, entity.getLastTime());
			statement.execute();

			statement.close();
		}
		finally {
			if (conn instanceof Connection) {
				conn.close();
			}
		}
	}

	@Override
	public void reload(Message entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Message create() {
		// TODO Auto-generated method stub
		return null;
	}

}
