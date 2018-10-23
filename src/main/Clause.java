package main;

public class Clause {
    Litteral[] litterals;
    public Clause(Litteral[] lit)
    {
        this.litterals=lit;
    }

    /**
     * Une clause est vraie si au moins un litteral est vrai
     * On renvoie donc true si la clause est fausse pour le modele donne
     * @param m le modele
     * @return true si la clause est fausse, false autrement
     */
    public boolean isFalse(Model m){
        for(Litteral l : litterals){
            if(l.neg){ //si le litteral a le symbole negation...
                if(!m.getValue(l.var)) return false; //...il est true si sa valeur dans le modele est false, d'ou inversion via !
            }
            else if(m.getValue(l.var)) return false; //autrement pas d'inversion necessaire
        }

        //si on n'a trouve aucun litteral vrai
        return true;
    }
}
