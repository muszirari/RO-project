package sample.Algorithmes;

/**
 * Created by INGENIUM on 12/31/2017.
 */
public class MatricePonderation {

    Graphe graphe;
    String[][] matrice;

    public MatricePonderation(Graphe graphe){

        this.graphe = graphe;
        matrice = new String[graphe.nbSommet][graphe.nbSommet];

        //remplir les arcs sans poids
        for (int i=0;i<graphe.nbSommet;i++){
            for (int j=0;j<graphe.nbSommet;j++){
                this.matrice[i][j] = "∞";
            }
        }

        //remplir le diagonale
        for (int j=0;j<graphe.nbSommet;j++){
            this.matrice[j][j] = "0";
        }

        if (graphe.orientee){
            for (Edge arc:graphe.arcs) {
                this.matrice[graphe.sommets.indexOf(arc.debut)][graphe.sommets.indexOf(arc.fin)] = String.valueOf(arc.poid);
            }
        }else {
            for (Edge arc:graphe.arcs) {
                this.matrice[graphe.sommets.indexOf(arc.debut)][graphe.sommets.indexOf(arc.fin)] = String.valueOf(arc.poid);
                this.matrice[graphe.sommets.indexOf(arc.fin)][graphe.sommets.indexOf(arc.debut)] = String.valueOf(arc.poid);
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
