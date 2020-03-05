import javax.print.attribute.standard.Destination;
import java.util.TreeSet;

public class Automate {
    private Alphabet alpha;
    private TreeSet<Etat> ensEtats;
    private Etat etatInit;
    private TreeSet<Etat> etatFin;
    private TreeSet<Instruction> instructions;

    public Automate(Alphabet alpha, TreeSet<Etat> ensEtats, Etat etatInit, TreeSet<Etat> etatFin, TreeSet<Instruction> instructions) {
        this.alpha = alpha;
        this.ensEtats = ensEtats;
        this.etatInit = etatInit;
        this.etatFin = etatFin;
        this.instructions = instructions;
    }

    public Alphabet getAlpha() {
        return alpha;
    }

    public void setAlpha(Alphabet alpha) {
        this.alpha = alpha;
    }

    public TreeSet<Etat> getEnsEtats() {
        return ensEtats;
    }

    public void setEnsEtats(TreeSet<Etat> ensEtats) {
        this.ensEtats = ensEtats;
    }

    public Etat getEtatInit() {
        return etatInit;
    }

    public void setEtatInit(Etat etatInit) {
        this.etatInit = etatInit;
    }

    public TreeSet<Etat> getEtatFin() {
        return etatFin;
    }

    public void setEtatFin(TreeSet<Etat> etatFin) {
        this.etatFin = etatFin;
    }

    public TreeSet<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(TreeSet<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void reduire (){
        for(Etat etat: this.ensEtats){
            boolean accessible =false;
            boolean coAccessible=false;
                for(Instruction inst: this.instructions){
                    if(etat.equals(this.etatInit)) {
                        accessible=true;
                        } else{
                             if((inst.getEtatf().equals(etat))&&(!inst.getEtatd().equals(etat))){ accessible=true; }
                             }
                     if(this.etatFin.contains(etat) ) coAccessible=true;
                        else{
                         for(Instruction instruction: this.instructions){
                             if(instruction.getEtatd().equals(etat)&&(!instruction.getEtatf().equals(etat))){coAccessible=true;}

                         }
                     }
                }
             if(accessible==false&&coAccessible==false){
                 this.etatFin.remove(etat);
                 this.ensEtats.remove(etat);
                 for(Instruction instruction:this.instructions){
                     if((instruction.getEtatf().equals(etat))||(instruction.getEtatd().equals(etat))){
                         System.out.println("i'm here lel");
                         this.instructions.remove(instruction);
                     }
                 }
             }
        }
    }
    public void afficher(){
        System.out.print("L'alphabet ");
        this.alpha.afficher();
        System.out.print("L'ensemble des etats");
        for(Etat etat:this.ensEtats){
            etat.afficher();}
        System.out.print("L'etat initial ");
        this.etatInit.afficher();
        System.out.print("Les etats fineaux ");
        for(Etat etat:this.etatFin){
        etat.afficher();}
        System.out.print("L'ensemble des instructions ");
        for(Instruction instruction:this.instructions){
            instruction.afficher();
        }

    }
    public Automate Miroir(){
        TreeSet<Etat> etatM =new TreeSet<Etat>();
        etatM=(TreeSet) this.ensEtats.clone();
        TreeSet<Etat>  etatFM= new TreeSet<Etat>();
        etatFM.add(this.etatInit);
        Etat etatIM =new Etat("SIm");
        TreeSet<Instruction> instructionsM=new TreeSet<Instruction>();
        instructionsM=(TreeSet)instructions.clone();
        for (Instruction inst: instructionsM){
            inst.inverser();
        }
        if(this.etatFin.size()>1){
            etatM.add(etatIM);
            for(Etat etat:this.etatFin){
                Instruction inst=new Instruction(etatIM,etat,'#');
                instructionsM.add(inst);
            }
        }else{
            etatIM=this.etatFin.first();
        }


        Automate automatem=new Automate(this.alpha,etatM,etatIM,etatFM,instructionsM);


        return automatem;
    }
}
