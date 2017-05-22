package kingsChess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

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
        
	    for(int i = 0; i < 8; i++)
	    {
	    	for(int j = 0; j < 8; j++)
	    	{
	    		JButton btn=new JButton("btn_" + i + "_" + j);
	    		btn.setContentAreaFilled(false);
	    		btn.setBorder(new LineBorder(Color.WHITE));
	    		btn.setForeground(Color.WHITE);
	    		add(btn);
	    	}   
	    }
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.pack();
		window.setResizable(false);
		window.setSize(1080, 720);
		window.setVisible(true);
	}
	
	
	@Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      ImageIcon background = new ImageIcon("img/background.jpg");
      g.drawImage(background.getImage(), 0, 0, null);
    }

}
