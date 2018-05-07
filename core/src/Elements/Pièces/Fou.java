package Elements.Pièces;

import java.util.ArrayList;

import Elements.Plateau;

public class Fou extends Piece{


    public Fou(Equipe e, int x, int y , Plateau p) {
        super(e, x,y,p);
    }

    @Override
    public ArrayList<int[]> deplacements_Possibles() {
        ArrayList<int[]> deplacements= new ArrayList<int[]>();

        int h = 0;

        do {

            if (((x + h) < 8) && ((y + h) < 8))    super.addMove(x + h, y + h, deplacements);
            if (((x + h) < 8) && ((y - h) > 0))    super.addMove(x + h, y - h, deplacements);
            if (((x - h) > 0) && ((y + h) < 8))    super.addMove(x - h, y + h, deplacements);
            if (((x - h) > 0) && ((y - h) > 0))    super.addMove(x - h, y - h, deplacements);

        }while((x + h) < 8 || (y + h) < 8 || (x - h) > 0 || (y - h) > 0);

        return deplacements;
    }


}
