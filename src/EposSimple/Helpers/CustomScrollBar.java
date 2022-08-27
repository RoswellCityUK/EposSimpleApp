/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EposSimple.Helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author tg
 */
public class CustomScrollBar extends JScrollBar {

    private boolean isThumbPressed;

    public CustomScrollBar(final int orientation, final Image thumb, final Image thumbPressed, final Image track) {
        super(orientation);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isThumbPressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isThumbPressed = false;
            }
        });
        setUI(new BasicScrollBarUI() {
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                if (isThumbPressed) {
                    g.drawImage(thumbPressed, r.x + r.width / 4, r.y, r.width / 2, r.height, null);
                } else {
                    g.drawImage(thumb, r.x + r.width / 4, r.y, r.width / 2, r.height, null);
                }
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                g.drawImage(track, r.x, r.y, r.width, r.height, null);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                Icon icon = new ImageIcon(getClass().getResource("/Images/icons8-chevron-up-18.png"));
                JButton decreaseButton = new JButton(icon) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(22, 22);
                    }
                };
                decreaseButton.setBorderPainted(false);
                decreaseButton.setBackground(Color.WHITE);
                return decreaseButton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                Icon icon = new ImageIcon(getClass().getResource("/Images/icons8-chevron-down-18.png"));
                JButton increaseButton = new JButton(icon) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(22, 22);
                    }
                };
                increaseButton.setBorderPainted(false);
                increaseButton.setBackground(Color.WHITE);
                return increaseButton;
            }
        });
    }
}
