package main;

import java.util.ArrayList;

public class Model {
    //private Hashtable<String, Integer> modele; //string = le litteral ; Integer = 1 (true) ou 0 (false)
    private ArrayList<Integer> modele; //l'index dans la liste identifie le litteral ; Integer = 1 (true) ou 0 (false)


    public Model(ArrayList<Integer> modele){
        this.modele=modele;
    }

    /*
     * Renvoie la valeur true ou false du litteral key dans le modele
     * @param key le cacatere representant le litteral
     * @return la valeur du liiteral dans le modele
     */
    /*
    public boolean getValue(String key){
        return modele.get(key)==1;
    }
    */

    /**
     * Renvoie la valeur true ou false du litteral identifie par var dans le modele
     * @param var l'indice du litteral dans la liste contenant les valeurs du modele; i.e son numero d'ordre d'apparition dans la CNF
     * @return la valeur du litteral dans le modele
     */
    public boolean getValue(int var){
        return modele.get(var)==1;
    }

    public String toString(){
        String s="[";
        for(int i:modele)
        {
            s+=i+" ";
        }
        s+="]";
        return s;
    }

    /**
     * Renvoie la liste de tous les modeles de varNum variables
     * @param varNum nombre de variables des modeles a generer
     * @return la liste des modeles crees
     */
    public static ArrayList<Model> generateAllModels(int varNum){
        ArrayList<Model> ret = new ArrayList<>();

        for(Integer j = 0; j < (Math.pow(2, varNum)) ; j++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < varNum ; i++){
                temp.add(i,0);
            }
            String model = Integer.toBinaryString(j);

            while(model.length() < varNum){
                model = "0" + model;
            }

            for(int k = 0 ; k < model.length() ; k++){
                temp.set(k, Character.getNumericValue(model.charAt(k)));
            }
            ret.add(new Model(temp));
        }
        return ret;
    }
}
