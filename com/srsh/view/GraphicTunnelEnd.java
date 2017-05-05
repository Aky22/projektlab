package com.srsh.view;

import com.srsh.model.TunnelEnd;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicTunnelEnd extends Drawable {

    protected TunnelEnd tunelend;

    GraphicTunnelEnd(TunnelEnd tunelend, String img) throws IOException {
        this.tunelend = tunelend;
        this.img = ImageIO.read(new File(img));
    }

}
