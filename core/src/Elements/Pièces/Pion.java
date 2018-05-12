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

        if (super.e==Equipe.Blanc) {

            if (y+1<8)
            if(p.getCase(x,y+1)==null)
            super.addMove(x, y + 1, deplacements);

            if (y == 1) {

                super.addMove(x, y + 2, deplacements);
            }

            if ((x + 1 < 8)&&(y+1<8) ){
                if (super.p.cases[x + 1][y + 1] != null) {
                    if (super.p.cases[x + 1][y + 1].e != this.e) super.addMove(x + 1, y + 1, deplacements);
                }
            }

            if ((x - 1 > 0)&&(y+1<8) ) {
                if (super.p.cases[x - 1][y + 1] != null) {
                    if (super.p.cases[x - 1][y + 1].e != this.e) super.addMove(x - 1, y + 1, deplacements);
                }
            }

        }else{

            if (y-1>0)
            if(p.getCase(x,y-1)==null)
            super.addMove(x, y - 1, deplacements);

            if (y == 6) {

                super.addMove(x, y - 2, deplacements);
            }

            if ((x + 1 < 8)&&(y-1)>0) {
                if (super.p.cases[x + 1][y - 1] != null) {
                    if (super.p.cases[x + 1][y - 1].e != this.e) super.addMove(x + 1, y - 1, deplacements);
                }
            }

            if ((x - 1 > 0)&&(y-1)>0) {
                if (super.p.cases[x - 1][y - 1] != null) {
                    if (super.p.cases[x - 1][y - 1].e != this.e) super.addMove(x - 1, y - 1, deplacements);
                }
            }

        }

        return deplacements;
    }


}
