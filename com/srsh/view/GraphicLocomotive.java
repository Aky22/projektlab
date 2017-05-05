package com.srsh.view;

import com.srsh.model.Locomotive;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicLocomotive extends Drawable {

    protected Locomotive locomotive;

    GraphicLocomotive(Locomotive locomotive, String img) throws IOException {
        this.locomotive = locomotive;
        this.img = ImageIO.read(new File(img));
    }

}
