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

    static{
        try {
            img = ImageIO.read(new File("resources/station.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    GraphicStation(Station station){
        this.station = station;
    }

}
