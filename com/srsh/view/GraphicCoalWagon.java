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

        //pozicio lekerdezese a kirajzolashoz
        Point p = w.current.getCollection().getPosition(tc);

        //Szenes kocsi fekete lesz
        g2d.setColor(Color.BLACK);

        //x,y, magas, mely
        g2d.fillRect(p.x,p.y,20,20);


    }
}
