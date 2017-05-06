package com.srsh.view;

import com.srsh.model.CoalWagon;
import com.srsh.model.TrainComponent;

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
        //TODO
    }
}
