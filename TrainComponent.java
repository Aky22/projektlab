
import java.util.*;

/**
 * 
 */
public interface TrainComponent {

    /**
     * 
     */
    public TrainComponent next = null;

    /**
     * 
     */
    public TrainComponent previous = null;

    /**
     * @return
     */
    public void derail();

}