package com.srsh.model;

/**
 * 
 */
public class Tunnel {

    private TunnelEnd sideA;
    private TunnelEnd sideB;
    private int A_id = 0;
    private int B_id = 0;
    private boolean trainInside;
    private boolean active;

    /**
     * Default constructor
     */
    public Tunnel() {
        sideA = null;
        sideB = null;
        trainInside = false;
        active = false;
    }


    /**
     * @param t 
     * @return
     */
    public void setEnd(TunnelEnd t, int newId) {
        //TODO: Be kéne kérni egy oldalt paraméternek, és ha az már aktív akkor lecserélni az új kapott oldalra, különben aktiválni.
        t.activate(this);
        if(sideA == null) {
            sideA = t;
            A_id = newId;
        } else if(sideB == null) {
            sideB = t;
            B_id = newId;
        }
        if(sideA != null && sideB != null){
            active = true;
        }
    }

    /**
     * @return
     */
    public boolean isActive() {
        System.out.println("[com.srsh.model.Tunnel].isActive()");
        //valami
        return active;
    }

    /**
     * @return
     */
    public boolean trainInside() {
        //implement here
        return trainInside;
    }

    /**
     *
     */
    public void list(){
        String a;
        if(active)
            a = "activated";
        else a = "deactivated";

        System.out.println(
                "com.srsh.model.Tunnel is " + a + "\n" +
                        "A side connected to " + A_id + "\n" +
                        "B side connected to " + B_id + "\n");
    }

}