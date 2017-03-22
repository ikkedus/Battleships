package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by martin on 3/2/2017.
 */
public class CelController implements ActionListener {
    private int _rij;
    private int _kolom;
    private LifeModel _lifeModel;

    public CelController(LifeModel lifeModel,int rij,int kolom) {
        _lifeModel = lifeModel;
        _rij = rij;
        _kolom = kolom;
    }

    public void toggle(){
        _lifeModel.toggle(new CelPosition(_rij,_kolom));

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        toggle();
    }
}
