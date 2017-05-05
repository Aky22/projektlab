package com.srsh.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class Drawable {

    protected Image img;
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
     * @param panel
     */
    public void draw(JPanel panel){
        JLabel picLabel = new JLabel(new ImageIcon(this.img));
        panel.add(picLabel);
    }

    /**
     * Set img
     * @param src
     * @throws IOException
     */
    protected void setImg(String src) throws IOException {
        this.img = ImageIO.read(new File(src));
    }

}
