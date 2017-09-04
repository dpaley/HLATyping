/**
 * Copyright Copyright 2017 Yu.Shirokov, D.Paley
 *
 *    This file is part of HLATypingApplication.
 *
 */
package jugp.HLATyping;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import jugp.HLATyping.HLATypingMenuBar;
import jugp.HLATyping.Dialogs.WelcomePanel;


public class HLATypingApplication extends JFrame {	
		
	private static final long serialVersionUID = 1L;

		public static final String VERSION = "0.1.0";
		
		private JTabbedPane fileTabs;
		private WelcomePanel welcomePanel;
		private File lastUsedDir = null;
		
		public HLATypingApplication () {
			
				setTitle("HLATyping");
				setIconImage(new ImageIcon(ClassLoader.getSystemResource("jugp/HLATyping/Resources/HLATyping_icon.png")).getImage());
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		setSize(1280, 720);
				setSize(800,600);
				setLocationRelativeTo(null);
				
				welcomePanel = new WelcomePanel();
				
				fileTabs = new JTabbedPane(JTabbedPane.TOP);
				setContentPane(welcomePanel);
				
				setJMenuBar(new HLATypingMenuBar(this));

				System.out.println("The end of application!");
			}
		
		public void openFile () {
			
		}


		public void saveReport () {
			
		}
		
		public void close () {
			if (fileTabs.getSelectedIndex() >=0) {
				fileTabs.remove(fileTabs.getSelectedIndex());
			}
			if (fileTabs.getTabCount() == 0) {
				setContentPane(welcomePanel);
				validate();
				repaint();
			}
		}
		
		public void closeAll () {
			fileTabs.removeAll();
			setContentPane(welcomePanel);
			validate();
			repaint();
		}

		public static void main(String[] args) {
			
				HLATypingApplication app = new HLATypingApplication();
				app.setVisible(true);
				
		}	

}
