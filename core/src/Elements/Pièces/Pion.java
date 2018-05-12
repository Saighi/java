package Elements.Pièces;

import java.util.ArrayList;

import Elements.Plateau;

public class Pion extends Piece{





    public Pion(Equipe e, int x, int y , Plateau p) {
        super(e, x, y, p);
    }

    @Override
    public void deplacements_Possibles() {
        ArrayList<int[]> deplacements= new ArrayList<int[]>();
        boolean menacant = false;

        if (super.e==Equipe.Blanc) {

            if (y+1<8)
            if(p.getCase(x,y+1)==null)
                menacant = super.addMove(x, y + 1, deplacements);

            if (y == 1) {

                menacant = super.addMove(x, y + 2, deplacements);
            }

            if ((x + 1 < 8)&&(y+1<8) ){
                if (super.p.cases[x + 1][y + 1] != null) {
                    if (super.p.cases[x + 1][y + 1].e != this.e) menacant = super.addMove(x + 1, y + 1, deplacements);
                }
            }

            if ((x - 1 > 0)&&(y+1<8) ) {
                if (super.p.cases[x - 1][y + 1] != null) {
                    if (super.p.cases[x - 1][y + 1].e != this.e) menacant = super.addMove(x - 1, y + 1, deplacements);
                }
            }

        }else{

            if (y-1>0)
            if(p.getCase(x,y-1)==null)
                menacant = super.addMove(x, y - 1, deplacements);

            if (y == 6) {

                menacant = super.addMove(x, y - 2, deplacements);
            }

            if ((x + 1 < 8)&&(y-1)>0) {
                if (super.p.cases[x + 1][y - 1] != null) {
                    if (super.p.cases[x + 1][y - 1].e != this.e) menacant = super.addMove(x + 1, y - 1, deplacements);
                }
            }

            if ((x - 1 > 0)&&(y-1)>0) {
                if (super.p.cases[x - 1][y - 1] != null) {
                    if (super.p.cases[x - 1][y - 1].e != this.e) menacant = super.addMove(x - 1, y - 1, deplacements);
                }
            }

        }

        if(menacant) p.getEking(this).menaces.add(deplacements);

        super.deplacements = deplacements;
    }


}
