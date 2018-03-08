package sample.Algorithmes;

/**
 * Created by INGENIUM on 12/14/2017.
 */
public class Edge {
    String debut;
    String fin;
    int poid;
    
    public Edge(String debut, String fin){
        this.debut = debut;
        this.fin = fin;
    }
    
    public Edge(String debut, String fin, int poid){
        this.debut = debut;
        this.fin = fin;
        this.poid = poid;
    }
    
    public Edge(){}
}
