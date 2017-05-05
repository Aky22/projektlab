/**
 * Created by erosa on 2017. 05. 05..
 */

import javax.swing.*;
import java.util.ArrayList;

public class View{

    protected JPanel panel;
    protected ArrayList<Drawable> drawables = new ArrayList<Drawable>();

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



}
