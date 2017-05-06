package com.srsh.view;

import com.srsh.model.Locomotive;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicLocomotive extends DrawableTrainComponent {
    GraphicLocomotive(Locomotive locomotive, String img) {
        super(locomotive, img);
    }

    @Override
    public void draw(Graphics g) {

        Graphics g2d = (Graphics)g;

        Locomotive loc = (Locomotive)tc;
        //Egyelnore Cyan mert miert ne, majd ki kene talalni valami mas szint neki / fekete a szenes kocsi :(((
        Color c = Color.CYAN;
        Point p = loc.current.getCollection().getPosition(tc);


        g2d.fillRect(p.x,p.y,20,20);
        g2d.setColor(c);

    }
}
