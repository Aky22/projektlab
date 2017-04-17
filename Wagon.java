
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Wagon extends TrainComponent {
    Color color;
    int passengerNumber;

    public Wagon(Color c, int i, int id){
        super(id);
        color =  c;
        passengerNumber = i;
        System.out.print("created Wagon with id: ");
    }

    /**
     * Állomásra érve hívódik meg.
     * @param c Az állomás színe
     * @return - Leszállt utasok száma
     */
    public int atStation(Color c, int passengerNumber) {
        int ret = 0;
        if(color == c){
            //utasok leszállása:
            ret = passengerNumber; //mivel kikötöttük hogy mindenki leszáll

            //utasok felszállása (mindenki felszáll):
            this.passengerNumber = passengerNumber;

            //mivel ekkor ez már "üres":
            if(next != null){
                ret += next.atStation(c, 0); //következőre már nem száll fel ezért senki
            }

            return ret; //visszatérünk a leszállt utasok számával
        }
        return ret; //ha nem egyezik a szín felesleges tovább hívni...
    }

    /**
     * Vagon léptetési metódusa.
     */
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

            //vagon behelyezés
            if(this.next == current.A_End)

            {
                current.insert(this, );
            }
        }
        //következőt lépteti ha van
        if(next != null)
            next.step();
    }


    @Override
    public void place(Component current) {

    }

    @Override
    public void list(){
        //TODO
    }
}