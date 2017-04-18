
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Locomotive extends TrainComponent {

    /**
     *
     * @param id
     */
    public Locomotive(int id){
        super(id);
        System.out.print("created Locomotive with id: ");
    }

    @Override
    public int atStation(Color c, int passengerNumber) {
        int ret = 0;
        ret += next.atStation(c, passengerNumber); //leszállók száma
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

            //előző komponensünk megegyezik a jelenlegi A/B/C/D oldallal akkor a
            //jelenlegi komponensünk azon oldalára kell lehelyezni a vonatelemet
            if(previousComponent == current.getNextSide('A'))
                current.operateOn(this, 'A');
            else if(previousComponent == current.getNextSide('B'))
                current.operateOn(this, 'B');
            else if(previousComponent == current.getNextSide('C'))
                current.operateOn(this, 'C');
            else if(previousComponent == current.getNextSide('D'))
                current.operateOn(this, 'D');
        }
        //következőt lépteti ha van
        if(next != null)
            next.step();

        System.out.println("stepped " + id + " new position " + current.getCollection()._getMyPosition(this));
    }


    @Override
    public void place(Component current, char side) {
        this.current = current;
        this.current.operateOn(this, side);
        //ellenőrizni kell még hogy van-e már ott traincomponent
    }


    //poz-t nem tudom meghivatkozni és az ütközéat a megsemmisüléssel jelzem, máshogy nincs tárolva
    @Override
    public void list(){
        System.out.println("Locomotive "+ this.id +" on "+ this.current.id +  " at " + current.getCollection()._getMyPosition(this) +
                ";"+"\n"+" next: "+nextId+"; collided "+ this.destroyed+"; destroyed "+this.destroyed+"; derailed "+derailed);
    }
}