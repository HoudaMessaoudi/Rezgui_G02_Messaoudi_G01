import java.util.*;

public class Main {

    public static void main (String args[])
    {   Scanner mych9 = new Scanner(System.in);
        System.out.println("Veuillez introduire le nombre de characteres dans votre alphabet: ");
        int car_alphabet= mych9.nextInt();
        TreeSet<Character> alpha = new TreeSet<Character>();
        for(int i=0; i<car_alphabet; i++){
            char ch =mych9.next().charAt(0);
            alpha.add(ch);
        }
        Alphabet al = new Alphabet(alpha);
        System.out.println("Veuillez introduire le nombre des etats: ");
        int nbEtat=mych9.nextInt();
        TreeSet<Etat>  etats=new TreeSet<Etat> ();
        for(int i=0;i<nbEtat;i++){
            String nom=mych9.next();
            etats.add(new Etat(nom));

        }
        System.out.print("L'ensemble des etats est: ");
        for(Etat e: etats){
            e.afficher();
        }
        System.out.println("Veuillez Selectionner  l'etat initiale: ");

        String EI=mych9.next();
        Etat etatInit=new Etat(EI);

        System.out.println("Veuillez introduire le nombre des etats fineaux: ");
        TreeSet<Etat> EF= new TreeSet<Etat>();
        int nbF=mych9.nextInt();
        for(int i=0;i<nbF;i++){

            Etat etatf=new Etat("");


                while (true){

                    String f=mych9.next();
                     etatf.setNom(f);
                    if (etats.contains(etatf)) break;
                    System.out.println("l'etat "+ f +"n'existe pas");
                }

            EF.add(etatf);
        }
        for(Etat etat : EF) {
            etat.afficher();
        }
        System.out.println("Veuillez Introduire le nombre des instruction");
            int nbInstruction= mych9.nextInt();
            TreeSet<Instruction> instructions=new TreeSet<Instruction>();
            for(int i=0;i<nbInstruction;i++){
                System.out.println("**************"+(i+1)+"*************");
                System.out.println("Veuillez Selectionner l'etat Debut: ");
                Etat db=new Etat("");
                while (true){
                    String f=mych9.next();
                    db.setNom(f);
                    if (etats.contains(db)) break;
                    System.out.println("l'etat "+ f +"n'existe pas");
                }
                System.out.println("Veuillez Selectionner l'etat fin: ");
                Etat fn=new Etat("");
                while (true){
                    String f=mych9.next();
                    fn.setNom(f);
                    if (etats.contains(fn)) break;
                    System.out.println("l'etat "+ f +"n'existe pas");
                }
                System.out.println("Veuillez entrer un character de l'alphabet  ");
                char c;
                    /*while(true){*/
                        c=mych9.next().charAt(0);
                       /* if(alpha.contains(c)) break;
                        System.out.println("le char "+ c +"n'existe pas");
                    }*/
                 Instruction instruction=new Instruction(db,fn,c);
                    instructions.add(instruction);


            }
            for(Instruction inst: instructions){
                inst.afficher();
            }
                Automate automata = new Automate(al,etats,etatInit,EF,instructions);
                Automate auto=automata.Miroir();
                auto.afficher();






    }
}
