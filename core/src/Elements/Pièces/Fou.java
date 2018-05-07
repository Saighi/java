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
        boolean obstacle1=false;
        boolean obstacle2=false;
        boolean obstacle3=false;
        boolean obstacle4=false;

        do {


            if (((x + h) < 8) && ((y + h) < 8) && !obstacle1)    super.addMove(x + h, y + h, deplacements);

            if (((x + h) < 8) && ((y - h) > 0)&& !obstacle2)    super.addMove(x + h, y - h, deplacements);

            if (((x - h) > 0) && ((y + h) < 8)&& !obstacle3)    super.addMove(x - h, y + h, deplacements);

            if (((x - h) > 0) && ((y - h) > 0) && !obstacle4)    super.addMove(x - h, y - h, deplacements);

            if (x+h<8 && y+h<8)if (super.p.cases[x+h][y+h] != null)obstacle1=true;
            if (x+h<8 && y-h>8)if (super.p.cases[x+h][y-h] != null)obstacle2=true;
            if (x-h>8 && y+h<8)if (super.p.cases[x-h][y+h] != null)obstacle3=true;
            if (x-h>8 && y-h>8)if (super.p.cases[x-h][y-h] != null)obstacle4=true;

            h++;

        }while((x + h) < 8 || (y + h) < 8 || (x - h) > 0 || (y - h) > 0);

        return deplacements;
    }


}
