package com.srsh.view;


import com.srsh.model.*;
import com.srsh.model.Component;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;


/**
 * Created by Dombai Tamás on 2017. 05. 05..
 */
public abstract class DrawableComponent extends Drawable{
    protected Component c;

    /**
     * Rajzolható elemek konstruktora, paraméterként kapja a komponens mellett a képfájl elérési útját
     * @param c
     * @param image
     */
    public DrawableComponent(Component c, String image){
        super(image);
        this.c = c;
    }

    @Override
    public abstract void draw(Graphics g);



}

