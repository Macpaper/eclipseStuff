package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class WriteToFile {
	JFrame frame;
	JPanel panel;
	JTextArea message;
	
	public WriteToFile() {

	}
	
	public static void main(String[] args) {
		new WriteToFile().go();
	}
	public void go() {
		
		frame = new JFrame("I am the frame");
		panel = new JPanel();
		
		message = new JTextArea(10, 20);
		JScrollPane mScroll = new JScrollPane(message);
		mScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton saveButton = new JButton("save masterpiece");
		saveButton.addActionListener(new MySaveListener());
		JButton loadButton = new JButton("load poop");
		loadButton.addActionListener(new MyLoadListener());
		panel.add(message);
		panel.add(saveButton);
		panel.add(loadButton);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
	public class MySaveListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			try {
				JFileChooser saveFile = new JFileChooser();
				saveFile.showSaveDialog(frame);
				BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile.getSelectedFile()));
				writer.write(message.getText());
				writer.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public class MyLoadListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			try {
				JFileChooser loadFile = new JFileChooser();
				loadFile.showOpenDialog(frame);
				BufferedReader reader = new BufferedReader(new FileReader(loadFile.getSelectedFile()));
				String line = null;
				message.setText("");
				while((line = reader.readLine()) != null) {
					message.append(line+"\n");
				}
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}




















