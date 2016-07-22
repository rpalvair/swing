package com.palvair.swing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TopPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField fieldName;

	private JLabel labelName;

	public TopPanel() {
		super();
	}

	public JTextField getFieldName() {
		return this.fieldName;
	}

	public TopPanel build() {
		this.setBackground(Color.white);
		Border border = BorderFactory.createTitledBorder("Input");
		this.setBorder(border);
		this.fieldName = new JTextField();
		this.fieldName.setPreferredSize(new Dimension(50, 30));
		this.labelName = new JLabel("Your name : ");
		this.add(this.labelName);
		this.add(this.fieldName);
		return this;
	}
}
