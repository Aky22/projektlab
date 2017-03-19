import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by erosa on 2017. 03. 19..
 */
public class Application {

    /**
     *
     * @param args
     */
    public static void main(String[] args){

        int choose = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ch;

        System.out.println("1. Váltó állítás");
        System.out.println("2. Alagútszáj építés");
        System.out.println("3. Vonat mozgatása");
        try {
            choose = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch(choose){
            case 1:
                System.out.println("*1.1 Van rajta vonatelem? I/N");
                try{
                    ch = br.readLine();
                    switch(ch){
                        case "I":
                            test1(true);
                            break;
                        case "N":
                            test1(false);
                            break;
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("*2.1 Építés vagy törlés? E/T");
                try{
                    ch = br.readLine();
                    switch(ch){
                        case "E":
                            //TODO: Call function
                            break;
                        case "T":
                            //TODO: Call function
                            break;
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("*3.1 Jelenlegi elem? Sín, váltó, állomás, alagútszáj. S/V/A/L");
                System.out.println("*3.2 Történik ütközés a lépés közben? I/N");
                System.out.println("*3.3 Jelenlegi elem végére kerül? I/N");
                try{
                    ch = br.readLine();
                    switch(ch){
                        case "S":
                            //TODO: Call function
                            break;
                        case "V":
                            //TODO: Call function
                            break;
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
        }

    }

    static void test1(boolean thereIsATrainOnIt){
        Switch testSwitch = new Switch();
        if(thereIsATrainOnIt){ //ha van rajta valami
            Locomotive testLocom = new Locomotive(); //létrehozunk egy új mozdonyt
            Wagon testWagon = new Wagon(); //és egy új kocsit
            testLocom.setNext(testWagon); //hozzákötjük a mozdonyhoz a kocsit
            testSwitch.operateOn(testLocom); //"ráléptetjük" a mozdonyt a váltóra
        } else {
            //nem történik semmit
        }
        testSwitch.Switch(); //átállítjuk a váltót
    }

    static void test3(char currentType, boolean collision, boolean atEnd, char nextType, char ifSwitchGoodDirection){
        Component current = null; //jelenlegi pályaelem
        Locomotive testLocomotive = new Locomotive(); //teszt mozdony
        Wagon testWagon = new Wagon(); //teszt vagon
        testLocomotive.setNext(testWagon); //hozzákötjük a vagont a mozdonyhoz



        switch(currentType){
            case 'S': //sín
                current = new Rail();
                break;
            case 'V': //váltó
                current = new Switch();
                break;
            case 'A': //állomás
                current = new Station();
                break;
            case 'L': //alagút
                current = new TunnelEnd();
                break;
        }


    }
}
