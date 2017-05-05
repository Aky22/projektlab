package com.srsh.view;

import com.srsh.model.Station;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicStation extends Drawable {

    protected Station station;

    GraphicStation(Station station, String img) throws IOException {
        this.station = station;
        this.img = ImageIO.read(new File(img));
    }

}
