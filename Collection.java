
import java.lang.reflect.Array;
import java.util.*;

/**
 * 
 */
public class Collection {

    private ArrayList<TrainComponent> trainComponents;
    private ArrayList<Float> trainComponentsPozotions;
    private ArrayList<Character> tranComponentsStartSide;      //a komponens beérkezésének oldala


    /**
     * Default constructor
     */
    public Collection() {
        trainComponents = new ArrayList<TrainComponent>();
        trainComponentsPozotions = new ArrayList<Float>();
        tranComponentsStartSide = new ArrayList<Character>();
    }


    /**
     * @param l
     */
    public void insert(TrainComponent l, char startSide) {
        System.out.println("[Collection].insert(TrainComponent l)");
        trainComponents.add(l);
        trainComponentsPozotions.add((float)0);
        tranComponentsStartSide.add(startSide);
    }

    /**
     * @param l
     */
    public void remove(TrainComponent l) {
        trainComponentsPozotions.remove(trainComponents.indexOf(l));
        trainComponents.remove(l);
    }

    /**
     * @param l 
     * @return
     */
    public boolean myComponentAtEnd(TrainComponent l) {
        float current_poz = trainComponentsPozotions.get(trainComponents.indexOf(l));
        for(int i = 0; i < trainComponents.size(); i++){        // vagy féltávon ütköznek vagy szembementek egymással
            //szembe mennek
            if(trainComponents.get(i) != l &&
            (char)tranComponentsStartSide.get(trainComponents.indexOf(l)) != (char)tranComponentsStartSide.get(i) &&
            (((tranComponentsStartSide.get(trainComponents.indexOf(l)) == 'A' || tranComponentsStartSide.get(trainComponents.indexOf(l)) == 'B') &&
            tranComponentsStartSide.get(i) == 'A' || tranComponentsStartSide.get(i) == 'B') || ((tranComponentsStartSide.get(trainComponents.indexOf(l)) == 'C' || tranComponentsStartSide.get(trainComponents.indexOf(l)) == 'D') &&
            tranComponentsStartSide.get(i) == 'C' || tranComponentsStartSide.get(i) == 'D'))&&
             current_poz == l.current.lenght - trainComponentsPozotions.get(i))
            {
                l.derail();
                trainComponents.get(i).derail();
            }
            else if(trainComponents.get(i) != l &&
                    (char)tranComponentsStartSide.get(trainComponents.indexOf(l)) != (char)tranComponentsStartSide.get(i) &&    //nem ugyan az az irány
                    (((tranComponentsStartSide.get(trainComponents.indexOf(l)) == 'A' || tranComponentsStartSide.get(trainComponents.indexOf(l)) == 'B') &&
                            tranComponentsStartSide.get(i) == 'C' || tranComponentsStartSide.get(i) == 'D') || ((tranComponentsStartSide.get(trainComponents.indexOf(l)) == 'C' || tranComponentsStartSide.get(trainComponents.indexOf(l)) == 'D') &&
                            tranComponentsStartSide.get(i) == 'A' || tranComponentsStartSide.get(i) == 'B'))&&
                    current_poz == (l.current.lenght)/2 && trainComponentsPozotions.get(i) == (l.current.lenght)/2){
                l.derail();
                trainComponents.get(i).derail();
            }
        }


        if(trainComponents.contains(l)){
            return l.current.lenght <= trainComponentsPozotions.get(trainComponents.indexOf(l));
        }
        else{
            return false;
        }
    }

    public TrainComponent getFirst(){
        if(trainComponents.isEmpty()){
            return null;
        } else {
            return trainComponents.get(0);
        }
    }




    private void updatePositionOf(TrainComponent l){
        if(trainComponents.contains(l))
            trainComponentsPozotions.add(trainComponents.indexOf(l),(float)1);
    }

    private boolean checkForComponentAt(float position){       //<-- átírtam a visszatérést boolean-ra, így látom értelmét
        return trainComponentsPozotions.contains(position);
    }

}