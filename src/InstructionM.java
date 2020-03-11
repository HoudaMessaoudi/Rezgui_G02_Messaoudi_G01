import java.util.TreeSet;

public class InstructionM implements Comparable{
    private TreeSet<Etat> etatdb;
    private TreeSet<Etat> etatfn;
    private char al;

    public InstructionM(TreeSet<Etat> etatdb, TreeSet<Etat> etatfn, char al) {
        this.etatdb = etatdb;
        this.etatfn = etatfn;
        this.al = al;
    }

    public TreeSet<Etat> getEtatdb() {
        return etatdb;
    }

    public void setEtatdb(TreeSet<Etat> etatdb) {
        this.etatdb = etatdb;
    }

    public TreeSet<Etat> getEtatfn() {
        return etatfn;
    }

    public void setEtatfn(TreeSet<Etat> etatfn) {
        this.etatfn = etatfn;
    }

    public char getAl() {
        return al;
    }

    public void setAl(char al) {
        this.al = al;
    }

    @Override
    public int compareTo(Object o) {
       if((this.etatdb.equals(((InstructionM)o).getEtatdb()))&&(this.etatfn.equals(((InstructionM)o).getEtatfn()))&& (this.al==((InstructionM)o).getAl())) return 0;
       else return 1;
    }
    public void afficher(){
        System.out.println("Affichage des instruction:");
        System.out.println("Les etats db:");
        for(Etat etat: this.etatdb){
            etat.afficher();
        }
        System.out.println("char: "+this.al);
        System.out.println("Les etats fn:");
        for(Etat etat: this.etatfn){
            etat.afficher();
        }
    }

}
