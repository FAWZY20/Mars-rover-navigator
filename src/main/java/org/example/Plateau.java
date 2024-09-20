package org.example;

public class Plateau {

    private final int[][] dimension;

    public Plateau(int lignes, int colonnes) {
        this.dimension = new int[lignes + 1][colonnes + 1];;
    }

    public void setValueIndex(int ligne, int colonne) {
        try {
            dimension[ligne][colonne] = 1;
        } catch (Exception e){
            throw new RuntimeException("Index hors limites !");
        }
    }

}
