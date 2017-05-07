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

        //Keszitunk egy Wagon peldanyt belole
        Wagon w = (Wagon)tc;

        Graphics2D g2d = (Graphics2D) g;

        //pozicio lekerdezese
        Point p = w.current.getCollection().getPosition(w);

        //szin beallitasa
        g2d.setColor(w.getColor());

        //x,y, magas, mely
        g2d.fillRect(p.x-10,p.y-10,20,20);


        g2d.setColor(Color.BLACK);
    }
}
