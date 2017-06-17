package kingsChess;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	public String Name;
	public Cell SelectCell;
	public List<Cell> ListCells;
	private static User Current = new User();
	public static User getCurrent()
	{
		return Current;
	}
        public static void setCurrent(User u)
	{
		Current= u;
		Cell.reBind();
	}
}