package com.srsh.controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dombai Tamás on 2017. 05. 05..
 */
public class Window {
    private JFrame frame;
    private Controller controller;

    public Window(){
        controller = new Controller();

        frame = new JFrame("srsh magic vonatos játék 1.0");
        JLabel info = new JLabel("Pálya kiválasztása");
        JButton startGame = new JButton("Start");
        JButton exit = new JButton("Kilépés");
        DefaultListModel listModel = new DefaultListModel();
        JList list;

        listModel.addElement("Pálya1");
        listModel.addElement("Pálya2");
        listModel.addElement("Pálya3");

        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(3); //lehet több
        JScrollPane listScrollPane = new JScrollPane(list);

        exit.addActionListener(e -> System.exit(0));
        startGame.addActionListener(e -> {
            controller.loadMap((String)list.getSelectedValue());
            controller.run();
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

    public void setVisible(boolean value){
        frame.setVisible(value);
    }


}
