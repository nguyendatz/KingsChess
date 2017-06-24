package kingsChess;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class MainFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 7147201131448536876L;

	public MainFrame() {

		JSplitPane splitPane = new JSplitPane();
		Home topPanel = new Home();
		Command bottomPanel = new Command();

		setPreferredSize(new Dimension(1000, 600));
		getContentPane().setLayout(new GridLayout());
		getContentPane().add(splitPane);

		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(600);
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