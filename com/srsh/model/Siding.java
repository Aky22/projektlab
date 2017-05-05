package com.srsh.model;

/**
 * 
 */
public class Siding extends Component {
    /**
     *
     * @param x_0
     * @param y_0
     * @param x_1
     * @param y_1
     * @param id
     */
    public Siding(double x_0, double y_0, double x_1, double y_1, int id){
        super(x_0, y_0, x_1, y_1, id);
        System.out.print("created com.srsh.model.Siding with id: ");
    }

    /**
     * @param l
     */
    @Override
    public void operateOn(Locomotive l, char side) { //kész
        tcCollection.insert(l, side); //behelyezzük a kollekcióba
        l.derail();
    }

    /**
     * @param previous
     * @param tc
     * @return
     */
    public Component getNext(Component previous, TrainComponent tc) {
        //teljesen mindegy idáig úgyse jut el
        return null;
    }

    @Override
    public void list(){
        System.out.println("com.srsh.model.Siding " + id + " at " + x0 + ", " + y0 + "\n" +
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id);
    }
}