package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.*;
import java.util.*;
import java.io.File;

public class CNFParser {
    public static Formula parse(String nom) {
        BufferedReader reader = null;
        int nbr_var=0;
        int nbr_clause=0;
        Formula f=new Formula(null,0,0);

        try {
            File file = new File(nom);
            reader = new BufferedReader(new FileReader(file));
            String line;
            line=reader.readLine();
            String[] res= line.split("(?!^)");
            int cmp=0;
            String s="";
            for(int i=6;i<res.length+1;i++)
            {//System.out.println("= "+res[i]);
                if(i==res.length)
                {
                    int nbr = Integer.parseInt(s);
                    nbr_clause=nbr;
                }
                else
                {
                    if(!Character.isWhitespace(res[i].charAt(0)))
                    {
                        s=s+res[i];
                    }
                    else
                    {
                        int nbr = Integer.parseInt(s);
                        nbr_var=nbr;
                        s="";
                    }
                }
            }
            ArrayList <ArrayList<Integer>> list=new ArrayList <ArrayList<Integer>>();
            while ((line = reader.readLine()) != null && cmp<nbr_clause) {
                ArrayList<Integer> l=new ArrayList<Integer>();
                String[] result = line.split("(?!^)");
                s="";
                cmp++;

                for(int i=0;i<result.length;i++)
                {

                    if(!Character.isWhitespace(result[i].charAt(0)) )
                    {
                        s=s+result[i];
                    }
                    else
                    {

                        int nbr = Integer.parseInt(s);
                        if(nbr!=0)
                            l.add(nbr);
                        s="";
                    }

                }


                list.add(l);
            }
            ArrayList<Clause> clause=new ArrayList<Clause>();
            for(int i=0;i<list.size();i++)
            { ArrayList<Integer> l=list.get(i);
            Clause c=new Clause(l);
            clause.add(c);
            }
           f = new Formula(clause,nbr_var,nbr_clause);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return f;
    }
}
