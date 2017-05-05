package com.srsh.view;


import com.srsh.model.*;
import com.srsh.model.Component;

import java.awt.*;


/**
 * Created by Dombai Tamás on 2017. 05. 05..
 */
public abstract class DrawableComponent extends Drawable{
    protected Component c;

    public DrawableComponent(Component c, String image){
        super(image);
        this.c = c;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, 10, 10, 100, 100, null);
    }
}
