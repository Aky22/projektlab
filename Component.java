
import java.util.*;

/**
 * 
 */
public abstract class Component {

    protected Collection tcCollection;
    protected Component A_End = null;
    protected Component B_End = null;
    protected Component C_End = null;
    protected Component D_End = null;
    protected double lenght;
    protected double x0, y0, x1, y1;

    /** Ezek az előző teszthez kellettek, törölhető majd - D.
    public boolean _TESTEND;
    public boolean _TESTCOLLISION;
     */

    public Component(){
        x0 = 0;
        y0 = 0;
        x1 = 0;
        y1 = 0;
        lenght = 0;
    }

    public Component(double x_0, double y_0, double x_1, double y_1){
        tcCollection = new Collection();
        x0 = x_0;
        y0 = y_0;
        x1 = x_1;
        y1 = y_1;
        lenght = Math.sqrt(Math.pow(x_0 - x_1, 2) + Math.pow(y_0 - y_1, 2));
    }

    /**
     * @param l
     */
    abstract public void operateOn(Locomotive l);

    /**
     * @return
     */
    public Collection getCollection(){
        return tcCollection;
    }

    /**
     * @param previous 
     * @param tc 
     * @return
     */
    public Component getNext(Component previous, TrainComponent tc){        // <--
        //TODO asszem ki is kell szedni kollekcióból - D.
        if(previous == A_End){
            return B_End;
        }
        if(previous == B_End){
            return A_End;
        }
        if(previous == C_End){
            return D_End;
        }
        if(previous == D_End){
            return C_End;
        }
        return null;
    }

    /**
     * @param tc
     */
    public void insert(TrainComponent tc){      //<-- ??
        tcCollection.insert(tc);
        //TODO
    }


    /**
     * Beállítja az adott elem adott végét
     * @param side - Az az oldal ahova csatlakozik a másik elem
     * @param end - Ehhez az elemhez kapcsolódó másik elem
     */
    public void setEnd(char side, Component end){
        switch (side){
            case 'A':
                A_End = end;
                break;
            case 'B':
                B_End = end;
                break;
            case 'C':
                C_End = end;
                break;
            case 'D':
                D_End = end;
                break;
        }
    }


    /**
     * Beállítja hogy a tesztkörnyezetben a vonat a lépés végén átlép-e a következő elemre
     * @param yes
     */
    /*public void set_TEST_LocomotiveWillBeAtTheEnd(boolean yes){
        _TESTEND = yes;
    }*/

    /**
     * Beállítja hogy a tesztkörnyezetben ezen a pályaelem ütközik-e a vonat
     * @param yes
     */
    //public void set_TEST_Collision(boolean yes) {_TESTCOLLISION = yes;}


    /**
     * Beállítja az A végét az elemnek
     * @param a
     */
   /* public void setAEnd(Component a){
        A_End = a;
    }*/

    /**
     * Beállítja az B végét az elemnek
     * @param b
     */
    /*public void setBEnd(Component b){
        B_End = b;
    }*/
}