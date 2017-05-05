package com.srsh.view; /**
 * Created by erosa on 2017. 05. 05..
 */

import com.srsh.model.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class View {
    protected JFrame frame;
    protected JPanel panel;
    protected ArrayList<Drawable> drawables = new ArrayList<Drawable>();

    public View() {
        frame = new JFrame("srsh magic vonatos játék 1.0");
        frame.setSize(400, 400);
        panel = new JPanel();
        frame.add(panel);
        //TODO
    }


    public void addComponent(String[] params, Component c) throws IOException {
        switch (params[4]) {
            case "Intersection":
                drawables.add(new GraphicIntersection((Intersection) c));
                break;
            case "Rail":
                drawables.add(new GraphicRail((Rail) c, "resources/rail.png"));
                break;
            case "Siding":
                drawables.add(new GraphicSiding((Siding) c));
                break;
            case "Station":
                drawables.add(new GraphicStation((Station) c, "resources/station.png"));
                break;
            case "Switch":
                drawables.add(new GraphicSwitch((Switch) c));
                break;
            case "TunnelEnd":
                drawables.add(new GraphicTunnelEnd((TunnelEnd) c));
                break;
            default: break;
        }
    }

    public void addTrainComponent(String[] params, TrainComponent c) {
        switch (params[2]) {
            case "CoalWagon":
                drawables.add(new GraphicCoalWagon((CoalWagon) c));
                break;
            case "Locomotive":
                drawables.add(new GraphicLocomotive((Locomotive) c));
                break;
            case "Wagon":
                drawables.add(new GraphicWagon((Wagon) c));
                break;
            default: break;
        }
    }

    public void trainComponentDerailed(TrainComponent tc) {
        //TODO
    }

    public void rainComponentCollided(TrainComponent tc) {
        //TODO
    }

    public void _switch(Switch s) {
        //TODO
    }

    public void tunnelEndActivated(TunnelEnd end) {
        //TODO
    }

    public void tunnelActivated() {
        //TODO
    }

    /**
     * Draw all component
     */
    public void drawAll() {
        for (int i = 0; i < drawables.size(); i++) {
            drawables.get(i).draw(this.panel);
        }
    }

    public void clear() {
        //TODO
    }

    public void setVisible(boolean value) {
        frame.setVisible(value);
    }

}
