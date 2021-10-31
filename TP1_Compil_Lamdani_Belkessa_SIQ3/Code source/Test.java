import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Choisir le langage : 'L1' ou 'L3");
        String langage = sc.nextLine();


        System.out.println("Entrez les mots à vérifier dans ce langage");
        List<String> mots = new ArrayList<>();

        String ligne  = sc.nextLine();
        StringTokenizer t = new StringTokenizer(ligne);

        while(t.hasMoreTokens()){
            mots.add(t.nextToken());
        }


        for(int i=0; i<mots.size(); i++){
            if(langage.equalsIgnoreCase("L1")) {
                System.out.println(mots.get(i)+" : "+AFD_L1.valide(mots.get(i)));
            }
            if(langage.equalsIgnoreCase("L3")){
                System.out.println(mots.get(i)+" : "+AFD_L3.valide(mots.get(i)));
            }
        }

    }
}
