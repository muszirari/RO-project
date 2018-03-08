package sample.Algorithmes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by INGENIUM on 12/31/2017.
 */
public class ListeIncidence {

    Graphe graphe;
    Map<String, ArrayList<String>> liste = new HashMap<>();

    public ListeIncidence(Graphe graphe){

        this.graphe = graphe;

        if (graphe.orientee){

            for (String sommet:graphe.sommets){
                this.liste.put(sommet, new ArrayList<>());
                for (Edge arc:graphe.arcs){
                    if (arc.debut==sommet){
                        this.liste.get(sommet).add(arc.fin);
                    }
                }
            }
        }else {

            for (String sommet:graphe.sommets){
                this.liste.put(sommet, new ArrayList<>());
                for (Edge arc:graphe.arcs){
                    if (arc.debut==sommet){
                        this.liste.get(sommet).add(arc.fin);
                        this.liste.get(arc.fin).add(sommet);
                    }
                }
            }
        }
    }

    public void afficherListe(){
        for (String sommet:this.liste.keySet()){
            System.out.print(sommet);
            for (String next:this.liste.get(sommet)){
                System.out.print(" --> " + next);
            }
        }
    }
}
