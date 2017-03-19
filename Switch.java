
import java.util.*;

/**
 * 
 */
public class Switch implements Component {
    private Collection tcCollection;
    /**
     * Default constructor
     */
    public Switch() {
        tcCollection = new Collection();
    }


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

    /**
     * @param l
     */
    public void operateOn(Locomotive l) {
        System.out.println("[Switch].operateOn(Locomotive l)");
        tcCollection.insert(l);
    }

    /**
     * @return
     */
    public Collection getCollection() {
        // TODO implement here
        return null;
    }

    /**
     * @param previous 
     * @param tc 
     * @return
     */
    public Component getNext(Component previous, TrainComponent tc) {
        // TODO implement here
        return null;
    }

    /**
     * @param tc
     */
    public void insert(TrainComponent tc) {
        // TODO implement here
    }

}