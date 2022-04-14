package fr.lilk.kouizine;

public class Recette {

    public String recetteNom, recetteDuree , Exemple;

    public String getRecetteNom() {
        return recetteNom;
    }

    public String getRecetteDuree() {
        return recetteDuree;
    }

    public String getExemple() {
        return Exemple;
    }

    public Recette(String recetteNom, String recetteDuree, String Exemple){
        this.recetteNom = recetteNom;
        this.recetteDuree = recetteDuree;
        this.Exemple = Exemple;
    }

}
