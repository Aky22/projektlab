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

    /**
     * constructor for graphical wagons with the component object and string path to img
     * @param wagon
     */
    GraphicWagon(Wagon wagon)  {
        super(wagon);
        this.z_index = 9;
    }

    @Override
    public void draw(Graphics g) {

        //Keszitunk egy Wagon peldanyt belole
        Wagon w = (Wagon)tc;

        Graphics2D g2d = (Graphics2D) g;

        Point p;
        if(w.current.isPoint())
            p = w.current.getPoint();
        else p = w.current.getCollection().getPosition(w);


        //szin beallitasa
        g2d.setColor(w.getColor());

        //x,y, magas, mely
        g2d.fillRect(p.x-10,p.y-10,20,20);
        g2d.drawString(String.valueOf(w.getPassengerNumber()), p.x - 10, p.y - 15);

        g2d.setColor(Color.BLACK);
    }
}
