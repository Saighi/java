package Elements.Pièces;

/**
 * Created by Louis on 07/05/2018.
 */

public enum Equipe{

    Blanc,
    Noir;

    public boolean EquipeParNombre(int i){
        if (this.equals(Equipe.Blanc)&& i==0)return true;
        if (this.equals(Equipe.Blanc)&& i==1)return false;
        if (this.equals(Equipe.Noir)&& i==0)return false;
        if (this.equals(Equipe.Noir)&& i==1)return true;

        return false;
    }

}