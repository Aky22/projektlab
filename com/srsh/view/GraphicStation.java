package com.srsh.view;

import com.srsh.model.Station;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicStation extends DrawableComponent {

    /**
     * Konstruktor a modellben szereplő állomással
     * @param station
     */
    GraphicStation(Station station) {
       super(station);
       this.z_index = 2;
    }

    /**
     * Paraméterként kapott graphics objektumra kirajzolja magát
     * és az utasok számát az állomás színével
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(((Station)c).getColor());
        g.fillRect(c.getPoint().x - 5, c.getPoint().y - 5, 10, 10);
        String pn = String.valueOf(((Station) c).getPassengerNumber());
        g.drawString(pn, c.getPoint().x - 5, c.getPoint().y - 10);
        g.setColor(Color.BLACK);
    }
}
