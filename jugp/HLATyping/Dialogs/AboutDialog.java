/**
 * Copyright Copyright 2017 Yu.Shirokov, D.Paley
 *
 *    This file is part of HLATypingApplication.
 *
 */
package jugp.HLATyping.Dialogs;

import javax.swing.*;

import jugp.HLATyping.HLATypingApplication;

import java.awt.*;
import java.awt.event.*;

public class AboutDialog extends JDialog {

    public AboutDialog(HLATypingApplication a) {
    	super(a);
        setTitle("About HLATyping...");  
        Container cont = getContentPane();
        cont.setLayout(new BorderLayout());
        
        add(new TitlePanel(),BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        
        JButton closeButton = new JButton("Close");
        getRootPane().setDefaultButton(closeButton);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                dispose();
            }
        });
        buttonPanel.add(closeButton);
        
        cont.add(buttonPanel,BorderLayout.SOUTH);
        
        setSize(650,230);
        setLocationRelativeTo(a);
        setResizable(false);
        setVisible(true);
    }
    
}
