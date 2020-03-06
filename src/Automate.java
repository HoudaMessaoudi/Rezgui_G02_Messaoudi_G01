import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.TreeSet;

public class Automate {
    private Alphabet alpha;
    private TreeSet<Etat> ens;
    private Etat etatInit;
    private TreeSet<Etat> etatFin;
    private TreeSet<Instruction> instructions;

    public Automate(Alphabet alpha, TreeSet<Etat> ens, Etat etatInit, TreeSet<Etat> etatFin, TreeSet<Instruction> instructions) {
        this.alpha = alpha;
        this.ens = ens;
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

    public TreeSet<Etat> getEns() {
        return ens;
    }

    public void setEns(TreeSet<Etat> ens) {
        this.ens = ens;
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

    public void afficher(){
        System.out.print("L'alphabet ");
        this.alpha.afficher();
        System.out.print("\nL'ensemble des : ");
        for(Etat etat:this.ens){
            etat.afficher();}
        System.out.print("\nL'etat initial ");
        this.etatInit.afficher();
        System.out.print("\nLes  finaux ");
        for(Etat etat:this.etatFin){
        etat.afficher();}
        System.out.print("\nL'ensemble des instructions ");
        for(Instruction instruction:this.instructions){
            instruction.afficher();
        }

    }
    public Automate Miroir(){
        TreeSet<Etat> etatM =new TreeSet<Etat>();
        etatM=(TreeSet) this.ens.clone();
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
    public void reduction_accessible () {
        ArrayList<Etat> accessibles = new ArrayList<>();
        accessibles.add(this.getEtatInit());
        ArrayList<Etat> non_accessibles = new ArrayList<>();
        for ( Etat etat:this.ens){
            if (!(etat.equals(this.etatInit))) non_accessibles.add(etat);
        }
        boolean done=false;
        int i=0;
        while(!done){
            for ( Instruction ins:this.instructions){
                if(ins.startsWith(accessibles.get(i))) {
                    if (!(accessibles.contains(ins.getEtatf()))) {
                        non_accessibles.remove(ins.getEtatf());
                        accessibles.add(ins.getEtatf());
                    }
                }
            }
            i++;
            if((i+1)>accessibles.size()) {done=true;}
        }
        if(!non_accessibles.isEmpty()) {
            TreeSet<Instruction> in= new TreeSet<>();
            for ( Etat e:non_accessibles){
                this.ens.remove(e);
                this.etatFin.remove(e);
                for (Instruction ins:this.instructions){
                    if ((!(non_accessibles.contains(ins.getEtatd()))&&!(non_accessibles.contains(ins.getEtatf())))){
                        in.add(ins);
                    }
                }
                this.instructions=in;
            }
        }
    }
    public void reduction_coaccessible(){
        ArrayList<Etat> coaccessible= new ArrayList<>();
        for ( Etat e:this.etatFin){ coaccessible.add(e);}
        ArrayList<Etat> non_coaccessible= new ArrayList<>();
        for (Etat e: this.ens){if(!(coaccessible.contains(e))){non_coaccessible.add(e);}}
        boolean done=false;
        int i=0;
        while(!done){
            for ( Instruction ins:this.instructions){
                if(ins.endsWith(coaccessible.get(i))) {
                    if (!(coaccessible.contains(ins.getEtatd()))) {
                        non_coaccessible.remove(ins.getEtatd());
                        coaccessible.add(ins.getEtatd());
                    }
                }
            }
            i++;
            if((i+1)>coaccessible.size()) {done=true;}
        }
        if(!non_coaccessible.isEmpty()) {
            TreeSet<Instruction> in= new TreeSet<>();
            for ( Etat e:non_coaccessible){
                this.ens.remove(e);
            }
            for (Instruction ins:this.instructions){
                if ((!(non_coaccessible.contains(ins.getEtatd()))&&!(non_coaccessible.contains(ins.getEtatf())))){
                    in.add(ins);
                }
            }
            this.instructions=in;
        }


    }

}
