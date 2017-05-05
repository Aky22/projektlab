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

    protected Rail rail;

    GraphicRail(Rail rail, String img) {
        super(rail, img);
    }

}
