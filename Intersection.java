/**
 * Created by Andras on 2017.04.15..
 */
public class Intersection extends Component{

    public Intersection(double x_0, double y_0, double x_1, double y_1){
        super(x_0, y_0, x_1, y_1);
    }

    @Override
    public void operateOn(Locomotive l) { //kész
        tcCollection.insert(l); //behelyezzük a kollekcióba
    }
}
