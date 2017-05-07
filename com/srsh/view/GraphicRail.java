package com.srsh.view;

import com.srsh.model.Rail;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicRail extends DrawableComponent {

    GraphicRail(Rail rail, String img) {
        super(rail, img);
        this.z_index = 1;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(c.getAEnd().x, c.getAEnd().y, c.getBEnd().x, c.getBEnd().y);
    }
}
