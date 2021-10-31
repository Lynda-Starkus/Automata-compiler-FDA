
public class AFD_L3 {
        //Implémentation de l'automate fini déterministe qui vérifie si un mot appartient au langege L3
        //L1 est constitué des mots qui ne comportent pas la sous-chaine 001

        //Les états de l'automate :
        // E0 boucle autant de fois à la lecture d'un '1'
        // E0 passe à E1 à la lecture d'un '0'
        // E1 passe à E2 à la lecture d'un '0'
        // E1 passe à E0 à la lecture d'un '1'
        // E2 boucle autant de fois à la lecture d'un '0'

        private enum States{
            E0(true), E1(true), E2(true), E3(false);

            //Table de transition
            static {
                E0.zero = E1; E0.un = E0;
                E1.zero = E2; E1.un = E0;
                E2.zero = E2; E2.un = E3;
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
            States state = States.E0;

            for(int i=0; i<string.length(); i++){
                try {
                state = state.transition(string.charAt(i));}
                catch (NullPointerException ex){
                    return false;
                }
            }
            return state.valide;
        }


}
