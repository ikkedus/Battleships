package com.company;

import java.util.Observable;
import java.util.Random;

/**
 * Created by ikkedus on 2/9/2017.
 */
public class LifeModel extends Observable{
    public int kolom = 20;
    public int rij = 30;
    private boolean[][] grid = new boolean[kolom][rij];
    private boolean[][] newGen = grid.clone();
    public LifeModel(){
        Random rnd = new Random();
        for (int i = 1; i < grid.length-1; i++) {
            boolean[] row = grid[i];
            for (int j = 1; j < row.length-1; j++) {
                grid[i][j] = rnd.nextInt(10) == 9;
            }
        }
        setChanged();
        notifyObservers();
    }
    private int telBuren(int rij,int kolom){
        int count = 0;
        for (int x = -1; x <= 1; x++)
        {
            for (int y = -1; y <= 1; y++)
            {
                if ((x == 0) && (y == 0)) continue;
                int r2 = rij + x;
                int k2 = kolom + y;
                if (grid[r2][k2])
                    count++;
            }
        }
        return count;
    }
    private boolean evolueer(int rij,int kolom){
        int buren = telBuren(rij,kolom);
        if (isLevend(rij,kolom)){
            if(buren < 2 || buren > 3) return false;
            return true;
        }
        if (buren == 3){
            return true;
        }
        return false;
    }
    public void volgendeGeneratie(){
        for (int i = 1; i < grid.length-1; i++) {
            boolean[] row = grid[i];
            for (int j = 1; j < row.length-1; j++) {
                newGen[i][j] = evolueer(i,j);
            }
        }
        grid = newGen.clone();
        setChanged();
        notifyObservers();
    }
    public boolean isLevend(int rij,int kolom){
        return grid[rij][kolom];
    }
    public void toon(){
        for (int i = 0; i < grid.length; i++) {
            boolean[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (grid[i][j]){
                    System.out.print('X');
                }else
                {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
    public int getKolom() {
        return kolom;
    }

    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    public int getRij() {
        return rij;
    }

    public void setRij(int rij) {
        this.rij = rij;
    }

    public void toggle(CelPosition pos) {
        grid[pos.rij][pos.kolum] = !grid[pos.rij][pos.kolum];
        setChanged();
        notifyObservers();
    }
}
