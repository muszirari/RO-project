package sample.Algorithmes;

/**
 * Created by INGENIUM on 1/10/2018.
 */
public class BellmanFord {

    Graphe graphe;
    int[] p;
    int[] d;

    public BellmanFord(Graphe graphe){
        this.graphe = graphe;
        p = new int[graphe.nbSommet];
        d = new int[graphe.nbSommet];

        for(int i=0;i< graphe.nbSommet;++i) {
            d[i] = 9999;
            p[i] = -1;
        }

        for (int i = 0; i < graphe.nbSommet - 1; ++i) {
            for (int j = 0; j < graphe.nbArc; ++j) { //here i am calculating the shortest path
                if (d[graphe.sommets.indexOf(graphe.arcs.get(j).debut)] + d[graphe.arcs.get(j).poid] < d[graphe.sommets.indexOf(graphe.arcs.get(j).fin)]) {
                    d[graphe.sommets.indexOf(graphe.arcs.get(j).fin)] = d[graphe.sommets.indexOf(graphe.arcs.get(j).debut)] + graphe.arcs.get(j).poid;
                    d[graphe.sommets.indexOf(graphe.arcs.get(j).fin)] = d[graphe.sommets.indexOf(graphe.arcs.get(j).debut)];
                }
            }
        }

        /*

        for (int i = 0; i < n; i++) {
    System.out.println("Vertex " + i " has predecessor " + p[i]);
}

         */

    }
}
