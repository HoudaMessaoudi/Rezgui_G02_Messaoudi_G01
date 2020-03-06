public class Instruction implements Comparable {
    private Etat etatd;
    private Etat etatf;
    private char al;

    public Instruction(Etat etatd, Etat etatf, char al) {
        this.etatd = etatd;
        this.etatf = etatf;
        this.al = al;
    }

    public Etat getEtatd() {
        return etatd;
    }

    public void setEtatd(Etat etatd) {
        this.etatd = etatd;
    }

    public Etat getEtatf() {
        return etatf;
    }

    public void setEtatf(Etat etatf) {
        this.etatf = etatf;
    }

    public char getAl() {
        return al;
    }

    public void setAl(char al) {
        this.al = al;
    }
    public void afficher(){
        this.etatd.afficher();
        System.out.print("--"+this.al+"-->");
        this.etatf.afficher();
        System.out.print(" | ");
    }

    @Override
    public int compareTo(Object o) {
        if (this.etatd.equals(((Instruction)o).getEtatd())&&(this.etatf.equals(((Instruction)o).getEtatf())&&(this.al==((Instruction)o).getAl()))) return 0;
        else{
            return 1;
        }
    }
    public void inverser(){
        Etat etatDb=this.etatd;
        this.etatd=this.etatf;
        this.etatf=etatDb;
    }
    public boolean startsWith(Etat etat){
        if(this.etatd.equals(etat)) return true;
        else return false;
    }
    public boolean endsWith(Etat etat){
        if(this.etatf.equals(etat)) return true;
        else return false;
    }
    public boolean contains(Etat etat){
        if ((this.etatf.equals(etat))||(this.etatd.equals(etat))){ return true;}
        else return false;
    }


}
