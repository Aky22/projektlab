/**
 * Created by Andras on 2017.04.15..
 */
public class Intersection extends Component{
    /**
     *
     * @param x_0
     * @param y_0
     * @param x_1
     * @param y_1
     * @param id
     */
    public Intersection(double x_0, double y_0, double x_1, double y_1, int id){
        super(x_0, y_0, x_1, y_1, id);
        System.out.print("created Intersection with id: ");
    }

    @Override
    public void operateOn(Locomotive l, char side) { //kész
        tcCollection.insert(l, side); //behelyezzük a kollekcióba
    }

    @Override
    public void list(){
        System.out.println("Intersection " + id + " at " + x0 + ", " + y0 + "\n" +
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id + "\n" +
                "C side connected to " + C_id + "\n" +
                "D side connected to " + D_id);
    }
}
