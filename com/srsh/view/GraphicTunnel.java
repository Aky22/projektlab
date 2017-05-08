package com.srsh.view;

import com.srsh.model.Component;
import com.srsh.model.Tunnel;

import java.awt.*;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicTunnel extends DrawableComponent {
    private Tunnel tunnel;

    /**
     * constructor for graphical intersections with the tunnel, component object and string path to img
     * @param tunnel
     * @param c
     */
    public GraphicTunnel(Tunnel tunnel, Component c) {
        super(null);
        this.tunnel = tunnel;
        this.z_index = 10;
    }

    /**
     * draws the tunnel on Graphics g
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        if(tunnel.isActive()){
            System.out.println("MEGHÍVVVVVA");
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GRAY);
            g2d.setStroke(new BasicStroke(25));
            g2d.drawLine(
                    tunnel.getAEnd().getPoint().x, tunnel.getAEnd().getPoint().y,
                    tunnel.getBEnd().getPoint().x, tunnel.getBEnd().getPoint().y
            );
            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(Color.BLACK);
        }
    }

}
