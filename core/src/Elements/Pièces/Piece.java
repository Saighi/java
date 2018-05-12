package Elements.Pièces;

import java.util.ArrayList;

import Elements.Plateau;

public abstract class Piece {
    public Equipe e;
    protected boolean capturee;
    protected int x;
    protected int y;
    protected Plateau p;

    public Piece(Equipe e, int x, int y , Plateau p) {
        this.e = e;
        this.capturee = false;
        this.x = x;
        this.y = y;

        p.cases[x][y]=this;

        this.p = p;
    }

    public void addMove(int x, int y, ArrayList<int[]> moves) {

        if (p.checkCase(this, x, y)){

            moves.add(new int[]{x, y});

        }

    }

    public boolean isCapturee() {
        return capturee;
    }

    public void setCapturee(boolean capturee) {
        this.capturee = capturee;
    }

    public abstract ArrayList<int[]> deplacements_Possibles();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Equipe getE() {
        return e;
    }

}


