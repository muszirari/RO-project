package sample.Algorithmes;

/**
 * Created by INGENIUM on 1/1/2018.
 */
public class Floyd {

    Graphe graphe;
    MatricePonderation matrice;
    int[][] Path;

    public Floyd(Graphe graphe){

        this.graphe = graphe;
        MatricePonderation matrice = new MatricePonderation(graphe);
        this.Path = new int[graphe.nbSommet][graphe.nbSommet];

        for (int i=0;i<graphe.nbSommet;i++){
            for (int j=0;j<graphe.nbSommet;j++){
                if (matrice.matrice[i][j]=="0"){
                    matrice.matrice[i][j]="9999";
                }
            }
        }

        for (int k=0;k<graphe.nbSommet;k++){
            for (int i=0;i<graphe.nbSommet;i++){
                for (int j=0;j<graphe.nbSommet;j++){

                    if (Integer.getInteger(matrice.matrice[i][k]) + Integer.getInteger(matrice.matrice[k][j]) < Integer.getInteger(matrice.matrice[i][j])){
                        matrice.matrice[i][j] = matrice.matrice[i][k] + matrice.matrice[k][j];
                        this.Path[i][j] = k;
                    }
                }
            }
        }
    }

    public void path(int q, int r)
    {
        path (q, this.Path[q][r]);
        System.out.println("v" + this.Path[q][r]);
        path (this.Path[q][r], r);
    }
}
