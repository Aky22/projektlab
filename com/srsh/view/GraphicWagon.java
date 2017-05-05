package com.srsh.view;

import com.srsh.model.Wagon;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicWagon extends Drawable {

    protected Wagon wagon;

    GraphicWagon(Wagon wagon, String img) throws IOException {
        this.wagon = wagon;
        this.img = ImageIO.read(new File(img));
    }

}
