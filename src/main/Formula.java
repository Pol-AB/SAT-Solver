package main;
import java.util.*;
public class Formula {
    private ArrayList<Clause> clauses;
    private int nbVar;
    private int nbClause;
    public  Formula (ArrayList<Clause> c, int n,int m)
    {
        this.clauses=c;
        this.nbVar=n;
        this.nbClause=m;
    }

    public int getNbVar() {
        return nbVar;
    }

    /**
     * Une formule CNF est vraie si toutes ses clauses sont vraies
     * On renvoie donc true si c'est le cas, false autrement
     * @param m le modele pour lequel la veracite de la CNF est evaluee
     * @return true si CNF vraie pour ce model, false sinon
     */
    public boolean isTrue(Model m){
        for(Clause c : clauses){
            if(c.isFalse(m)) return false; //si au moins une clause est fausse, la CNF est fausse
        }
        return true; //si on n'a trouve aucune clause fausse, la CNF est vraie
    }
    public void tostring()
    {
        for(int i=0;i<clauses.size();i++)
        {
            clauses.get(i).tostring();
            System.out.println();
        }
    }
}
