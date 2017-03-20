
import java.util.*;

/**
 * 
 */
public abstract class Component {
    protected Collection tcCollection;
    public boolean _TESTEND;
    public boolean _TESTCOLLISION;
    protected Component A_End = null;
    protected Component B_End = null;

    public Component(){
        tcCollection = new Collection();
        _TESTEND = false;
    }

    /**
     * @param l
     */
    abstract public void operateOn(Locomotive l);

    /**
     * @return
     */
    public Collection getCollection(){
        System.out.println("[Component].getCollection()");
        return tcCollection;
    }

    /**
     * @param previous 
     * @param tc 
     * @return
     */
    public Component getNext(Component previous, TrainComponent tc){
        System.out.println("[Component].getNext(Component previous, TrainComponent tc)");
        return A_End;
    }

    /**
     * @param tc
     */
    public void insert(TrainComponent tc){
        //TODO
    }

    /**
     * Beállítja hogy a tesztkörnyezetben a vonat a lépés végén átlép-e a következő elemre
     * @param yes
     */
    public void set_TEST_LocomotiveWillBeAtTheEnd(boolean yes){
        _TESTEND = yes;
    }

    /**
     * Beállítja hogy a tesztkörnyezetben ezen a pályaelem ütközik-e a vonat
     * @param yes
     */
    public void set_TEST_Collision(boolean yes) {_TESTCOLLISION = yes;}


    /**
     * Beállítja az A végét az elemnek
     * @param a
     */
    public void setAEnd(Component a){
        A_End = a;
    }

    /**
     * Beállítja az B végét az elemnek
     * @param b
     */
    public void setBEnd(Component b){
        B_End = b;
    }
}