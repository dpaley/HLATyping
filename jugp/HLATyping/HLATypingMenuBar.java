/**
 * Copyright Copyright 2017 Yu.Shirokov, D.Paley
 *
 *    This file is part of HLATypingApplication.
 *
 */
package jugp.HLATyping;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import jugp.HLATyping.Dialogs.AboutDialog;
import jugp.HLATyping.Help.HelpDialog;

public class HLATypingMenuBar extends JMenuBar implements ActionListener {

	private HLATypingApplication application;
	
	public HLATypingMenuBar (HLATypingApplication application) {
		this.application = application;
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem fileOpen = new JMenuItem("Open...");
		fileOpen.setMnemonic(KeyEvent.VK_O);
		fileOpen.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		fileOpen.setActionCommand("open");
		fileOpen.addActionListener(this);
		fileMenu.add(fileOpen);
		
		fileMenu.addSeparator();
		
		JMenuItem fileSave = new JMenuItem("Save report...");
		fileSave.setMnemonic(KeyEvent.VK_S);
		fileSave.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		fileSave.setActionCommand("save");
		fileSave.addActionListener(this);
		fileMenu.add(fileSave);
		
		fileMenu.addSeparator();
		
		JMenuItem fileClose = new JMenuItem("Close");
		fileClose.setMnemonic(KeyEvent.VK_C);
		fileClose.setAccelerator(KeyStroke.getKeyStroke('W', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		fileClose.setActionCommand("close");
		fileClose.addActionListener(this);
		fileMenu.add(fileClose);
		

		JMenuItem fileCloseAll = new JMenuItem("Close All");
		fileCloseAll.setMnemonic(KeyEvent.VK_A);
		fileCloseAll.setActionCommand("close_all");
		fileCloseAll.addActionListener(this);
		fileMenu.add(fileCloseAll);

		
		fileMenu.addSeparator();
		
		JMenuItem fileExit = new JMenuItem("Exit");
		fileExit.setMnemonic(KeyEvent.VK_X);
		fileExit.setActionCommand("exit");
		fileExit.addActionListener(this);
		fileMenu.add(fileExit);
		
		add(fileMenu);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem helpContents = new JMenuItem("Contents...");
		helpContents.setMnemonic(KeyEvent.VK_C);
		helpContents.setActionCommand("help_contents");
		helpContents.addActionListener(this);
		helpMenu.add(helpContents);
		
		helpMenu.addSeparator();
		
		JMenuItem helpAbout = new JMenuItem("About HLATyping");
		helpAbout.setMnemonic(KeyEvent.VK_A);
		helpAbout.setActionCommand("about");
		helpAbout.addActionListener(this);
		
		helpMenu.add(helpAbout);
		
		add(helpMenu);
		
	}

	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		
		if (command.equals("exit")) {
			System.exit(0);
		}
		else if (command.equals("open")) {
			application.openFile();
		}
		else if (command.equals("save")) {
			application.saveReport();
		}
		else if (command.equals("close")) {
			application.close();
		}
		else if (command.equals("close_all")) {
			application.closeAll();
		}
		else if (command.equals("help_contents")) {
			try {
				new HelpDialog(application,new File(URLDecoder.decode(ClassLoader.getSystemResource("Help").getFile(),"UTF-8")));
			} 
			catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		else if (command.equals("about")) {
			new AboutDialog(application);
		}
		else {
			JOptionPane.showMessageDialog(application, "Unknown menu command "+command, "Unknown command", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
