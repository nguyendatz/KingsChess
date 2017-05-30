package kingsChess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Command extends JPanel {
	
	Command()
	{
		setSize(400, 800);
		JPanel inputPanel = new JPanel();
		JButton button = new JButton("send");
        JTextArea textArea = new JTextArea();
		JTextField textField = new JTextField(8);
		
        textField.setFont(textField.getFont().deriveFont(50f));
        add(textField);
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane);
        scrollPane.setViewportView(textArea);
        add(inputPanel);
        inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.add(textField);        // left will be the textField
        inputPanel.add(button);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}	
}
