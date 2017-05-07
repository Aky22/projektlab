package com.srsh.model;

import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Collection {

    private ArrayList<TrainComponent> trainComponents;
    private ArrayList<Float> trainComponentsPozotions;
    private ArrayList<Character> trainComponentsStartSide;      //a komponens beérkezésének oldala


    /**
     * Default constructor
     */
    public Collection() {
        trainComponents = new ArrayList<TrainComponent>();
        trainComponentsPozotions = new ArrayList<Float>();
        trainComponentsStartSide = new ArrayList<Character>();
    }


    /**
     * @param l
     */
    public void insert(TrainComponent l, char startSide, int offset) {
        trainComponents.add(l);
        trainComponentsPozotions.add((float)offset);
        trainComponentsStartSide.add(startSide);
    }

    /**
     * @param l
     */
    public void remove(TrainComponent l) {
        trainComponentsPozotions.remove(trainComponents.indexOf(l));
        trainComponentsStartSide.remove(trainComponents.indexOf(l));
        trainComponents.remove(l);
    }

    public char getEntrySideOf(TrainComponent t){
        return trainComponentsStartSide.get(trainComponents.indexOf(t));
    }

    /**
     * @param l 
     * @return
     */
    public boolean myComponentAtEnd(TrainComponent l) {
        updatePositionOf(l);
        float current_poz = trainComponentsPozotions.get(trainComponents.indexOf(l));

        //Ha nem 0-a a hossz akkor sín
       // System.out.println("mycomponentatend curr lenght"+ l.current.lenght+" size "+trainComponents.size());
        if(l.current.lenght != 0 && trainComponents.size() > 1){

            for(int i = 0; i < trainComponents.size(); i++){
                //szembe mennek
                boolean side_ = (char) trainComponentsStartSide.get(trainComponents.indexOf(l)) != (char) trainComponentsStartSide.get(i);

                //nem egyeznek meg És különböző oldalról indultak ÉS abs értékben 1-nél közelebb vannak egymáshoz
                if((trainComponents.indexOf(l) != i) && (side_) && (1 >=  Math.abs((l.current.lenght - trainComponentsPozotions.get(i))-current_poz))){
                    l.derail();
                    trainComponents.get(i).derail();
                }
             //   System.out.println("\n"+"nem egyeznek meg: "+ (trainComponents.indexOf(l) != i)+" oldal egyezés : "+ (side_)+" azonos pont: "+(current_poz == l.current.lenght - trainComponentsPozotions.get(i))+ "Egyik: "+current_poz+" Masik: "+ (l.current.lenght - trainComponentsPozotions.get(i)));
            }
        }
        //ha nem sín akkor a hossz nem 0-a és ha ütközés van akkor a tárolt elemek szám nagyobb mint 1
        else if(l.current.lenght == 0 && trainComponents.size() > 1){
            trainComponents.get(1).derail();
            trainComponents.get(0).derail();
            if(trainComponents.size() > 2)
                trainComponents.get(2).derail();
            if(trainComponents.size() > 3)
                trainComponents.get(3).derail();
        }

        if(trainComponents.contains(l)){
            System.out.println(l.current._getId()+ " "+ l.current.lenght + " -- " + trainComponentsPozotions.get(trainComponents.indexOf(l)));
            return l.current.lenght <= trainComponentsPozotions.get(trainComponents.indexOf(l));
        }
        else{
            return false;
        }
    }

    /**
     *
     * @return first
     */
    public TrainComponent getFirst(){
        if(trainComponents.isEmpty()){
            return null;
        } else {
            return trainComponents.get(0);
        }
    }


    /**
     *
     * @param l
     */
    private void updatePositionOf(TrainComponent l){
        float current = trainComponentsPozotions.get(trainComponents.indexOf(l));
        trainComponentsPozotions.set(trainComponents.indexOf(l), current + 1.0f);
    }

    /**
     *
     * @param position
     * @return
     */
    private boolean checkForComponentAt(float position){       //<-- átírtam a visszatérést boolean-ra, így látom értelmét
        return trainComponentsPozotions.contains(position);
    }

    public float _getMyPosition(TrainComponent t){
        return trainComponentsPozotions.get(trainComponents.indexOf(t));
    }

    public Point getPosition(TrainComponent tc){
        int idx = trainComponents.indexOf(tc);
        Character startSide = trainComponentsStartSide.get(idx);
        Point current = null;
        double lenght = trainComponentsPozotions.get(idx);
        double v1;
        double v2;
        double x0;
        double y0;
        double a;
        if(startSide == 'A'){
            v1 = tc.current.x1 - tc.current.x0;
            v2 = tc.current.y1 - tc.current.y0;
            x0 = tc.current.x0;
            y0 = tc.current.y0;
            a = Math.sqrt((lenght*lenght)/(v1*v1+v2*v2));
            current = new Point((int)(x0+v1*a),(int)(y0+v2*a));
        }
        else if(startSide == 'B'){
            v1 = tc.current.x0 - tc.current.x1;
            v2 = tc.current.y0 - tc.current.y1;
            x0 = tc.current.x1;
            y0 = tc.current.y1;
            a = Math.sqrt((lenght*lenght)/(v1*v1+v2*v2));
            current = new Point((int)(x0+v1*a),(int)(y0+v2*a));
        }
        return current;
    }
}