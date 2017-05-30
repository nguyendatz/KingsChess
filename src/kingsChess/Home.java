package kingsChess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Home extends JPanel {
	
	Home()
	{
		setLayout(new GridLayout(8, 8, 2, 2));
		Cell.Init(this);
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
