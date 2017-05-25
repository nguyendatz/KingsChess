package kingsChess;

import java.util.List;

public class User {
	public String Name;
	public Cell SelectCell;
	public List<Cell> ListCells;
	private static User Current = new User();
	public static User getCurrent()
	{
		return Current;
	}
}