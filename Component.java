
import java.util.*;

/**
 * 
 */
public interface Component {


    /**
     * 
     */
    public Component A_End = null;

    /**
     * 
     */
    public Component B_End = null;

    /**
     * @param l
     */
    public void operateOn(Locomotive l);

    /**
     * @return
     */
    public Collection getCollection();

    /**
     * @param previous 
     * @param tc 
     * @return
     */
    public Component getNext(Component previous, TrainComponent tc);

    /**
     * @param tc
     */
    public void insert(TrainComponent tc);

}