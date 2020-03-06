public class Etat implements Comparable {
    private String Nom;

    public Etat(String nom) {
        Nom = nom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    @Override
    public boolean equals(Object obj) {
        return this.Nom.equals(((Etat)obj).getNom());
    }
    public void afficher(){
        System.out.print(this.Nom+' ');
    }

    @Override
    public int compareTo(Object o) {
        String n = ((Etat)o).getNom();
        return this.Nom.compareTo(n);
    }
}
