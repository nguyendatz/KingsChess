package kingsChess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Home extends JPanel {
	
	Home()
	{
		setLayout(new GridLayout(8, 8, 2, 2));
                List<Cell> cells = User.getCurrent().ListCells;
                for(int i = 0; i < cells.size(); i++)
	    {
	    		
		add(cells.get(i).Button);
	    }
	}
	
	public void cellClick(ActionEvent e)
	{
		
	}
	
	@Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      ImageIcon background = new ImageIcon("img/background.jpg");
      g.drawImage(background.getImage(), 0, 0, null);
    }

}
