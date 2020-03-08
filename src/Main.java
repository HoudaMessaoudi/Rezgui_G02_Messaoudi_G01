import java.util.*;

public class Main {

    public static void main (String args[])
    {  /* Scanner mych9 = new Scanner(System.in);
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
                        //c=mych9.next().charAt(0);
                       /* if(alpha.contains(c)) break;
                        System.out.println("le char "+ c +"n'existe pas");
                    }/
                 Instruction instruction=new Instruction(db,fn,c);
                    instructions.add(instruction);


            }
            for(Instruction inst: instructions){
                inst.afficher();
            }*/
                TreeSet<Character> al= new TreeSet<Character>();
                al.add('a'); al.add('b'); //al.add('c');
                Alphabet alph = new Alphabet(al);
                Etat s0= new Etat("s0");
                Etat s1= new Etat("s1");
                Etat s2= new Etat("s2");
                Etat s3= new Etat("s3");
                Etat s4= new Etat("s4");
                Etat s5= new Etat("s5");
                TreeSet<Etat> etats= new TreeSet<>();
                etats.add(s0); etats.add(s1); etats.add(s2);/* etats.add(s3);etats.add(s4);etats.add(s5);*/
                TreeSet<Etat> etatf= new TreeSet<Etat>();
                etatf.add(s2); //etatf.add(s4);
                TreeSet<Instruction> ins= new TreeSet<Instruction>();
                Instruction in1= new Instruction(s0, s0 ,'a');
                Instruction in2= new Instruction(s0, s1 ,'b');
                Instruction in3= new Instruction(s1, s2 ,'a');
               // Instruction in4= new Instruction(s2, s2 ,'a');
                //Instruction in7= new Instruction(s2, s1 ,'a');
               // Instruction in6= new Instruction(s2, s2 ,'a');
                Instruction in5= new Instruction(s1, s0 ,'b');
                /*Instruction in8= new Instruction(s2, s1 ,'a');
                Instruction in9= new Instruction(s1, s0 ,'c');
                Instruction in10= new Instruction(s4, s0 ,'a');
                Instruction in11= new Instruction(s4, s4 ,'b');*/
                ins.add(in1); ins.add(in2); ins.add(in3); /*ins.add(in4);*/ ins.add(in5); //ins.add(in6); ins.add(in7);// ins.add(in8); ins.add(in9); ins.add(in10); ins.add(in11);
                Automate automata = new Automate(alph,etats,s0,etatf,ins);
                automata.afficher();
                //System.out.println(automata.isDeterministe());
               // automata.reduction_accessible();
               // automata.reduction_coaccessible();

                //System.out.println("complet: "+automata.isComplet());
                //automata.complement();
                //automata.afficher();
                System.out.println(automata.reconnaissance("aabbaaabbba"));




    }
}
