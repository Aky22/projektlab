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

            int rotationAnchorX = img.getWidth(null) / 2;
            int rotationAnchorY = img.getHeight(null) / 2;
            double rotation = Math.toRadians(30);

            AffineTransform at = new AffineTransform();
            at.translate(img.getWidth(null) / 2, img.getHeight(null) / 2);
            at.rotate(Math.toRadians(45));
            at.translate(-img.getWidth(null)/2, img.getHeight(null)/2);

            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            //TODO AF !!!!!!!!!!!!!!!


            g.drawImage(op.filter((BufferedImage) img, null), 0, 0, 400, 200, null);


            //g.drawImage(img, a.x, a.y, , 100, null);
        }

    }
}
