package Elements.Pièces;

import java.util.ArrayList;

import Elements.Plateau;

public class Pion extends Piece{


    public Pion(Equipe e, int x, int y , Plateau p) {
        super(e, x, y, p);
    }

    @Override
    public ArrayList<int[]> deplacements_Possibles() {
        ArrayList<int[]> deplacements= new ArrayList<int[]>();

        super.addMove(x,y+1,deplacements);

        if (y==1){
            super.addMove(x,y+2,deplacements);

        }
        return deplacements;
    }


}
