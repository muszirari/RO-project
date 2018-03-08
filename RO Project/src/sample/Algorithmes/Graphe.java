package sample.Algorithmes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by INGENIUM on 12/14/2017.
 */
public class Graphe {

    ArrayList<String> sommets = new ArrayList<>();
    ArrayList<Edge> arcs = new ArrayList<>();
    ArrayList<Integer> adj[];
    int nbSommet;
    int nbArc;
    boolean orientee;
    boolean avecPoid;

    public Graphe(boolean orientee, boolean avecPoid){

        this.avecPoid = avecPoid;
        this.orientee = orientee;
        //Pour indiquer le nombre des arcs et des sommets
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserer le nombre des sommets");
        this.nbSommet = scanner.nextInt();
        System.out.println("Inserer le nombre des arcs");
        this.nbArc = scanner.nextInt();
        this.adj = new ArrayList[nbSommet];
        //Pour inserer les sommets
        CreeSommets();

        //Pour inserer les arcs
        if (avecPoid){
            CreeGraphAvecPoid();
        }else {
            CreeGraphSansPoid();
        }


    }

    public void CreeSommets(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Creation des sommets");
        for (int i=0;i<this.nbSommet;i++){
            System.out.println("Donner le nom du sommet numero " + (i+1));
            String holder = scanner.next();
            this.sommets.add(holder);
        }

    }

    public void CreeGraphAvecPoid(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Creation des arcs");
        for (int i=0;i<this.nbSommet;i++){
            ajouterArcAvecPoid();
        }
    }

    public void CreeGraphSansPoid(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Creation des arcs");
        for (int i=0;i<this.nbSommet;i++){
            ajouterArcSansPoid();
        }
    }

    public void ajouterArcAvecPoid(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("donner le debut et la fin et le poid");
        String debut = scanner.next();
        String fin = scanner.next();
        int poid = scanner.nextInt();
        Edge arc = new Edge(debut, fin, poid);
        if (!this.orientee){
            this.adj[this.sommets.indexOf(debut)].add(this.sommets.indexOf(fin));
            this.adj[this.sommets.indexOf(fin)].add(this.sommets.indexOf(debut));
        }

        this.arcs.add(arc);
    }

    public void ajouterArcSansPoid(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("donner le debut et la fin");
        String debut = scanner.next();
        String fin = scanner.next();
        Edge arc = new Edge(debut, fin);
        if (!this.orientee){
            this.adj[this.sommets.indexOf(debut)].add(this.sommets.indexOf(fin));
            this.adj[this.sommets.indexOf(fin)].add(this.sommets.indexOf(debut));
        }
        this.arcs.add(arc);
    }

    Boolean DFS(int current, int req_cyc_length, int cur_path_length, Boolean visited[], int parent)
    {
        // The current node is marked as visited
        visited[current] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> neighbor = adj[current].iterator();
        while (neighbor.hasNext())
        {
            int next_neighbor = neighbor.next();

            //Explored unexplored adjacent nodes
            if (!visited[next_neighbor]){
                if (DFS(next_neighbor, req_cyc_length, cur_path_length+1 , visited, current))
                    return true;
            }

            // Detects a cycle of a given length
            else if (next_neighbor != parent && cur_path_length==req_cyc_length){
                return true;
            }
        }
        return false;
    }

    Boolean detectCycle(int n)
    {
        if(n<3)
            return false;

        // Mark all the vertices as not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[this.nbSommet];
        for (int i = 0; i < this.nbSommet; i++)
            visited[i] = false;

        // Call the recursive helper function to detect cycle in
        // different DFS trees

        for (int i = 0; i < this.nbSommet; i++)
            if (!visited[i]) // Don't recur for u if already visited
                if (DFS(i, n, 1, visited, -1))
                    return true;

        return false;
    }

}
