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
                System.out.println("*2.1 Töröljük is utána? I/N");
                try{
                    ch = br.readLine();
                    switch(ch){
                        case "I":
                            test2(true);
                            break;
                        case "N":
                            test2(false);
                            break;
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 3:
                String currentType = null;
                String nextType = null;
                String ifSwitchGoodDirection = null;
                boolean collision = false, atEnd = false;
                System.out.println("*3.1 Jelenlegi elem? Sín, váltó, állomás, alagútszáj. S/V/A/L");
                try{
                    currentType = br.readLine();
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println("*3.2 Történik ütközés a lépés közben? I/N");
                try{
                    ch = br.readLine();
                    if(ch.equals("I")) collision = true;

                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println("*3.3 Jelenlegi elem végére kerül? I/N");
                try{
                    ch = br.readLine();
                    if(ch.equals("I")){
                        atEnd = true;
                        System.out.println("*3.2.1 Következő elem? (Sín, váltó, állomás, alagútszáj, vakvágány) S/V/A/L/K");
                        try{
                            nextType = br.readLine();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        switch (nextType){
                            case "A":
                                System.out.println("*3.2.1.3 Leszállás a vonatról");
                                break;
                            case "L":
                                System.out.println("*3.2.1.4 Alagútszájba lépés");
                                break;
                            case "K":
                                System.out.println("*3.2.1.5 Kisiklás");
                        }
                        System.out.println("3.2.2 Következő elemre lépés.");
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
                test3(currentType, collision, atEnd, nextType, ifSwitchGoodDirection);
                break;
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

    static void test2(boolean delete){
        Tunnel testTunnel = new Tunnel();
        TunnelEnd testTunnelEnd = new TunnelEnd();
        testTunnel.setEnd(testTunnelEnd);
        if(delete){
            testTunnel.setEnd(testTunnelEnd);
        } else {
            //semmi
        }
    }

    static void test3(String currentType, boolean collision, boolean atEnd, String nextType, String ifSwitchGoodDirection){
        Component current = null; //jelenlegi pályaelem
        Locomotive testLocomotive = new Locomotive(); //teszt mozdony
        Wagon testWagon = new Wagon(); //teszt vagon
        testLocomotive.setNext(testWagon); //hozzákötjük a vagont a mozdonyhoz



        switch(currentType){
            case "S": //sín
                current = new Rail();
                break;
            case "V": //váltó
                current = new Switch();
                break;
            case "A": //állomás
                current = new Station();
                break;
            case "L": //alagút
                current = new TunnelEnd();
                break;
        }

        //szekvencia fb-on, hajrá
    }
}
