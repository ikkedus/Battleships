package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class LifeApplication extends JFrame{
    public LifeApplication(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game Of Life");
        LifeModel lm = new LifeModel();
        setBounds(100,100,lm.getRij()*10,lm.getKolom()*10);
        add(new LifePanelView(lm));
        LifeConsoleView view = new LifeConsoleView(lm);
        Timer tick = new Timer( 1000, new LifeController( lm ) );
        tick.start();
        setVisible(true);

    }

    public static void main(String[] args) {
        new LifeApplication();

    }

}
