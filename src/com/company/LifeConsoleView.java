package com.company;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ikkedus on 2/10/2017.
 */
public class LifeConsoleView implements Observer {
    private LifeModel _lifeModel;
    public LifeConsoleView(LifeModel lm){
        _lifeModel = lm;
        lm.addObserver(this);
    }
    public void refresh(){
        for (int i = 1; i < _lifeModel.kolom; i++) {
            for (int j = 1; j < _lifeModel.rij; j++) {
                toonCel(i,j);
            }
            System.out.println();
        }

    }
    public void toonCel(int rij,int kolom){
        System.out.print(_lifeModel.isLevend(rij,kolom)? 'X' : '.');
    }

    @Override
    public void update(Observable o, Object arg) {
        refresh();
    }
}
