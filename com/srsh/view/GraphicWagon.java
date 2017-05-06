package com.srsh.view;

import com.srsh.model.Station;
import com.srsh.model.Wagon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicWagon extends DrawableTrainComponent {

    GraphicWagon(Wagon wagon, String img)  {
        super(wagon, img);
    }

    @Override
    public void draw(Graphics g) {

        Wagon w = (Wagon)tc;

        Graphics2D g2d = (Graphics2D) g;

        //pozicio lekerdezese
        Point p = w.current.getCollection().getPosition(tc);


        //x,y, magas, mely
        g2d.fillRect(p.x,p.y,20,20);

        g2d.setColor(w.getColor());
    }
}
