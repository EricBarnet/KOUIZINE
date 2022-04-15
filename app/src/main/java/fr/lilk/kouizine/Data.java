package fr.lilk.kouizine;

public class Data {

    public String title;
    public int duree;
    public String image;

    public String getTitle() {
        return title;
    }

    public int getDuree() {
        return duree;
    }

    public String getImage() {
        return image;
    }

    public Data(String title, int duree, String image){
        this.title = title;
        this.duree = duree;
        this.image = image;
    }

    public Data(){

    }

}
