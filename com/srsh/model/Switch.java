package com.srsh.model;

/**
 * Váltót megvalósító osztály
 */
public class Switch extends Component {
    /**
     * Státusza
     *        B (false)
     *  A---<
     *       C (true)
     */
    private boolean state;

    /**
     * Vonat áthaladását jelzi, így az kisiklatható váltáskor
     */
    private boolean trainCrossing = false;

    /**
     * Utoljára áthaladt vonatelem
     */
    private TrainComponent lastCrossed = null;

    /**
     * Konstruktor
     * @param x0 A x koord
     * @param y0 A y koord
     * @param x1 B x koord
     * @param y1 B y koord
     * @param id modell id
     */
    public Switch(double x0, double y0, double x1, double y1, int id){
        super(x0, y0, x1, y1, id);
        state = false;
        System.out.print("created com.srsh.model.Switch with id: ");
    }

    /**
     * Váltást valósítja meg
     * Egyben kisiklatja a rajta áthaladó vonatot, ha létezik
     */
    public void Switch() {
        if(trainCrossing)
            lastCrossed.derail();

        state = !state; //+ valami az iránnyal??
        if(state)
            System.out.println("switched " + id + " new position: C");
        else System.out.println("switched " + id + " new position: B");
    }

    /**
     * Behelyezi a paraméterként kapott elemek a kollekcióba
     * @param tc berakni kívánt elem
     * @param startSide kezdőoldala
     * @param offset eltolás
     */
    @Override
    public void insert(TrainComponent tc, char startSide, int offset){
        tcCollection.insert(tc, startSide,offset);
        lastCrossed = tc;
    }

    /**
     * Visszaadja a következő pályaelemet
     * Rossz irányba történő áthaladás esetén kisiklatja a vonatot.
     * Utolsó kocsi áthaladásakor visszabillenti a flag-et így már
     * biztonságosan lehet váltani
     * @param previous vonatelem korábbi pályaeleme
     * @param tc vonatelem
     * @return Következő pályaelem
     */
    @Override
    public Component getNext(Component previous, TrainComponent tc){

        //       B (false)
        // A---<
        //       C (true)

        if(tc.next == null)
            trainCrossing = false;

        switch(tcCollection.getEntrySideOf(tc)){
            case 'A':
                tcCollection.remove(tc);
                if(state)
                    return C_End;
                else return B_End;
            case 'B':
                tcCollection.remove(tc);
                if(!state)
                    return A_End;
                else tc.derail();
                break;
            case 'C':
                tcCollection.remove(tc);
                if(state)
                    return A_End;
                else tc.derail();
                break;
        }
        //tcCollection.remove(tc);
        return null;
    }

    /**
     * Elhelyezi a mozdonyt a kollekcióban, egyben jelzi magának
     * hogy egy vonat halad át rajta
     * @param l
     */
    public void operateOn(Locomotive l, char startSide) {
        trainCrossing = true;
        lastCrossed = l;
        tcCollection.insert(l, startSide,0);
    }

    /**
     * Státusz kiírás standard outputra
     */
    @Override
    public void list(){
        char s;
        if(state){
            s = 'C';
        } else s = 'B';

        System.out.println("com.srsh.model.Switch " + id + " at " + x0 + ", " + y0 + " switched to: " + s + "\n" +
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id + "\n" +
                "C side connected to " + C_id);
    }

    /**
     * Megadja, hogy pontszerű
     * @return
     */
    @Override
    public boolean isPoint() {
        return true;
    }

    /**
     * Visszatér a kiválasztatott oldallal
     * @return kiválasztott odlal
     */
    public Component getSelected(){
        if(state)
            return C_End;
        else return B_End;
    }

    /**
     * Kattintást kezelő metódus, átváltja a váltót
     * @param game
     */
    @Override
    public void click(Game game){
        this.Switch();
    }
}