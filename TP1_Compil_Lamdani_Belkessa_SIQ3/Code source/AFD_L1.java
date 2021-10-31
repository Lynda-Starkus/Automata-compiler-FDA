
public class AFD_L1 {
    //Implémentation de l'automate fini déterministe qui vérifie si un mot appartient au langege L1
    //L1 est constité des mots de nombre pair de 0 et impair de 1

    //Les états de l'automate :
    // ZPUP : nombre de 0 pair, nombre de 1 pair
    // ZPUI : nombre de 0 pair, nombre de 1 impair
    // ZIUP : nombre de 0 impair, nombre de 1 pair
    // ZIUI : nombre de 0 impair, nombre de 1 impair

    private enum States{
        ZPUP(false), ZPUI(true), ZIUP(false), ZIUI(false);

        //Table de transition
        static {
            ZPUP.zero = ZIUP; ZPUP.un = ZPUI;
            ZPUI.zero = ZIUI; ZPUI.un = ZPUP;
            ZIUI.zero = ZPUI; ZIUI.un = ZIUP;
            ZIUP.zero = ZPUP; ZIUP.un = ZIUI;
        }

        States zero;
        States un;


        final boolean valide;

        //Constructeur de States. chaque état peut etre final ou pas.
        States(boolean valide) {
            this.valide = valide;
        }


        States transition(char c){
            switch(c){
                case '0':
                    return this.zero;
                case '1':
                    return this.un;
                default:
                    throw new RuntimeException("La chaine contient un caractère qui n'appartient pas à l'alphabet {0,1}");
            }
        }
    }

    public static boolean valide(String string){
        States state = States.ZPUP;

        for(int i=0; i<string.length(); i++){
            state = state.transition(string.charAt(i));
        }
        return state.valide;
    }


}



