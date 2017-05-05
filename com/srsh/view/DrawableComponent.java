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
        if(c.isPoint()){
            Point p = c.getPoint();
            g.drawImage(img, p.x, p.y, 100, 100, null);
        }else{
            Point a = c.getAEnd();
            Point b = c.getBEnd();
            g.drawImage(img, a.x, a.y, , 100, null);
        }

    }
}
