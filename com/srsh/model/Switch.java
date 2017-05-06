package com.srsh.model;

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
        System.out.print("created com.srsh.model.Switch with id: ");
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
        if(state)
            System.out.println("switched " + id + " new position: C");
        else System.out.println("switched " + id + " new position: B");
    }

    @Override
    public Component getNext(Component previous, TrainComponent tc){
        //talán így jó???

        //       B (false)
        // A---<
        //       C (true)

        switch(tcCollection.getEntrySideOf(tc)){
            case 'A':
                if(state)
                    return C_End;
                else return B_End;
            case 'B':
                if(!state)
                    return A_End;
                else tc.derail();
                break;
            case 'C':
                if(state)
                    return A_End;
                else tc.derail();
                break;
        }


        tcCollection.remove(tc);
        return null;
    }

    /**
     * @param l
     */
    public void operateOn(Locomotive l, char startSide) {
        tcCollection.insert(l, startSide,0);
    }

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

    @Override
    public boolean isPoint() {
        return true;
    }

    public Component getSelected(){
        if(state)
            return C_End;
        else return B_End;
    }

    @Override
    public void click(Game game){
        this.Switch();
    }
}