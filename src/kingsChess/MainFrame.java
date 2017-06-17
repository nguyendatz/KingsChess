package kingsChess;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends javax.swing.JFrame {
	public MainFrame() {

		JSplitPane splitPane = new JSplitPane();
		Home topPanel = new Home();
		Command bottomPanel = new Command();

		setPreferredSize(new Dimension(1200, 800));
		getContentPane().setLayout(new GridLayout());
		getContentPane().add(splitPane);

		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(800);
		splitPane.setLeftComponent(topPanel);
		splitPane.setRightComponent(bottomPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		pack();
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}
}