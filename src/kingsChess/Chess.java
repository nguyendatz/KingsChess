package kingsChess;

import java.io.Serializable;
import java.util.List;

public class Chess implements Serializable {
	private static final long serialVersionUID = 1L;
	public User User1;
	public User User2;
	public List<Cell> ListCells;
	private static Chess Current = new Chess();
	public User CurrentUser;
	public static Chess getCurrent()
	{
		return Current;
	}
        public static void setCurrent(Chess u)
	{
		Current= u;
	}
    public Chess(){
    	User1 = new User();
    	User2 = new User();
    	CurrentUser = User1;
    }
}