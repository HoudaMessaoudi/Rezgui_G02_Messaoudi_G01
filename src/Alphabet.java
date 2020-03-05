import java.util.TreeSet;

public class Alphabet {
    private TreeSet<Character> Alpha ;

    public TreeSet<Character> getAlpha() {
        return Alpha;
    }

    public void setAlpha(TreeSet<Character> alpha) {
        Alpha = alpha;
    }

    public Alphabet(TreeSet<Character> alpha) {
        Alpha = alpha;
    }
    public void afficher()
    {

        for (char ch: this.Alpha){
            System.out.print(ch+" ");
        }
    }
}
