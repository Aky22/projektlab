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

    protected int z_index;

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

}
