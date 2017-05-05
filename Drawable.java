import javax.swing.*;
import java.awt.*;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class Drawable {

    protected Image img;
    protected int z_index;

    /**
     *
     * @param other
     * @return true if this z_index is greater than the other, else return false
     */
    public boolean CompareTo(Drawable other){
        if(this.z_index > other.z_index){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param panel
     */
    public void draw(JPanel panel){
        JLabel picLabel = new JLabel(new ImageIcon(this.img));
        panel.add(picLabel);
    }

}
