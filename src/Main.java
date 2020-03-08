import java.io.IOException;
import java.util.*;

public class Main {

    public static void main (String args[])
    {
        Automate  automate= new Automate();
        boolean out=false;
        while(!out){

            String menu ="*************************Menu*************************\n1- Creation Automate\n2- Réduction de l'Automate\n3- Complement de l'automate\n4- Automate miroir\n5- Reconnaissance D'un mot dans l'automate\n6- Quitter";
             System.out.println(menu);
            Scanner sc= new Scanner(System.in);
            int in=sc.nextInt();


            switch(in){
                case(1):
                    System.out.println("\"*************************Creation Automate*************************");
                    automate=creationAutomate();
                    automate.afficher();
                    out=false;
                    break;
                case(2):
                    System.out.println("\"*************************Réduction de l'Automate*************************");
                    automate.reduction();
                    automate.afficher();
                    out=false;
                    break;
                case(3):
                    System.out.println("\"*************************Complement de l'automate*************************");
                    automate.complement();
                    automate.afficher();
                    out=false;
                    break;
                case(4):
                    System.out.println("\"*************************Automate miroir*************************");
                    automate=automate.Miroir();
                    automate.afficher();
                    out=false;
                    break;
                case(5):
                    System.out.println("\"*************************Reconnaissance D'un mot dans l'automate*************************");
                    System.out.println("Veuillez entrer un mot");
                    String mot=sc.next();
                    Boolean b=automate.reconnaissance(mot);
                    if(b==true){
                        System.out.println("L'automate connait le mot "+mot);
                    }else{
                        System.out.println("L'automate ne connait pas le mot "+mot);
                    }
                    out=false;
                    break;
                case(6):
                default:

                    out=true;

            }
        }
    }

    public static Automate creationAutomate(){
         Scanner mych9 = new Scanner(System.in);
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

        Etat etatInit= new Etat("");

        while (true){
            String f=mych9.next();
            etatInit.setNom(f);
            if (etats.contains(etatInit)) break;
            System.out.println("l'etat "+ f +"n'existe pas");
        }

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
                System.out.println("Veuillez entrer un character de l'alphabet  ");
                char c;
                while(true){
                    c=mych9.next().charAt(0);
                    if(alpha.contains(c)) break;
                    System.out.println("le char "+ c +"n'existe pas");
                }
                System.out.println("Veuillez Selectionner l'etat fin: ");
                Etat fn=new Etat("");
                while (true){
                    String f=mych9.next();
                    fn.setNom(f);
                    if (etats.contains(fn)) break;
                    System.out.println("l'etat "+ f +"n'existe pas");
                }
                 Instruction instruction=new Instruction(db,fn,c);
                    instructions.add(instruction);
            }
            return new Automate(al,etats,etatInit,EF,instructions);
    }
}
