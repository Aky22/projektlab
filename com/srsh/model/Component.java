package com.srsh.model;

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

    protected int id = 0;
    protected int A_id = 0;
    protected int B_id = 0;
    protected int C_id = 0;
    protected int D_id = 0;


    /** Ezek az előző teszthez kellettek, törölhető majd - D.
    public boolean _TESTEND;
    public boolean _TESTCOLLISION;
     */

    public Component(int id){
        x0 = 0;
        y0 = 0;
        x1 = 0;
        y1 = 0;
        lenght = 0;
        this.id = id;
    }

    /**
     *
     * @param x_0
     * @param y_0
     * @param x_1
     * @param y_1
     * @param id
     */
    public Component(double x_0, double y_0, double x_1, double y_1, int id){
        tcCollection = new Collection();
        x0 = x_0;
        y0 = y_0;
        x1 = x_1;
        y1 = y_1;
        lenght = Math.sqrt(Math.pow(x_0 - x_1, 2) + Math.pow(y_0 - y_1, 2));
        this.id = id;
    }

    /**
     * @param l
     */
    abstract public void operateOn(Locomotive l, char startSide);

    /**
     * @return
     */
    public Collection getCollection(){
        return tcCollection;
    }

    /**
     * @param previous 
     * @param tc 
     * @return com.srsh.model.Component
     * Átlépteti a következő elemre a vonatkomponenst
     */
    public Component getNext(Component previous, TrainComponent tc){        // átlépteti a következő elemre a paraméterként kapott komponenst
        //asszem ki is kell szedni kollekcióból - D.
        tcCollection.remove(tc);
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
     *
     * @param side
     * @return
     */
    public Component getNextSide(char side){

        switch (side){
            case 'A':
                return A_End;
            case 'B':
                return B_End;
            case 'C':
                return C_End;
            case 'D':
                return D_End;
            default:
                return null;
        }
    }

    /**
     * @param tc
     */
    public void insert(TrainComponent tc, char startSide){      //vagont helyez be
        tcCollection.insert(tc, startSide);
    }


    /**
     * Beállítja az adott elem adott végét
     * @param side - Az az oldal ahova csatlakozik a másik elem
     * @param end - Ehhez az elemhez kapcsolódó másik elem
     */
    public void setEnd(char side, Component end, int otherId){
        switch (side){
            case 'A':
                A_End = end;
                A_id = otherId;
                break;
            case 'B':
                B_End = end;
                B_id = otherId;
                break;
            case 'C':
                C_End = end;
                C_id = otherId;
                break;
            case 'D':
                D_End = end;
                D_id = otherId;
                break;
        }
    }

    /**
     * Státusz lekérdezésre szolgál list parancs kiadása esetén
     */
    abstract public void list();

    public int _getId(){
        return id;
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
   /* public void setAEnd(com.srsh.model.Component a){
        A_End = a;
    }*/

    /**
     * Beállítja az B végét az elemnek
     * @param b
     */
    /*public void setBEnd(com.srsh.model.Component b){
        B_End = b;
    }*/
}