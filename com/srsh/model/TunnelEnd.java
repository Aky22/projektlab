package com.srsh.model;

/**
 * 
 */
public class TunnelEnd extends Component {

    private boolean active;
    private Tunnel tunnel;

    /**
     *
     * @param x_0
     * @param y_0
     * @param x_1
     * @param y_1
     * @param id
     */
    public TunnelEnd(double x_0, double y_0, double x_1, double y_1, int id){
        super(x_0, y_0, x_1, y_1, id);
        active = false;
        System.out.print("created com.srsh.model.TunnelEnd with id: ");
    }

    /**
     *
     * @param t
     */
    protected void activate(Tunnel t) {
        active = !active;
        System.out.println("activated " + id + " " + active);
        tunnel = t;
    }

    /**
     * @return
     */
    private boolean isActive() {
        return active;
    }

    /**
     * @param l
     */
    public void operateOn(Locomotive l, char startSide) {
        tcCollection.insert(l, startSide);
        if(active){
            l.setInTunnel();
            tunnel.trainInside();
        }
    }

    @Override
    public void list(){
        String act;
        if(active)
            act = "activated";
        else act = "deactivated";

        System.out.println("com.srsh.model.TunnelEnd " + id + " at " + x0 + ", " + y0 + ": " + act + "\n" +
                "A side connected to " + A_id + "\n" +
                "B side connected to " + B_id);
    }
}