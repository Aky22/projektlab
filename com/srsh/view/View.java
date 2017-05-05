package com.srsh.view; /**
 * Created by erosa on 2017. 05. 05..
 */

import com.srsh.model.Component;
import com.srsh.model.Switch;
import com.srsh.model.TrainComponent;
import com.srsh.model.TunnelEnd;

import javax.swing.*;
import java.util.ArrayList;

public class View{
    protected JFrame frame;
    protected JPanel panel;
    protected ArrayList<Drawable> drawables = new ArrayList<Drawable>();

    public View(){
        frame = new JFrame("srsh magic vonatos játék 1.0");
        frame.setSize(400,400);
        //TODO
    }


    public void addComponent(String[] params, Component c){
        //TODO
    }

    public void addTrainComponent(String[] params, TrainComponent c){
        //TODO
    }

    public void trainComponentDerailed(TrainComponent tc){
        //TODO
    }

    public void rainComponentCollided(TrainComponent tc){
        //TODO
    }

    public void _switch(Switch s){
        //TODO
    }

    public void tunnelEndActivated(TunnelEnd end){
        //TODO
    }

    public void tunnelActivated(){
        //TODO
    }

    /**
     * Draw all component
     */
    public void drawAll(){
        for(int i = 0; i < drawables.size(); i++){
            drawables.get(i).draw(this.panel);
        }
    }

    public void clear(){
        //TODO
    }

    public void setVisible(boolean value){
        frame.setVisible(value);
    }

}
