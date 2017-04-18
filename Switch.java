
import java.util.*;

/**
 * 
 */
public class Switch extends Component {

    private boolean state;

    /**
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     * @param id
     */
    public Switch(double x0, double y0, double x1, double y1, int id){
        super(x0, y0, y1, x1, id);
        state = false;
        System.out.print("created Switch with id: ");
    }

    /**
     * @return
     */
    public void Switch() {
        TrainComponent first = tcCollection.getFirst(); ///<<< ez mi a...?
        if(first != null){
            first.derail();
        }

        state = !state; //+ valami az iránnyal??
    }

    @Override
    public Component getNext(Component previous, TrainComponent tc){
        //talán így jó???
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
    public void operateOn(Locomotive l, char startSide) {
        tcCollection.insert(l, startSide);
    }

    @Override
    public void list(){
        char s;
        if(state){
            s = 'C';
        } else s = 'B';

        System.out.println("Switch " + id + " at " + x0 + ", " + y0 + " switched to: " + s + "\n" +
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id + "\n" +
                "C side connected to " + C_id);
    }
}