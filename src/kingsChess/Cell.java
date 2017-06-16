package kingsChess;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Cell implements Serializable {
	public UUID Id;
	public ImageIcon Image;
	public JButton Button;
	public String Name;
	public int x, y;    // tọa độ của ô
        public  String type = null;// quân trắng hay quân đen.
        
	public static void Init()
	{
		List<Cell> list = new ArrayList<Cell>();
	
		for(int i = 0; i < 8; i++)
	    {
	    	for(int j = 0; j < 8; j++)
	    	{

	    		Cell cell = getCell(i, j);
	    		if(((i % 2 == 0) && (i*8 + j) % 2 == 0) || ((i % 2 != 0) && (i*8 + j) % 2 != 0))
	    		{
	    			cell.Button.setBackground(Color.decode("#ebdece"));
	    		}
	    		else
	    		{
	    			cell.Button.setBackground(Color.decode("#957663"));
	    		}
	    		
	    		cell.Button.setIcon(cell.Image);	    		
	    		ActionListener action = new CellClick();    		
	    		cell.Button.addActionListener(action);
	    		cell.Button.setActionCommand(cell.Id.toString());
				
				list.add(cell);
	    	}   
	    }
		
		User.getCurrent().ListCells = list;
	}
	
	public static Cell getCell(int x, int y)
	{
		Cell cell = new Cell();
		cell.Id = java.util.UUID.randomUUID();
		cell.Button = new JButton();
		cell.Button.setBorder(new LineBorder(Color.WHITE));
		cell.Button.setFocusPainted(false);
		cell.x = x; //tọa độ x
                cell.y = y; // tọa độ y
		if(x == 1)
		{
			cell.Name = "chot";
			cell.Image = new ImageIcon("img/chot.png");
                        cell.type = "den";
		}
		
		
		
                if(x == 6)
		{
			cell.Name = "chot";
			cell.Image = new ImageIcon("img/chot2.png");
                        cell.type = "trang";
		}
                if(x == 0){
                     cell.type = "den";
                }
                String tmp = ".png";
		if(x == 7) {
                    tmp = "2.png";
                    cell.type = "trang";
                }
		
		if(x == 0 || x == 7)
		{
			if(y == 0 || y == 7)
			{
				cell.Name = "xe";// sua chot thanh xe
				cell.Image = new ImageIcon("img/xe" + tmp);
			}
			else if(y == 1 || y == 6)
			{
				cell.Name = "ngua"; // sua chot thanh ngua
				cell.Image = new ImageIcon("img/ngua" + tmp);
			}
			else if(y == 2 || y == 5)
			{
				cell.Name = "tuong";
				cell.Image = new ImageIcon("img/tuong" + tmp);
			}
			else if((y == 3 && x == 0) || (y == 4 && x == 7))
			{
				cell.Name = "vua";
				cell.Image = new ImageIcon("img/vua" + tmp);
			}
			else if((y == 4 && x == 0) || (y == 3 && x == 7))
			{
				cell.Name = "hau";
				cell.Image = new ImageIcon("img/hau" + tmp);
			}
		}
		
		return cell;
	}
}