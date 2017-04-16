import java.io.*;
import java.util.*;
import java.awt.Color;

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
                        case "start":
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
        switch(params[1]){
            case "t":
                switch(params[2]){
                    case "Locomotive":
                        alTrain.add(new Locomotive());
                        break;
                    case "Wagon":
                        switch(params[3]){ //leszarom, ennyi szín
                            case "blue":
                                alTrain.add(new Wagon(Color.BLUE, Integer.parseInt(params[4])));
                                break;
                            case "red":
                                alTrain.add(new Wagon(Color.RED, Integer.parseInt(params[4])));
                                break;
                            case "yellow":
                                alTrain.add(new Wagon(Color.YELLOW, Integer.parseInt(params[4])));
                                break;
                        }
                        break;
                    case "CoalWagon":
                        alTrain.add(new CoalWagon());
                        break;
                }
                break;
            case "m":
                double x_0 = Double.parseDouble(params[2]);
                double y_0 = Double.parseDouble(params[3]);
                switch(params[4]){
                    case "Intersection":
                        alMap.add(new Intersection(x_0, y_0, x_0, y_0));
                        break;
                    case "Rail":
                        alMap.add(new Rail(x_0, y_0,
                                Double.parseDouble(params[5]),
                                Double.parseDouble(params[6])));
                        break;
                    case "Station":
                        Color color;
                        switch(params[5]){ //szintén leszarom és ennyi lesz
                            case "blue":
                                color = Color.BLUE;
                                break;
                            case "yellow":
                                color = Color.YELLOW;
                                break;
                            case "red":
                                color = Color.RED;
                                break;
                        }
                        alMap.add(new Station(x_0, y_0, x_0, y_0, color, Integer.parseInt(params[6])));
                        break;
                    case "TunnelEnd":
                        alMap.add(new TunnelEnd(x_0, y_0, x_0, y_0));
                        break;
                    case "Switch":
                        alMap.add(new Switch(x_0, y_0, x_0, y_0));
                        break;
                    case "Siding":
                        alMap.add(new Siding(x_0, y_0, x_0, y_0));
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
                int firstID = Integer.parseInt(params[2]);
                int secondID = Integer.parseInt(params[3]);
                alTrain.get(firstID).connect('N', alTrain.get(secondID));
                alTrain.get(secondID).connect('P', alTrain.get(firstID));
                break;
            case "m":
                int id1 = Integer.parseInt(params[3]);
                int id2 = Integer.parseInt(params[5]);
                char side1 = params[4].charAt(0);
                char side2 = params[6].charAt(0);
                alMap.get(id1).setEnd(side1, alMap.get(id2));
                alMap.get(id2).setEnd(side2, alMap.get(id1));
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