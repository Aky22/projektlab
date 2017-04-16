
import java.util.*;

/**
 * 
 */
public class Switch extends Component {

    private boolean state;

    public Switch(double x0, double y0, double x1, double y1){
        super(x0, y0, y1, x1);
        state = false;
    }

    /**
     * @return
     */
    public void Switch() {
        System.out.println("[Switch].switch()");
        TrainComponent first = tcCollection.getFirst(); ///<<< ez mi a...?
        if(first != null){
            first.derail();
        }

        state = !state; //+ valami az iránnyal??
    }

    @Override
    public Component getNext(Component previous, TrainComponent tc){
        //TODO talán így jó???
        tcCollection.remove(tc);
        //       B (false)
        // A---<
        //       C (true)
        if(previous == A_End){
            if(state)
                return C_End;
            else return A_End;
        }
        if(previous == B_End){
            if(!state)
                return A_End;
            else tc.derail();
        }
        if(previous == C_End){
            if(state)
                return A_End;
            else tc.derail();
        }

        return null;
    }

    /**
     * @param l
     */
    public void operateOn(Locomotive l) {
        tcCollection.insert(l);
    }
}