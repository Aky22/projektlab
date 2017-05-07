package com.srsh.view;

import com.srsh.model.CoalWagon;
import com.srsh.model.TrainComponent;
import com.srsh.model.Wagon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicCoalWagon extends DrawableTrainComponent {
    public GraphicCoalWagon(TrainComponent tc, String image){
        super(tc, image);
    }

    @Override
    public void draw(Graphics g) {
        CoalWagon w = (CoalWagon)tc;

        Graphics2D g2d = (Graphics2D) g;

        Point p;
        if(w.current.isPoint())
            p = w.current.getPoint();
        else p = w.current.getCollection().getPosition(w);

        //Szenes kocsi fekete lesz
        g2d.setColor(Color.BLACK);

        //x,y, magas, mely
        g2d.fillRect(p.x-10,p.y-10,20,20);


    }
}
