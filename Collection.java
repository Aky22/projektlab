
import java.util.*;

/**
 * 
 */
public class Collection {

    ArrayList<TrainComponent> trainComponents;

    /**
     * Default constructor
     */
    public Collection() {
        trainComponents = new ArrayList<TrainComponent>();
    }


    /**
     * @param l
     */
    public void insert(TrainComponent l) {
        System.out.println("[Collection].insert(TrainComponent l)");
        trainComponents.add(l);
    }

    /**
     * @param l
     */
    public void remove(TrainComponent l) {
        // TODO implement here
    }

    /**
     * @param l 
     * @return
     */
    public boolean myComponentAtEnd(TrainComponent l) {
        // TODO implement here
        return false;
    }

    public TrainComponent getFirst(){
        //TODO üresség vizsgálat később
        return trainComponents.get(0);
    }

}