package co.edu.uptc.view.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class ShapedButtonUI extends BasicButtonUI {

// ATRIBUTOS (COLORES USADOS)
	private final Color clickedColor = new Color(255, 255, 255, 40);
	private final Color hoverColor = new Color(255, 255, 255, 90);

// METODOS QUE SE SOBRESCRIBEN
	@Override
	public void paint(Graphics g, JComponent c) {
		setBackground(g, (JButton) c);
		setHighCualityImage((Graphics2D) g);
		super.paint(g, c);
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		setBtnMetadata((JButton) c);
	}

// METODOS PROPIOS DEL BOTON
	public void setBackground(Graphics g, JButton button) {
		Graphics2D g2 = (Graphics2D) g.create();
		
		Color baseColor = button.getBackground();
		g2.setColor(baseColor);
        g2.fillRoundRect(0, 0, button.getWidth(), button.getHeight(), 15, 15);
        
		if (button.getModel().isArmed()) {
			g2.setColor(clickedColor);
			g2.fillRoundRect(0, 0, button.getWidth(), button.getHeight(), 15, 15);
		} else if (button.getModel().isRollover()) {
			g2.setColor(hoverColor);
			g2.fillRoundRect(0, 0, button.getWidth(), button.getHeight(), 15, 15);
		}
		g2.dispose();
	}

	public void setHighCualityImage(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	}

	public void setBtnMetadata(JButton button) {
		button.setFont(new Font("Segoe UI", Font.BOLD, 20));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setForeground(Color.white);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
