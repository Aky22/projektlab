import java.awt.*;

/**
 * Created by Andras on 2017.04.15..
 */
public class CoalWagon extends TrainComponent{

    public CoalWagon(int id){
        super(id);
        System.out.print("created CoalWagon with id: ");
    }

    @Override
    public int atStation(Color c, int passengerNumber) {
        int ret = 0;
        if(next != null){
            ret += next.atStation(c, passengerNumber);
        }
        return ret;
    }

    @Override
    public void step() {
        Collection collection = current.getCollection();

        //ellenőrzi, hogy a végén van-e
        boolean atEnd = collection.myComponentAtEnd(this);

        //ha igen
        if(atEnd){
            //lekéri a következő pályaelemet
            Component next = current.getNext(previousComponent, this);

            //beállítja az aktuálisat és az előzőt
            previousComponent = current;
            current = next;

            //vagont helyez be
            if(previousComponent == current.getNextSide('A'))   //előző komponensünk megegyezik a jelenlegi A/B/C/D oldallal akkor a jelenlegi komponensünk azon oldalára kell lehelyezni a vonatelemet
                current.insert(this, 'A');
            else if(previousComponent == current.getNextSide('B'))
                current.insert(this, 'B');
            else if(previousComponent == current.getNextSide('C'))
                current.insert(this, 'C');
            else if(previousComponent == current.getNextSide('D'))
                current.insert(this, 'D');

        }
        //következőt lépteti ha van
        if(next != null)
            next.step();
    }

    @Override
    public void place(Component current, char side) {      // ??
        //TODO !!!!!
    }

    @Override
    public void list(){
        //TODO
    }
}
