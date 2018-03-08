package sample.Algorithmes;

import java.util.ArrayList;

/**
 * Created by INGENIUM on 12/31/2017.
 */
public class Kruskal {

    Graphe graphe;
    ArrayList<Edge> edges = new ArrayList<>();

    public Kruskal(Graphe graphe){

        this.graphe = graphe;
        MatricePonderation matrice = new MatricePonderation(graphe);
        int nbEdges = 0;
        int[] parent = new int[graphe.nbSommet];
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

        while (nbEdges < graphe.nbSommet){

            for (int i=0;i<graphe.nbSommet;i++){
                for (int j=0;j<graphe.nbSommet;j++){
                    if (Integer.getInteger(matrice.matrice[i][j]) < min){
                        min = Integer.getInteger(matrice.matrice[i][j]);
                        u = i;
                        v = j;
                    }
                }
            }
            while (parent[u]!=0){
                u = parent[u];
            }
            while (parent[v]!=0){
                v = parent[v];
            }

            if (u!=v){
                this.edges.add(new Edge(graphe.sommets.get(u),graphe.sommets.get(v),Integer.getInteger(matrice.matrice[u][v])));
                parent[v]=u;
            }

            matrice.matrice[u][v] = matrice.matrice[u][v] = "9999";
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
