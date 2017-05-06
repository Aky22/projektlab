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
        if(active == false){ //nem aktív
            if(sideA == null){ //ez az első amit belerakunk
                sideA = t;
                A_id = newId;
                t.activate(this);
            } else { //ez a második. megvizsgáljuk hogy ugyanannak a sínnek a másik végén van-e
                Component aA = sideA.A_End;
                Component aB = sideA.B_End;
                if(aA == t.A_End || aA == t.B_End || aB == t.A_End || aB == t.B_End){ //ha azt a sínt fogják közre
                    sideB = t;
                    B_id = newId;
                    active = true;
                    t.activate(this);
                }
            }
        } else { //ha már van alagút, azt törüljük, és újat adunk hozzá
            invalidate();
            sideA = t;
            A_id = newId;
            t.activate(this);
        }
    }

    /**
     * @return
     */
    public boolean isActive() {
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

    public void invalidate(){
        if(sideA != null){
            sideA.activate(this);//deaktiváljuk
            sideA.invalidate();
        }
        if(sideB != null) {
            sideB.activate(this);
            sideB.invalidate();
        }
        A_id = 0;
        B_id = 0;
        sideA = null;
        sideB = null;
        active = false;
        trainInside = false;
    }

    public Component getAEnd(){
        return sideA;
    }

    public Component getBEnd(){
        return sideB;
    }

}