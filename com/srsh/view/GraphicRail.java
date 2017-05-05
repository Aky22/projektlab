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
    static{
        try {
            img = ImageIO.read(new File("resources/rail.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    GraphicRail(Rail rail) throws IOException {
        this.rail = rail;
    }

}
