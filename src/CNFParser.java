import tc.TC;

class CNFParser {
    public static Formula parseCNFInput() {

        int nbVar,nbClause;
        Clause[] clauses = new Clause[0];
        nbClause = 0;nbVar = 0;
        char c = 'c';
        while (c !='p') {
            c = TC.lireChar();
            if (c=='c')
                TC.lireLigne();
        }
        // c=='p'c 
        TC.lireMot();  // the line is p cnf nbVar nbClauses
        nbVar = TC.lireInt();
        nbClause = TC.lireInt();
        TC.lireLigne();
        clauses = new Clause[nbClause];
        for (int i= 0;i<nbClause;i++) {
            String line = TC.lireLigne();
            String[] varsString = TC.motsDeChaine(line);
            int[] vars = new int[varsString.length];
            for (int j=0;j<vars.length;j++)
                vars[j] = Integer.parseInt(varsString[j]);
            int nbLit = vars.length-1;  // Line ends with 0
            Litteral[] lits = new Litteral[nbLit];
            for (int j=0;j<nbLit;j++)
                lits[j] = new Litteral(Math.abs(vars[j]),vars[j]<0);
            clauses[i] = new Clause(lits);
        }


        return new Formula(clauses,nbVar);
    }

}