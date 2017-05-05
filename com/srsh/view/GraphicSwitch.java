package com.srsh.view;

import com.srsh.model.Switch;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by erosa on 2017. 05. 05..
 */
public class GraphicSwitch extends Drawable {

    protected Switch _switch;

    GraphicSwitch(Switch _switch, String img) throws IOException {
        this._switch = _switch;
        this.img = ImageIO.read(new File(img));
    }

}
