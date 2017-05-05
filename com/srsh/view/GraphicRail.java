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
public class GraphicRail extends Drawable {

    protected Rail rail;

    GraphicRail(Rail rail, String img) throws IOException {
        this.rail = rail;
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(img));
        } catch (IOException e) {
        }

        this.img = image;
    }

}
