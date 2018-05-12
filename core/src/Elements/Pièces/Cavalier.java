package Elements.Pièces;

import java.util.ArrayList;

import Elements.Plateau;

public class Cavalier extends Piece{

    private int l = 2;
    private int s = 1;

    public Cavalier(Equipe e, int x, int y , Plateau p) {
        super(e, x,y,p);
    }

    @Override
    public void deplacements_Possibles() {
        ArrayList<int[]> deplacements= new ArrayList<int[]>();
        boolean menacant = false;

        menacant = super.addMove(x+this.l,y+this.s,deplacements);
        menacant = super.addMove(x+this.l,y-this.s,deplacements);

        menacant = super.addMove(x-this.l,y+this.s,deplacements);
        menacant = super.addMove(x-this.l,y-this.s,deplacements);

        menacant = super.addMove(x+this.s,y+this.l,deplacements);
        menacant = super.addMove(x-this.s,y+this.l,deplacements);

        menacant = super.addMove(x+this.s,y-this.l,deplacements);
        menacant = super.addMove(x-this.s,y-this.l,deplacements);

        if(menacant) p.getEking(this).menaces.add(deplacements);

        super.deplacements = deplacements;
    }


}
