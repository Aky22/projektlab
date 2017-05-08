package com.srsh.model;

/**
 * Alagutat reprezentáló osztály
 */
public class Tunnel {
    /**
     * Alagút A vége
     */
    private TunnelEnd sideA;

    /**
     * Alagút B vége
     */
    private TunnelEnd sideB;

    /**
     * A vég modell id-je
     */
    private int A_id = 0;

    /**
     * B vég modell id-je
     */
    private int B_id = 0;

    /**
     * Jelzi, hogy halad-e át éppen rajta vonat
     */
    private boolean trainInside;

    /**
     * Jelzi hogy az alagút aktív-e
     */
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
     * Beállítja az paraméterként kapott elemet az alagút egyik végének
     * VAGY
     * Deaktiválja a meglévő alagutat, és azt adja hozzá új végnek
     * Csak egy sín két végén lévő alagútvéget enged aktiválni
     * @param t új kiválasztott alagútvég
     * @param newId új alagútvég id-je
     */
    public void setEnd(TunnelEnd t, int newId) {
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
     * Megadja, hogy aktív-e az alagút
     * @return aktív-e
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Megadja, hogy van-e benne vonat
     * @return van-e benne vonat
     */
    public boolean trainInside() {
        return trainInside;
    }

    /**
     * Státusz lekérdezése standard outputra írással
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

    /**
     * Deaktiválja az alagutat, törli a végeit
     */
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

    /**
     * A végét adja vissza
     * @return A vég
     */
    public Component getAEnd(){
        return sideA;
    }

    /**
     * B végét adja vissza
     * @return B vég
     */
    public Component getBEnd(){
        return sideB;
    }

}