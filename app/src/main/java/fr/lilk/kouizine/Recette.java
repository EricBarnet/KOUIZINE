package fr.lilk.kouizine;

public class Recette {

    public String recetteNom;
    public int recetteDuree;

    public String getRecetteNom() {
        return recetteNom;
    }

    public int getRecetteDuree() {
        return recetteDuree;
    }

    public Recette(String recetteNom, int recetteDuree){
        this.recetteNom = recetteNom;
        this.recetteDuree = recetteDuree;
    }

    public Recette(){

    }

}
