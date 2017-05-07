package com.srsh.view;

import com.srsh.model.Siding;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicSiding extends DrawableComponent {
    GraphicSiding(Siding siding, String img) {
        super(siding, img);
        this.z_index = 2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(c.getPoint().x - 5, c.getPoint().y - 5, 10, 10);
        g.setColor(Color.BLACK);
    }
}
