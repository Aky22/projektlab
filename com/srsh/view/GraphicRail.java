package com.srsh.view;

import com.srsh.model.Rail;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicRail extends Drawable {

    protected Rail rail;

    GraphicRail(Rail rail, String img) throws IOException {
        this.rail = rail;
        this.img = ImageIO.read(new File(img));
    }

}
