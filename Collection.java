
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
        updatePositionOf(l);

        float current_poz = trainComponentsPozotions.get(trainComponents.indexOf(l));

        //Ha nem 0-a a hossz akkor sín
        if(l.current.lenght != 0 && trainComponents.size() > 1){
            for(int i = 0; i < trainComponents.size(); i++){
                //szembe mennek
                boolean side_ = (char)tranComponentsStartSide.get(trainComponents.indexOf(l)) != (char)tranComponentsStartSide.get(i);

                //nem egyeznek meg És különböző oldalról indultak ÉS azonos ponton vannal
                if((trainComponents.indexOf(l) != i) && (side_) && current_poz == l.current.lenght - trainComponentsPozotions.get(i)){
                    l.derail();
                    trainComponents.get(i).derail();
                }
            }
        }
        //ha nem sín akkor a hossz nem 0-a és ha ütközés van akkor a tárolt elemek szám nagyobb mint 1
        else if(l.current.lenght == 0 && trainComponents.size() > 1){
            //l.derail();
            trainComponents.get(1).derail();
            trainComponents.get(0).derail();
            //ha kereszteződés és pont egyszerre érnek oda mind a 4-en
            // trainComponents.get(2).derail();
            // trainComponents.get(3).derail();
        }

        if(trainComponents.contains(l)){
            return l.current.lenght <= trainComponentsPozotions.get(trainComponents.indexOf(l));
        }
        else{
            return false;
        }
    }

    /**
     *
     * @return first
     */
    public TrainComponent getFirst(){
        if(trainComponents.isEmpty()){
            return null;
        } else {
            return trainComponents.get(0);
        }
    }


    /**
     *
     * @param l
     */
    private void updatePositionOf(TrainComponent l){
        float current = trainComponentsPozotions.get(trainComponents.indexOf(l));
        trainComponentsPozotions.set(trainComponents.indexOf(l), current + 1.0f);
    }

    /**
     *
     * @param position
     * @return
     */
    private boolean checkForComponentAt(float position){       //<-- átírtam a visszatérést boolean-ra, így látom értelmét
        return trainComponentsPozotions.contains(position);
    }

    public float _getMyPosition(TrainComponent t){
        return trainComponentsPozotions.get(trainComponents.indexOf(t));
    }

}