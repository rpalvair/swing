package com.palvair.swing;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ResultPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel resultLabel;

	public ResultPanel() {
		super();
	}

	public JLabel getResultLabel() {
		return this.resultLabel;
	}

	public ResultPanel build() {
		this.setBackground(Color.white);
		Border border = BorderFactory.createTitledBorder("Result");
		this.setBorder(border);
		this.resultLabel = new JLabel();
		this.add(this.resultLabel);
		return this;
	}
}
