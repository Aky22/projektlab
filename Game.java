import java.io.*;
import java.util.*;
import java.awt.Color;

/**
 * Created by domba on 2017. 04. 14..
 */
public class Game {
    ArrayList<Component> alMap = new ArrayList<>();
    ArrayList<TrainComponent> alTrain = new ArrayList<>();
    ArrayList<TrainComponent> alLocomotive = new ArrayList<>();
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

        System.out.println("Magic vonatos játék 1.0\nKilépés >quit<-al.");

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
                    list(split);
                    break;
                case "quit":
                    exit = true;
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
                int newId = alTrain.size() + 1;
                int newLocomotiveId = alLocomotive.size() +1;
                switch(params[2]){
                    case "Locomotive":
                        alTrain.add(new Locomotive(newId));
                        alLocomotive.add(new Locomotive(newLocomotiveId));
                        break;
                    case "Wagon":
                        switch(params[3]){ //leszarom, ennyi szín
                            case "blue":
                                alTrain.add(new Wagon(Color.BLUE, Integer.parseInt(params[4]), newId));
                                break;
                            case "red":
                                alTrain.add(new Wagon(Color.RED, Integer.parseInt(params[4]), newId));
                                break;
                            case "yellow":
                                alTrain.add(new Wagon(Color.YELLOW, Integer.parseInt(params[4]), newId));
                                break;
                        }
                        break;
                    case "CoalWagon":
                        alTrain.add(new CoalWagon(newId));
                        break;
                }
                System.out.print(alTrain.size() + "\n");
                break;
            case "m":
                double x_0 = Double.parseDouble(params[2]);
                double y_0 = Double.parseDouble(params[3]);
                int newId2 = alMap.size() + 1;
                switch(params[4]){
                    case "Intersection":
                        alMap.add(new Intersection(x_0, y_0, x_0, y_0, newId2));
                        break;
                    case "Rail":
                        alMap.add(new Rail(x_0, y_0,
                                Double.parseDouble(params[5]),
                                Double.parseDouble(params[6]), newId2));
                        break;
                    case "Station":
                        Color color = Color.BLACK;
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
                        alMap.add(new Station(x_0, y_0, x_0, y_0, color, Integer.parseInt(params[6]), newId2));
                        break;
                    case "TunnelEnd":
                        alMap.add(new TunnelEnd(x_0, y_0, x_0, y_0, newId2));
                        break;
                    case "Switch":
                        alMap.add(new Switch(x_0, y_0, x_0, y_0, newId2));
                        break;
                    case "Siding":
                        alMap.add(new Siding(x_0, y_0, x_0, y_0, newId2));
                        break;
                }
                System.out.print(alMap.size() + "\n");
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
                int firstID = Integer.parseInt(params[2]) - 1;
                int secondID = Integer.parseInt(params[3]) - 1;
                alTrain.get(firstID).connect('N', alTrain.get(secondID), secondID+1);
                alTrain.get(secondID).connect('P', alTrain.get(firstID), firstID + 1);
                System.out.println("connected " + firstID + " to " + secondID);
                break;
            case "m":
                int id1 = Integer.parseInt(params[2]);
                int id2 = Integer.parseInt(params[4]);
                char side1 = params[3].charAt(0);
                char side2 = params[5].charAt(0);
                alMap.get(id1 - 1).setEnd(side1, alMap.get(id2 - 1), id2);
                alMap.get(id2 - 1).setEnd(side2, alMap.get(id1 - 1), id1);
                System.out.println("connected (" + id1 + " to " + side2 + " side of " + id2 + ") and (" + id2 + " to " + side1 + " side of " + id1 + ")");
                break;
        }
    }

    /**
     * Léptet egy mozdonyt, vagy az összes mozdonyt paraméterezéstől függően
     * @param params
     */
    public void step(String[] params){
        if(params.length == 1){
            //Összes mozdony léptetése
            for(int i = 0; i < alTrain.size(); i++){
                alLocomotive.get(i).step();
            }
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
        tunnel.setEnd((TunnelEnd)alMap.get(Integer.parseInt(params[1]) - 1), Integer.parseInt(params[1]));
    }

    /**
     * Átváltja az id-edik váltót
     * @param params
     */
    public void _switch(String[] params){
        ((Switch)alMap.get(Integer.parseInt(params[1]) - 1)).Switch();
    }

    /**
     * Elhelyez egy vonatot egy sínen a megfelelő menetirányba
     * @param params
     */
    public void place(String[] params){
        alTrain.get(Integer.parseInt(params[1])).place(alMap.get(Integer.parseInt(params[2])), params[3].charAt(0));
    }

    /**
     * Státuszok lekérdezésére szolgál
     * @param params
     */
    public void list(String[] params){
        switch(params[1]){
            case "map":
                for(Component item : alMap){
                    item.list();
                }
                tunnel.list();
                break;
            case "train":
                for(TrainComponent item : alTrain){
                    item.list();
                }
                break;
        }
    }
}

