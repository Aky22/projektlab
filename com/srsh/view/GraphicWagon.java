package com.srsh.view;

import com.srsh.model.Wagon;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicWagon extends DrawableTrainComponent {

    GraphicWagon(Wagon wagon, String img)  {
        super(wagon, img);
    }

}
