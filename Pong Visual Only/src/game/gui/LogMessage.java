package game.gui;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogMessage {
	
	private String text;
	private MessageType type;
	private static final SimpleDateFormat formatter = new SimpleDateFormat("[HH:mm:ss.SSS] ");
	
	public LogMessage(String text, MessageType type) {
		this.text = formatter.format(new Date()) + text;
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public MessageType getType() {
		return type;
	}
}
