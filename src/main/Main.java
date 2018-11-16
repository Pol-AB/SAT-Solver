package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String s="D:\\PROJECT\\SAT\\instances_test\\instances_30_150\\inst_30_150_06.cnf";
        Formula cnf = CNFParser.parse(s); //chemin du fichier ?

        Model m = Model.testAllModels(cnf);
        if (m == null) {
            System.out.println("La CNF n'est pas solvable");
        }
        else{
            System.out.println("La CNF est solvable"); //CNF.toString ?
            System.out.println("Un modele trouvé est :");
            System.out.println(m);
        }
    }
}