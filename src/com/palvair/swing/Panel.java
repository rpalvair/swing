package com.palvair.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField fieldName;

	private JLabel labelName;

	private JLabel resultLabel;

	public Panel() {
		super();
	}

	public void build() {
		this.setBackground(Color.white);
		Border border = BorderFactory.createTitledBorder("Swing");
		this.setBorder(border);
		this.fieldName = new JTextField();
		this.fieldName.setPreferredSize(new Dimension(50, 30));
		this.labelName = new JLabel("Your name : ");
		this.add(this.labelName);
		this.add(this.fieldName);
		this.resultLabel = new JLabel();
		this.add(this.resultLabel);
		this.fieldName.addKeyListener(new InputKeyListener(this.fieldName, this.resultLabel));
	}

	public static class InputKeyListener implements KeyListener {
		private final JTextField fieldName;
		private final JLabel resultLabel;

		public InputKeyListener(JTextField fieldName, JLabel resultLabel) {
			this.fieldName = fieldName;
			this.resultLabel = resultLabel;
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			SwingUtilities.invokeLater(() -> {
				this.upperCase();
			});
		}

		private void upperCase() {
			this.resultLabel.setText(this.fieldName.getText().toUpperCase());
		}

	}

}
