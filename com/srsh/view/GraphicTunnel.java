package com.srsh.view;

import com.srsh.model.Component;
import com.srsh.model.Tunnel;

import java.awt.*;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicTunnel extends DrawableComponent {
    private Tunnel tunnel;
    public GraphicTunnel(Tunnel tunnel, Component c, String image) {
        super(c, image);
        this.tunnel = tunnel;
    }

    @Override
    public void draw(Graphics g) {
        if(tunnel.isActive()){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GRAY);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawLine(
                    tunnel.getAEnd().getPoint().x, tunnel.getAEnd().getPoint().y,
                    tunnel.getBEnd().getPoint().x, tunnel.getBEnd().getPoint().y
            );
            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(Color.BLACK);
        }
    }

}
