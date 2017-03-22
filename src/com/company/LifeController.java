package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ikkedus on 2/10/2017.
 */
public class LifeController implements ActionListener{
    private LifeModel _lifeModel;
    public LifeController(LifeModel lm) {
        _lifeModel = lm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _lifeModel.volgendeGeneratie();
    }
}
