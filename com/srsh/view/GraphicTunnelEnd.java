package com.srsh.view;

import com.srsh.model.TunnelEnd;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicTunnelEnd extends DrawableComponent {

    /**
     * constructor for graphical tunnelends
     * @param tunelend
     * @param img
     */
    GraphicTunnelEnd(TunnelEnd tunelend){
        super(tunelend);
        this.z_index = 11;
    }

    /**
     * sets the color of the active tunnelend to green on
     * @param g
     */
    @Override
    public void draw(Graphics g) {

        if(((TunnelEnd)c).isActive())
            g.setColor(Color.GREEN);
        else g.setColor(Color.RED);

        g.fillOval(c.getPoint().x - 5, c.getPoint().y - 5, 10, 10);
        g.setColor(Color.BLACK);
    }
}
