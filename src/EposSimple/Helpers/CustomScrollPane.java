package EposSimple.Helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tg
 */
public class CustomScrollPane extends JScrollPane {

    public CustomScrollPane() {
        super(VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_NEVER);
        Image imageThumb = createImage(8, 8, Color.LIGHT_GRAY);
        Image imageThumbPressed = createImage(8, 8, Color.BLACK);
        Image imageTrack = createImage(8, 8, Color.WHITE);
        // Adding some test labels
        setHorizontalScrollBar(new CustomScrollBar(JScrollBar.HORIZONTAL, imageThumb, imageThumbPressed, imageTrack));
        setVerticalScrollBar(new CustomScrollBar(JScrollBar.VERTICAL, imageThumb, imageThumbPressed, imageTrack));
        setPreferredSize(new Dimension(200, 200));
    }

    private Image createImage(int width, int height, Color color) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.dispose();
        return image;
    }
}
