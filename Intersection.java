/**
 * Created by Andras on 2017.04.15..
 */
public class Intersection extends Component{

    private Component CEnd;
    private Component DEnd;

    public Intersection(double x_0, double y_0, double x_1, double y_1, double len, Component cE, Component cD){
        super(x_0, y_0, x_1, y_1, len);
        CEnd = cE;
        DEnd = cD;
    }

    @Override
    public void operateOn(Locomotive l) {

    }
}
