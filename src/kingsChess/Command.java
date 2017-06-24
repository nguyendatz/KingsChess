package kingsChess;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Command extends JPanel implements ActionListener {
	private static final long serialVersionUID = -4353247517392265446L;
    public static JTextArea textArea = new JTextArea();
    public static JTextField textField = new JTextField(8);
    
	Command() {
		setSize(400, 800);
		JPanel inputPanel = new JPanel();
		JButton button = new JButton("send");
		button.addActionListener(this);

		textField.setFont(textField.getFont().deriveFont(50f));
		add(textField);
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		scrollPane.setViewportView(textArea);
		add(inputPanel);
		inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		inputPanel.add(textField); // left will be the textField
		inputPanel.add(button);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void actionPerformed(ActionEvent e) {
		DataTransfer data = new DataTransfer(textField.getText());
		textField.setText("");
		data.sendToServer();
}
}
