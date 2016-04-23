package persistence.entity.impl;

import persistence.entity.AbstractEntity;

public class Message extends AbstractEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	---------------------------------
//	ID fuer die Datenbank, und als Identifikator;
	Long id;
//	Erstellungsdatum der Message
	long  msg_date;
//	Text der Message
	String msg_text;
//	Datum, wann die Message historisiert wurde
	long historisiert;
//	-------------------------------------
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public long getMsg_date() {
		return msg_date;
	}
	public void setMsg_date(long msg_date) {
		this.msg_date = msg_date;
	}
	public String getMsg_text() {
		return msg_text;
	}
	public void setMsg_text(String msg_text) {
		this.msg_text = msg_text;
	}
	public Long getHistorisiert() {
		return historisiert;
	}
	public void setHistorisiert(long historisiert) {
		this.historisiert = historisiert;
	}

	@Override
	public String toString() {
		return "Message \nid=" + id + ", \nmsg_date=" + msg_date + ", \nmsg_text=" + msg_text + ", \nhistorisiert="
				+ historisiert;
	}
	
	
}
