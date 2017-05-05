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

    public DrawableComponent(Component c, String image){
        super(image);
        this.c = c;
    }

    @Override
    public void draw(Graphics g) {

        if(c.isPoint()){
            Point p = c.getPoint();
            g.drawImage(img, p.x - 25, p.y - 25, 50, 50, null);
        }else{
            Point a = c.getAEnd();
            Point b = c.getBEnd();

            int centerX;
            int centerY;
            if(a.x > b.x)
                centerX = a.x - b.x;
            else centerX = b.x - a.x;
            if(a.y > b.y)
                centerY = a.y - b.y;
            else centerY = b.y - a.y;

            double rotation = Math.toRadians(45);

            AffineTransform tx = AffineTransform.getRotateInstance(rotation, centerX, centerY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

            g.drawImage(op.filter((BufferedImage) img, null), centerX, centerY, 200, 200, null);


            //g.drawImage(img, a.x, a.y, , 100, null);
        }

    }
}
