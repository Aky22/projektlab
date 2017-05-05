package com.srsh.view;

import com.srsh.model.Siding;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicSiding extends DrawableComponent {
    GraphicSiding(Siding siding, String img) {
        super(siding, img);
    }

}
