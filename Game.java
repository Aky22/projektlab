import java.io.*;
import java.util.*;

/**
 * Created by domba on 2017. 04. 14..
 */
public class Game {
    ArrayList<Component> alMap = new ArrayList<>();
    ArrayList<TrainComponent> alTrain = new ArrayList<>();
    Tunnel tunnel = new Tunnel();
    boolean exit;

    public Game() {
        exit = false;
    }

    /**
     * Végtelen ciklusban olvassa az inputban megjelenő parancsokat.
     * Parancsnak megfelelő privát metódusokat hív a parancs végrehajtására
     * a megadott paraméterekkel.
     * Application main függvénye hívja.
     */
    public void startGame(){
        //TODO függvényhívások, azok implementálása
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = null;
        String input = "";
        boolean saving = false;
        while(!exit){

            try { //olvasás
                input = br.readLine();
                if(saving) fw.write(input + '\n');
            } catch (IOException e) {
                System.out.println("Invalid input!");
            }

            String[] split = input.split(" "); //split szóközök mentén
            switch(split[0]){ //megfelelő metódus hívás, vagy "inline"
                case "create":
                    create(split);
                    break;
                case "connect":
                    connect(split);
                    break;
                case "step":
                    step(split);
                    break;
                case "activate":
                    activate(split);
                    break;
                case "switch":
                    _switch(split);
                    break;
                case "place":
                    place(split);
                    break;
                case "load":
                    //TODO
                    break;
                case "retry":
                    //TODO
                    break;
                case "save":
                    switch(split[1]){
                        case "save":
                            try {
                                fw = new FileWriter(split[2]);
                                saving = true;
                            } catch(java.io.IOException e){
                                //TODO
                                e.printStackTrace();
                            }
                            break;
                        case "end":
                            try {
                                fw.close();
                                saving = false;
                            } catch (IOException e) {
                                //TODO
                                e.printStackTrace();
                            }
                            break;
                    }
                    break;
                case "list":
                    //TODO
                    break;
            }
        }
    }

    /**
     * Új pályaelemet vagy vonatelemet hoz létre a paramétereknek megfelelően.
     * Parancs részletes leírását lsd. 7. dokumentumban.
     * @param params - parancs paraméterei lsd. 7. doksi
     */
    public void create(String[] params){
        //TODO konstruktor hívások, konstruktorok még hiányoznak azokból az osztályokból
        //TODO hozzáadás az arraylisthez
        switch(params[1]){
            case "t":
                switch(params[2]){
                    case "Locomotive":
                        break;
                    case "Wagon":
                        break;
                    case "CoalWagon":
                        break;
                }
                break;
            case "m":
                switch(params[4]){
                    case "Intersection":
                        break;
                    case "Rail":
                        break;
                    case "Station":
                        break;
                    case "TunnelEnd":
                        break;
                    case "Switch":
                        break;
                    case "Siding":
                        break;
                }
                break;
        }
    }

    /**
     * Összeköti a paraméterként kapott pálya vagy vonatelemeket
     * @param params - parancs paraméterei - lsd. 7. doksi
     */
    public void connect(String[] params){
        switch(params[1]){
            case "t":
                //TODO connectek, hiányoznak a metódusok még
                break;
            case "m":
                //TODO hiányozik a set char End-el
                break;
        }
    }

    /**
     * Léptet egy mozdonyt, vagy az összes mozdonyt paraméterezéstől függően
     * @param params
     */
    public void step(String[] params){
        if(params.length == 1){
            //TODO csak a mozdonyok léptetése (hogyan????)
        } else {
            alTrain.get(Integer.parseInt(params[1])).step();
        }
    }

    /**
     * Aktiválja az id-edik alagútvéget
     * @param params
     */
    public void activate(String[] params){
        //TODO lehet kéne oldal is???
        tunnel.setEnd((TunnelEnd)alMap.get(Integer.parseInt(params[1])));
    }

    /**
     * Átváltja az id-edik váltót
     * @param params
     */
    public void _switch(String[] params){
        ((Switch)alMap.get(Integer.parseInt(params[1]))).Switch();
    }

    /**
     * Elhelyez egy vonatot egy sínen a megfelelő menetirányba
     * @param params
     */
    public void place(String[] params){
        //TODO ötletem sincs...
    }
}