
import java.util.*;

/**
 * 
 */
public class Rail extends Component {
    public Rail(double x_0, double y_0, double x_1, double y_1, int id){
        super(x_0, y_0, x_1, y_1, id);
        System.out.print("created Rail with id: ");
    }


    /**
     * @param l
     */
    @Override
    public void operateOn(Locomotive l) {
        tcCollection.insert(l); //behelyezzük a kollekcióba
    }

    public void placeLocomotive(char side, Locomotive locomotive){
        //TODO
        switch(side){       //még nincs kész
            case 'A':
                insert(locomotive);
                locomotive.next.place(this);

                break;
            case 'B':
                insert(locomotive);
                locomotive.next.place(this);

                break;

        }


    }

    @Override
    public void list(){
        System.out.println("Rail " + id + " at " + x0 + ", " + y0 + " to " + x1 + ", " + y1 + "\n" +
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id);
    }
}