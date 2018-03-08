package sample.Algorithmes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by INGENIUM on 12/31/2017.
 */
public class Dijkstra {

    Graphe graphe;
    String[] distance;
    Map<String, ArrayList<String>> chemins = new HashMap<>();


    public Dijkstra(Graphe graphe, String vertex){

        //pour commencer avec le sommet choisis
        graphe.sommets.remove(graphe.sommets.indexOf(vertex));
        graphe.sommets.add(0, vertex);

        //initializing
        this.graphe = graphe;
        MatricePonderation matrice = new MatricePonderation(graphe);
        int[] visited = new int[graphe.nbSommet];
        int[] preD = new int[graphe.nbSommet];
        int min;
        int nextNode = 0;

        //changer le 0 au max
        for (int i=0;i<graphe.nbSommet;i++){

            visited[i] = 0;
            preD[i] = 0;
            for (int j=0;j<graphe.nbSommet;j++){
                if (matrice.matrice[i][j]=="0"){
                    matrice.matrice[i][j]="9999";
                }
            }
        }

        //initializing distance de sommet1 au sommet1
        this.distance = matrice.matrice[0];
        this.distance[0] = "0";
        visited[0] = 1;

        //initializing sommet suivant de chaque sommet
        for (int i=0;i<graphe.nbSommet;i++){
            min = 9999;
            for (int j=0;j<graphe.nbSommet;j++){
                if (Integer.getInteger(matrice.matrice[i][j]) < min && visited[j]!=1){
                    min = Integer.getInteger(distance[j]);
                    nextNode = j;
                }
            }

            visited[nextNode] = 1;

            //Commencer l'algorithme
            for (int c = 0;c<graphe.nbSommet;c++){
                if (visited[c]!=1){
                    if (min+Integer.getInteger(matrice.matrice[nextNode][c]) < Integer.getInteger(this.distance[c])){

                        this.distance[c] = matrice.matrice[nextNode][c];
                        preD[c] = nextNode;

                    }
                }
            }
        }

        //Sauvgarder les chemins minimum
        for (int i=0;i<graphe.nbSommet;i++){

            int j;
            this.chemins.put("chemin = " + graphe.sommets.get(i) , new ArrayList<>());
            j=i;
            do {

                j = preD[j];
                this.chemins.get("chemin = " + graphe.sommets.get(i)).add(" <-- " + graphe.sommets.get(j));

            }while (j!=0);
        }

    }

    // Vérifier la positivité des pondération des arcs
    public boolean isPositivite(){
        boolean positive = true;
        for (Edge arc:this.graphe.arcs){
            if (arc.poid<0){
                positive = false;
                break;
            }
        }
        return positive;
    }

    //Afficher  le chemin afférant une distance (pour tout sommet de destination).
    public void afficherChemins(){
        int i=0;
        for (Map.Entry<String, ArrayList<String>> set:this.chemins.entrySet()){
            System.out.print(set.getKey());
            for (String part:set.getValue()){
                System.out.print(part);
            }
            System.out.println();
            System.out.println("Distance = " + this.distance[i]);
            System.out.println();
            i++;
        }
    }
}
