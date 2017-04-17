
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Wagon extends TrainComponent {
    Color color;
    int passengerNumber;

    /**
     * 
     * @param c
     * @param i
     * @param id
     */
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
    public void place(Component current, char side) {
        this.current = current;
        this.current.insert(this, side);
        //ellenőrizni kell még hogy van-e már ott traincomponent
    }

    @Override
    public void list(){
        System.out.println("Wagon "+ this.id +" on "+ this.current.id +  " at "+ "pos" +
                "; next: "+nextId+", previous: "+ previousId +";"+"\n"+" collied "+ this.destroyed+"; destoyed "+this.destroyed+"; derailed "+derailed+"\n"+"passenger number: "+passengerNumber);
    }
}