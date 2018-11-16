package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String s="/home/nazim/testsat/instances_test/instances_50_300/inst_50_300_08.cnf";
        Formula cnf = CNFParser.parse(s); //chemin du fichier ?
cnf.tostring();
        /*ArrayList<Model> modeles = Model.generateAllModels(cnf.getNbVar());

        boolean solvable = false;

        for(Model m : modeles){
            if(cnf.isTrue(m)){
                solvable=true;
                System.out.println("La CNF est solvable"); //CNF.toString ?
                System.out.println("Un modele trouvé est :");
                System.out.println(m);
                break;
            }
        }

        System.out.println("La CNF n'est pas solvable"); //CNF.toString ?
        */

        System.out.println(4);
        ArrayList<Model> oui = Model.generateAllModels(5);
        int i=0;
        /*for(Model ah : oui){
            System.out.println(ah);
            i++;
        }*/
    }
}
