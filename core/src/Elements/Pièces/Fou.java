package Elements.Pièces;

import java.util.ArrayList;

import Elements.Plateau;

public class Fou extends Piece{


    public Fou(Equipe e, int x, int y , Plateau p) {
        super(e, x,y,p);
    }

    @Override
    public void deplacements_Possibles() {
        ArrayList<int[]> deplacements= new ArrayList<int[]>();

        int h = 0;
        boolean obstacle5=false;
        boolean obstacle6=false;
        boolean obstacle7=false;
        boolean obstacle8=false;

        do {

            h++;

            if (((x + h) < 8) && ((y + h) < 8) && !obstacle5)     super.addMove(x + h, y + h, deplacements);

            if (((x + h) < 8) && ((y - h) > 0)&& !obstacle6)     super.addMove(x + h, y - h, deplacements);

            if (((x - h) > 0) && ((y + h) < 8)&& !obstacle7)     super.addMove(x - h, y + h, deplacements);

            if (((x - h) > 0) && ((y - h) > 0) && !obstacle8)     super.addMove(x - h, y - h, deplacements);

            if (x+h<8 && y+h<8)if (super.p.cases[x+h][y+h] != null)obstacle5=true;
            if (x+h<8 && y-h>0)if (super.p.cases[x+h][y-h] != null)obstacle6=true;
            if (x-h>0 && y+h<8)if (super.p.cases[x-h][y+h] != null)obstacle7=true;
            if (x-h>0 && y-h>0)if (super.p.cases[x-h][y-h] != null)obstacle8=true;


        }while((x + h) < 8 || (y + h) < 8 || (x - h) > 0 || (y - h) > 0);


        super.deplacements = deplacements;
    }


}
