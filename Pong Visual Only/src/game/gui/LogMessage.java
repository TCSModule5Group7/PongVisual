package game.gui;

public class LogMessage {
	
	private String text;
	private MessageType type;
	
	public LogMessage(String text, MessageType type) {
		this.text = text;
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public MessageType getType() {
		return type;
	}
}
