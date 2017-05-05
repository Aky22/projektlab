package com.srsh.view;

import com.srsh.model.CoalWagon;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicCoalWagon extends Drawable {

    protected CoalWagon coalwagon;

    GraphicCoalWagon(CoalWagon coalwagon, String img) throws IOException {
        this.coalwagon = coalwagon;
        this.img = ImageIO.read(new File(img));
    }

}
