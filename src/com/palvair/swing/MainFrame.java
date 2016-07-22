package com.palvair.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TopPanel topPanel;

	private ResultPanel resultPanel;

	private JPanel mainPanel;

	public MainFrame() {
		super("application");
	}

	public void build() {
		this.topPanel = new TopPanel().build();
		this.resultPanel = new ResultPanel().build();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200, 200);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);
		this.topPanel.getFieldName()
				.addKeyListener(new InputKeyListener(this.topPanel.getFieldName(), this.resultPanel.getResultLabel()));
		this.mainPanel = new JPanel(new GridLayout(2, 1));
		this.mainPanel.add(this.topPanel);
		this.mainPanel.add(this.resultPanel);
		Container contentPane = this.getContentPane();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		this.setVisible(true);
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
			SwingUtilities.invokeLater(() -> {
				this.upperCase();
			});
		}

		@Override
		public void keyReleased(KeyEvent e) {
			SwingUtilities.invokeLater(() -> {
				this.upperCase();
			});
		}

		private void upperCase() {
			if (this.fieldName.getText().length() > 0) {
				this.resultLabel.setText("<html><p style=\"width:150px\">"
						+ StringService.capitalize(this.fieldName.getText() + "</p></html>"));
			} else {
				this.resultLabel.setText("");
			}

		}

	}
}
