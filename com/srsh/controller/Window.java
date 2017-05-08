package com.srsh.controller;

import javax.swing.*;
import java.awt.*;

/**
 * Főablakot megvalósító osztály
 * Created by Dombai Tamás on 2017. 05. 05..
 */
public class Window {
    /**
     * Kezdőablak
     */
    private JFrame frame;

    /**
     * Controller
     */
    private Controller controller;

    /**
     * Default konstruktor
     * Példányosít egy új főablakot, beállítja a gombok
     * eseménykezelőit, létrehozza a Model-t és View-t vezérlő
     * kontrollert.
     */
    public Window(){
        controller = new Controller();

        frame = new JFrame("srsh magic vonatos játék 1.0");
        JLabel info = new JLabel("Pálya kiválasztása");
        JButton startGame = new JButton("Start");
        JButton exit = new JButton("Kilépés");
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        JList list;

        listModel.addElement("palya1");
        listModel.addElement("palya2");
        listModel.addElement("palya3");

        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(3); //lehet több
        JScrollPane listScrollPane = new JScrollPane(list);

        exit.addActionListener(e -> System.exit(0));
        startGame.addActionListener(e -> {
            if(!controller.gameInProgress()) {
                controller.loadMap((String) list.getSelectedValue());
                controller.run();
            }
        });

        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());

        mainPane.add(info,BorderLayout.PAGE_START);

        mainPane.add(listScrollPane,BorderLayout.CENTER);

        JPanel bottomPane = new JPanel(new FlowLayout());
        bottomPane.add(startGame);
        bottomPane.add(exit);
        mainPane.add(bottomPane, BorderLayout.PAGE_END);

        frame.add(mainPane);

        frame.setVisible(true);
    }

    /**
     * Aktiválttá teszi az ablakot. Application hívja
     * @param value
     */
    public void setVisible(boolean value){
        frame.setVisible(value);
    }


}
