package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ikkedus on 2/17/2017.
 */
public class LifePanelView extends JPanel implements Observer{
    private LifeModel _lifeModel;
    private GridLayout grid;
    public LifePanelView(LifeModel lm){
        _lifeModel = lm;
        lm.addObserver(this);

        grid = new GridLayout(_lifeModel.kolom-2,_lifeModel.rij-2);
        this.setLayout(grid);
        refresh();
        setBounds(0,0,lm.getRij()*10,lm.getKolom()*10);
    }
    public void refresh(){
        this.removeAll();
        for (int i = 1; i < _lifeModel.kolom-1; i++) {
            for (int j = 1; j < _lifeModel.rij-1; j++) {
                add(toonCel(i,j));
            }
        }
        this.revalidate();
    }
    public JButton toonCel(int rij,int kolom){
        JButton btn = new JButton();
        Color clr = _lifeModel.isLevend(rij,kolom) ?  Color.YELLOW:Color.darkGray;
        btn.setBackground(clr);
        btn.addActionListener(new CelController(_lifeModel,rij,kolom));
        return btn;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null){
            CelPosition pos = (CelPosition)arg;
        }
        refresh();
    }
}
