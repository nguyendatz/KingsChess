package kingsChess;

import java.io.Serializable;
import java.util.List;

public class DataTransfer implements Serializable {
	private static final long serialVersionUID = 2686239242529462584L;
	public TypeData type;
	public User user;
	public List<Cell> listCell;
	public CellChange change;
	public String message;

	public void handleAction() {
		handleAction(false);
	}

	public void handleAction(boolean isServer) {
		switch (type) {
		case SetUser:
			User.setCurrent(user);
			MainFrame main = new MainFrame();
			break;
		case Message:
			if (isServer)
				sendToClient();
			else
			{
				Command.textArea.append(message);
				Command.textArea.append("\n");
			}
			break;
		case CellChange:
			Cell.applyChange(change);

			if (isServer)
				sendToClient();

			break;
		}
	}

	public enum TypeData {
		SetUser, Message, CellChange
	}

	public DataTransfer() {
	}

	public DataTransfer(CellChange change) {
		type = TypeData.CellChange;
		this.change = change;
	}

	public DataTransfer(User user) {
		type = TypeData.SetUser;
		this.user = user;
	}

	public DataTransfer(String message) {
		type = TypeData.Message;
		this.message = message;
	}

	public void sendToServer() {
		KingChessClient.sayToServer(this);
	}

	public void sendToClient() {
		KingChessServer.sayToPlayers(this);
	}
}
