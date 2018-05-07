package Elements;

import Elements.Pièces.Equipe;
import Elements.Pièces.Piece;
import Elements.Pièces.Pion;
import Elements.Pièces.Reine;
import Elements.Pièces.Roi;
import Elements.Pièces.Tour;
import Elements.Pièces.Fou;
import Elements.Pièces.Cavalier;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Plateau {
    public Piece[][] cases;


    public Plateau() {
        cases = new Piece[8][8];

        //Blanc

        new Tour(Equipe.Blanc,0,0, this);
        new Cavalier(Equipe.Blanc,1,0, this);
        new Fou(Equipe.Blanc,2,0, this);
        new Reine(Equipe.Blanc,3,0, this);
        new Roi(Equipe.Blanc,4,0, this);
        new Fou(Equipe.Blanc,5,0, this);
        new Cavalier(Equipe.Blanc,6,0, this);
        new Tour(Equipe.Blanc,7,0, this);

        new Pion(Equipe.Blanc,0,1, this);
        new Pion(Equipe.Blanc,1,1, this);
        new Pion(Equipe.Blanc,2,1, this);
        new Pion(Equipe.Blanc,3,1, this);
        new Pion(Equipe.Blanc,4,1, this);
        new Pion(Equipe.Blanc,5,1, this);
        new Pion(Equipe.Blanc,6,1, this);
        new Pion(Equipe.Blanc,7,1, this);


        //Noir

        new Tour(Equipe.Noir,0,7, this);
        new Cavalier(Equipe.Noir,1,7, this);
        new Fou(Equipe.Noir,2,7, this);
        new Reine(Equipe.Noir,3,7, this);
        new Roi(Equipe.Noir,4,7, this);
        new Fou(Equipe.Noir,5,7, this);
        new Cavalier(Equipe.Noir,6,7, this);
        new Tour(Equipe.Noir,7,7, this);

        new Pion(Equipe.Noir,0,6, this);
        new Pion(Equipe.Noir,1,6, this);
        new Pion(Equipe.Noir,2,6, this);
        new Pion(Equipe.Noir,3,6, this);
        new Pion(Equipe.Noir,4,6, this);
        new Pion(Equipe.Noir,5,6, this);
        new Pion(Equipe.Noir,6,6, this);
        new Pion(Equipe.Noir,7,6, this);

    }

    public boolean checkCase(Piece p, int x, int y){

        if (this.cases[x][y] == null) return true;

        else if (this.cases[x][y].e == p.e ) return false;

        else if (this.cases[x][y].e != p.e ) return true;

        return false;
    }

    public Piece getCase(int x, int y) {
        return cases[x][y];
    }

    public void setCases(Piece[][] cases) {
        this.cases = cases;
    }
}
