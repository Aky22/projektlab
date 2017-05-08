package com.srsh.view;

import com.srsh.model.Switch;
import com.srsh.model.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicSwitch extends DrawableComponent {
    /**
     * constructor for graphical switch with the component object and string path to img
     * @param _switch
     * @param img
     */
    GraphicSwitch(Switch _switch, String img) {
        super(_switch, img);
        this.z_index = 2;
    }

    @Override
    public void draw(Graphics g) {
        Switch _switch = (Switch) c;
        Component selected = _switch.getSelected();
        Component permanent = _switch.getNextSide('A');

        //kiválasztott vég megjelenítése: segédszámítások
        int otherX = 0;
        int otherY = 0;
        if (selected.getNextSide('A') == _switch) {
            otherX = selected.getBEnd().x;
            otherY = selected.getBEnd().y;
        } else {
            otherX = selected.getAEnd().x;
            otherY = selected.getAEnd().y;
        }
        int diffX = _switch.getPoint().x - otherX;
        int diffY = _switch.getPoint().y - otherY;
        //40 hosszúra alakítjuk:
        double length = Math.sqrt(Math.pow(diffX, 2) +
                Math.pow(diffY, 2));
        double zoom = length / 40.0;
        int drawX = (int) (_switch.getPoint().x - diffX /zoom);
        int drawY = (int) (_switch.getPoint().y - diffY/zoom);

        int pDiffX = _switch.getPoint().x, pDiffY = _switch.getPoint().y;
        if(permanent.getNextSide('A') == _switch){
            pDiffX -= permanent.getBEnd().x;
            pDiffY -= permanent.getBEnd().y;
        } else {
            pDiffX -= permanent.getAEnd().x;
            pDiffY -= permanent.getAEnd().y;
        }
        double pZoom = Math.sqrt(Math.pow(pDiffX,2)+ Math.pow(pDiffY,2)) / 40.0;
        int pDrawX = (int) (_switch.getPoint().x - pDiffX /pZoom);
        int pDrawY = (int) (_switch.getPoint().y - pDiffY/pZoom);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(_switch.getPoint().x, _switch.getPoint().y,
                drawX, drawY);

        g2d.setColor(Color.ORANGE);
        g2d.drawLine(_switch.getPoint().x, _switch.getPoint().y,
                pDrawX, pDrawY);
        g2d.setColor(Color.BLACK);

        g2d.setStroke(new BasicStroke(1));
    }
}
