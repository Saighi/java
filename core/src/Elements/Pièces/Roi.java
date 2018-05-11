package Elements.Pièces;

import java.util.ArrayList;

import Elements.Plateau;

public class Roi extends Piece{

    private boolean bougé =false;
    public ArrayList<ArrayList<int[]>> menaces = new ArrayList<ArrayList<int[]>>();


    public Roi(Equipe e, int x, int y , Plateau p) {
        super(e, x, y, p);
    }

    @Override
    public void deplacements_Possibles() {
        ArrayList<int[]> deplacements= new ArrayList<int[]>();

         super.addMove(x,y+1,deplacements);
         super.addMove(x+1,y+1,deplacements);
         super.addMove(x+1,y,deplacements);
         super.addMove(x+1,y-1,deplacements);
         super.addMove(x,y-1,deplacements);
         super.addMove(x-1,y-1,deplacements);
         super.addMove(x-1,y,deplacements);
         super.addMove(x-1,y+1,deplacements);

        if (super.e==Equipe.Blanc) {

            if (!this.isBougé() && p.getCase(x + 1, y) == null && p.getCase(x + 2, y) == null && p.getCase(x + 3, y) instanceof Tour && !((Tour) p.getCase(x + 3, y)).isBougé()) {
                 super.addMove(x + 2, y, deplacements);
            }
            if (!this.isBougé() && p.getCase(x -1, y) == null && p.getCase(x - 2, y) == null && p.getCase(x - 3, y) == null  && p.getCase(x - 4, y) instanceof Tour && !((Tour) p.getCase(x -4, y)).isBougé()) {
                 super.addMove(x -2, y, deplacements);
            }
        }

        if (super.e==Equipe.Noir) {

            if (!this.isBougé() && p.getCase(x + 1, y) == null && p.getCase(x + 2, y) == null && p.getCase(x + 3, y) instanceof Tour && !((Tour) p.getCase(x + 3, y)).isBougé()) {
                 super.addMove(x + 2, y, deplacements);
            }
            if (!this.isBougé() && p.getCase(x -1, y) == null && p.getCase(x - 2, y) == null && p.getCase(x - 3, y) == null  && p.getCase(x - 4, y) instanceof Tour && !((Tour) p.getCase(x -4, y)).isBougé()) {
                 super.addMove(x -2, y, deplacements);
            }
        }

        super.deplacements = deplacements;
    }

    public boolean isCounter(int x, int y){

        for (ArrayList<int[]> liste : menaces){

            for(int[] coordonnées : liste){

                if(coordonnées[0] == x && coordonnées[1] == y) return true;

            }

        }

        return false;

    }

    public boolean isBougé() {
        return bougé;
    }

    public void setBougé(boolean bougé) {
        this.bougé = bougé;
    }
}
