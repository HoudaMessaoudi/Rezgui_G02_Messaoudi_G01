import com.sun.source.util.Trees;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main (String args[])
    {
       Automate  automate= new Automate();
        boolean out=false;
        while(!out){

            String menu ="*************************Menu*************************\n1- Creation Automate\n2- Réduction de l'Automate \n3- Transformer l'automate simple non déterministe en automate simple déterministe\n4- Complement de l'automate\n5- Automate miroir\n6- Reconnaissance D'un mot dans l'automate\n7- Quitter";
            System.out.println(menu);
            System.out.print("Choisissez l'opération que vous voulez faire: ");
            Scanner sc= new Scanner(System.in);
            int in=sc.nextInt();


            switch(in){
                case(1):
                    System.out.println("\"*************************Creation Automate*************************");
                    automate=creationAutomate();
                    automate.afficher();
                    out=false;
                    break;
                case(3):
                    System.out.println("\"*************************Transformation en automate déterministe*************************");
                    automate.deterministe();
                    automate.afficher();
                    out=false;
                    break;
                case(2):
                    System.out.println("\"*************************Réduction de l'Automate*************************");
                    automate.reduction();
                    automate.afficher();
                    out=false;
                    break;
                case(4):
                    System.out.println("\"*************************Complement de l'automate*************************");
                    automate.complement();
                    automate.afficher();
                    out=false;
                    break;
                case(5):
                    System.out.println("\"*************************Automate miroir*************************");
                    automate=automate.Miroir();
                    automate.afficher();
                    out=false;
                    break;
                case(6):
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
                case(7):
                default:

                    out=true;

            }
        }
      /*Automate a= creerauto();
      a.reduction();
      a.afficher();
      Automate b= a.deterministe();
      b.afficher();*/
    }

    public static Automate creationAutomate(){
         Scanner mych9 = new Scanner(System.in);
        System.out.println("Veuillez introduire le nombre de charactères dans votre alphabet: ");
        int car_alphabet= mych9.nextInt();
        TreeSet<Character> alpha = new TreeSet<Character>();
        for(int i=0; i<car_alphabet; i++){
            System.out.println("Introduire le charactère numéro "+(i+1)+" de l'alphabet : ");
            char ch =mych9.next().charAt(0);
            alpha.add(ch);
        }
        Alphabet al = new Alphabet(alpha);
        System.out.println("Veuillez introduire le nombre des etats: ");
        int nbEtat=mych9.nextInt();
        TreeSet<Etat>  etats=new TreeSet<Etat> ();
        for(int i=0;i<nbEtat;i++){
            System.out.println("Donner le nom du état numéro "+(i+1)+": ");
            String nom=mych9.next();
            etats.add(new Etat(nom));

        }
        System.out.print("\nL'ensemble des etats est: ");
        for(Etat e: etats){
            e.afficher();
        }
        System.out.println("Veuillez Selectionner l'etat initial: ");

        Etat etatInit= new Etat("");

        while (true){
            String f=mych9.next();
            etatInit.setNom(f);
            if (etats.contains(etatInit)) break;
            System.out.println("l'etat "+ f +"n'existe pas! Choisissez un état éxistant: ");
        }

        System.out.println("Veuillez introduire le nombre des etats fineaux: ");
        TreeSet<Etat> EF= new TreeSet<Etat>();
        int nbF=mych9.nextInt();
        for(int i=0;i<nbF;i++){

            Etat etatf=new Etat("");


                while (true){
                    System.out.println("Entrez l'état final numéro "+(i+1)+": ");
                    String f=mych9.next();
                     etatf.setNom(f);
                    if (etats.contains(etatf)) break;
                    System.out.println("l'etat "+ f +"n'existe pas! Choisissez un état éxistant: ");
                }

            EF.add(etatf);
        }

        System.out.println("Veuillez Introduire le nombre des instruction");
            int nbInstruction= mych9.nextInt();
            TreeSet<Instruction> instructions=new TreeSet<Instruction>();
            for(int i=0;i<nbInstruction;i++){
                System.out.println("**************Instruction numéro "+(i+1)+"*************");
                System.out.println("Veuillez Selectionner l'etat Debut: ");
                Etat db=new Etat("");
                while (true){
                    String f=mych9.next();
                    db.setNom(f);
                    if (etats.contains(db)) break;
                    System.out.println("l'etat "+ f +"n'existe pas! Choisissez un état éxistant: ");
                }
                System.out.println("Veuillez entrer un charactère de l'alphabet  ");
                char c;
                while(true){
                    c=mych9.next().charAt(0);
                    if(alpha.contains(c)) break;
                    System.out.println("le charactère "+ c +" ne figure pas dans l'alphabet! Choisissez un charactère de l'alphabet: ");
                }
                System.out.println("Veuillez Selectionner l'etat fin: ");
                Etat fn=new Etat("");
                while (true){
                    String f=mych9.next();
                    fn.setNom(f);
                    if (etats.contains(fn)) break;
                    System.out.println("l'etat "+ f +"n'existe pas! Choisissez un état éxistant: ");
                }
                 Instruction instruction=new Instruction(db,fn,c);
                    instructions.add(instruction);
            }
            return new Automate(al,etats,etatInit,EF,instructions);
    }
    public static Automate creerauto(){
        TreeSet<Character>al =new TreeSet<>();
        al.add('a'); al.add('b');
        Alphabet alpha= new Alphabet(al);
        Etat s0= new Etat("s0");
        Etat s1= new Etat("s1");
        Etat s2= new Etat("s2");
        Etat s3=new Etat("s3");
        TreeSet<Etat> ens= new TreeSet<>();
        ens.add(s0);ens.add(s1);ens.add(s2);ens.add(s3);
        TreeSet<Etat> etatsf= new TreeSet<>();
        etatsf.add(s2);
        etatsf.add(s0);
        Instruction ins0= new Instruction(s0,s0,'a');
        Instruction ins1= new Instruction(s0,s1,'b');
        Instruction ins2= new Instruction(s1,s1,'b');
        Instruction ins3= new Instruction(s1,s0,'a');
        Instruction ins4= new Instruction(s1,s2,'a');
        Instruction ins5= new Instruction(s2,s3,'a');
        Instruction ins6= new Instruction(s3,s3,'a');
        Instruction ins7= new Instruction(s3,s3,'b');
        Instruction ins8= new Instruction(s2,s0,'a');
        TreeSet<Instruction> instructions= new TreeSet<>();
        instructions.add(ins0); instructions.add(ins1); instructions.add(ins2); instructions.add(ins3); instructions.add(ins4); instructions.add(ins5); instructions.add(ins6); instructions.add(ins7); instructions.add(ins8);
        return new Automate(alpha,ens, s0,etatsf,instructions) ;

    }
}
