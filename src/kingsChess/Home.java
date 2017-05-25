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
		JFrame window = new JFrame();
		setLayout(new GridLayout(8, 8, 2, 2));
		Cell.Init(this);
	    
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.pack();
		window.setResizable(false);
		window.setSize(800, 800);
		window.setVisible(true);
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
