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
        //TODO
    }
}
