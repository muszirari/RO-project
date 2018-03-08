package sample.Algorithmes;

/**
 * Created by INGENIUM on 12/31/2017.
 */
public class MatriceIncidence {

    Graphe graphe;
    String[][] matrice;

    public MatriceIncidence(Graphe graphe){

        this.graphe = graphe;
        this.matrice = new String[graphe.nbSommet+1][graphe.nbSommet+1];

        //remplir la line des arcs
        for (int i=1;i<=this.graphe.nbSommet;i++){
            this.matrice[0][i] = String.valueOf(i);
        }

        //remplir la colone des sommets
        int n = 1;
        for (String sommet:graphe.sommets){
            this.matrice[n][0] = sommet;
            n++;
        }

        //remplir les valeurs par default
        for (int i=1;i<=this.graphe.nbSommet;i++){
            for (int j=1;j<=this.graphe.nbSommet;j++){
                this.matrice[i][j] = "0";
            }
        }

        //remplir la matrice
        n=1;
        if (graphe.orientee){
            for (Edge arc:graphe.arcs) {
                for (int i=1;i<=graphe.nbSommet;i++){
                    if(arc.debut == this.matrice[i][0]){
                        this.matrice[i][n] = "1";
                    }else if (arc.fin == this.matrice[i][0]){
                        this.matrice[i][n] = "-1";
                    }
                }
                n++;
            }
        }else {
            for (Edge arc:graphe.arcs) {
                for (int i=1;i<=graphe.nbSommet;i++){
                    if(arc.debut == this.matrice[i][0]){
                        this.matrice[i][n] = "1";
                    }
                }
                n++;
            }
        }

    }

    public void afficherMatrice(){
        for (int i=0;i<=this.graphe.nbSommet;i++){
            for (int j=0;j<=this.graphe.nbSommet;j++){
                System.out.print(this.matrice[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
