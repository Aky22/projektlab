
import java.util.*;

/**
 * 
 */
public class Switch extends Component {
    /**
     * @return
     */
    public void Switch() {
        System.out.println("[Switch].switch()");
        TrainComponent first = tcCollection.getFirst();
        if(first != null){
            first.derail();
        }
    }


    @Override
    public Component getNext(Component previous, TrainComponent tc){
        System.out.println("[Switch].getNext(Component previous, TrainComponent tc)");
        tcCollection.remove(tc);
        return A_End;
    }

    /**
     * @param l
     */
    public void operateOn(Locomotive l) {
        System.out.println("[Switch].operateOn(Locomotive l)");
        tcCollection.insert(l);
    }
}