package sample.Algorithmes;

import java.util.ArrayList;

/**
 * Created by INGENIUM on 12/31/2017.
 */
public class Prim {

    Graphe graphe;
    ArrayList<Edge> edges = new ArrayList<>();

    public Prim(Graphe graphe){

        this.graphe = graphe;
        MatricePonderation matrice = new MatricePonderation(graphe);
        int nbEdges = 0;
        int[] visited = new int[graphe.nbSommet];
        int u = 0;
        int v = 0;
        int min = 9999;

        for (int i=0;i<graphe.nbSommet;i++){
            for (int j=0;j<graphe.nbSommet;j++){
                if (matrice.matrice[i][j]=="0"){
                    matrice.matrice[i][j]="9999";
                }
            }
        }

        visited[0] = 1;

        for (int compteur = 0;compteur < graphe.nbSommet-1;compteur++){

            min = 9999;

            for (int i=0;i<graphe.nbSommet;i++){
                if (visited[i]==1){
                    for (int j=0;j<graphe.nbSommet;j++){
                        if (visited[j]!=1){
                            if (Integer.getInteger(matrice.matrice[i][j]) < min){
                                min = Integer.getInteger(matrice.matrice[i][j]);
                                u = i;
                                v = j;
                            }
                        }
                    }
                }
            }

            visited[v]=1;
            this.edges.add(new Edge(graphe.sommets.get(u),graphe.sommets.get(v),Integer.getInteger(matrice.matrice[u][v])));

        }

    }

    public int getPoid(){
        int holder = 0;
        for (Edge arc:this.edges){
            holder+=arc.poid;
        }
        return holder;
    }
}
