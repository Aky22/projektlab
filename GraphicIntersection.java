package com.srsh.view;

import com.srsh.model.Intersection;
import com.srsh.model.Component;

import java.awt.*;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicIntersection extends DrawableComponent {
    /**
     * constructor for graphical intersections with the component object and string path to img
     * @param c
     * @param image
     */
    public GraphicIntersection(Component c, String image) {
        super(c, image);
        this.z_index = 2;
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(c.getPoint().x - 5, c.getPoint().y - 5, 10, 10);
    }
}
