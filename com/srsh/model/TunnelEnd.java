package com.srsh.model;

/**
 * Alagútvéget reprezentáló osztály
 */
public class TunnelEnd extends Component {

    /**
     * Megadja, hogy aktív-e az alagútvég
     */
    private boolean active;

    /**
     * Ha aktív alagútban van, akkor ez tárolja az alagutat
     */
    private Tunnel tunnel;

    /**
     * Konstruktor
     * @param x_0 A vég x koord
     * @param y_0 A vég y koord
     * @param x_1 megegyrezik x_0al
     * @param y_1 megegyezik y_0al
     * @param id
     */
    public TunnelEnd(double x_0, double y_0, double x_1, double y_1, int id){
        super(x_0, y_0, x_1, y_1, id);
        active = false;
    }

    /**
     * Aktiválja az alagútvéget, egyben eltárolja
     * az alagutat is, amit ő alkot
     * @param t - Alagút
     */
    protected void activate(Tunnel t) {
        active = !active;
        System.out.println("activated " + id + " " + active);
        tunnel = t;
    }

    /**
     * Megadja, hogy aktív-e az alagút
     * @return
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Jelzi a mozdonynak, hogy alagúton halad át, ha aktív
     * @param l
     */
    public void operateOn(Locomotive l, char startSide) {
        tcCollection.insert(l, startSide,0);
        if(active){
            l.setInTunnel();
            tunnel.trainInside();
        }
    }

    /**
     * Státusz kiírása standard outputra
     */
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

    /**
     * Visszadja, hogy pontszerű
     * @return
     */
    @Override
    public boolean isPoint() {
        return true;
    }

    /**
     * Kattintásra aktiválja magát
     * @param game
     */
    @Override
    public void click(Game game){
        if(tunnel == null) { //aktiváljuk ilyenkor
            String[] recallParams = {"activate", String.valueOf(id)};
            game.activate(recallParams);
        } else {
            //deaktiváljuk ilyenkor
            tunnel.invalidate();
            active = false;
            tunnel = null;
        }

    }

    /**
     * Deaktiválja magát, törli az alagútra mutató referenciát
     */
    public void invalidate(){
        active = false;
        tunnel = null;
    }
}