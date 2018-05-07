package Elements.Pièces;

import java.util.ArrayList;

import Elements.Plateau;

public class Roi extends Piece{


    public Roi(Equipe e, int x, int y , Plateau p) {
        super(e, x, y, p);
    }

    @Override
    public ArrayList<int[]> deplacements_Possibles() {
        ArrayList<int[]> deplacements= new ArrayList<int[]>();

        super.addMove(x,y+1,deplacements);
        super.addMove(x+1,y+1,deplacements);
        super.addMove(x+1,y,deplacements);
        super.addMove(x+1,y-1,deplacements);
        super.addMove(x,y-1,deplacements);
        super.addMove(x-1,y-1,deplacements);
        super.addMove(x-1,y,deplacements);
        super.addMove(x-1,y+1,deplacements);


        return deplacements;
    }


}
