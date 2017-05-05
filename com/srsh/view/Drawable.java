package com.srsh.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public abstract class Drawable {

    protected Image img;
    protected int z_index;

    public Drawable(String image){
        try {
            this.img = ImageIO.read(new File(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param other
     * @return true if this z_index is greater than the other, else return false
     */
    public boolean CompareTo(Drawable other){
        if(this.z_index > other.z_index){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param
     */
    public abstract void draw(Graphics g);

    /**
     * Set img
     * @param src
     * @throws IOException
     */
    protected void setImg(String src) throws IOException {
        this.img = ImageIO.read(new File(src));
    }

}
