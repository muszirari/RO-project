package sample.Algorithmes;

import java.lang.reflect.Array;

/**
 * Created by INGENIUM on 12/21/2017.
 */
public class MatriceAdjacence {

    Graphe graphe;
    String[][] matrice;

    public MatriceAdjacence(Graphe graphe){

        this.graphe = graphe;
        this.matrice = new String[graphe.nbSommet][graphe.nbSommet];
        for (int i=0;i<this.graphe.nbSommet;i++){
            for (int j=0;j<this.graphe.nbSommet;j++){
                this.matrice[i][j] = "0";
            }
        }

        if (graphe.orientee){
            for (Edge arc:graphe.arcs) {
                this.matrice[graphe.sommets.indexOf(arc.debut)][graphe.sommets.indexOf(arc.fin)] = "1";
            }
        }else {
            for (Edge arc:graphe.arcs) {
                this.matrice[graphe.sommets.indexOf(arc.debut)][graphe.sommets.indexOf(arc.fin)] = "1";
                this.matrice[graphe.sommets.indexOf(arc.fin)][graphe.sommets.indexOf(arc.debut)] = "1";
            }
        }

    }

    public void afficherMatrice(){
        for (int i=0;i<this.graphe.nbSommet;i++){
            for (int j=0;j<this.graphe.nbSommet;j++){
                System.out.print(this.matrice[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
