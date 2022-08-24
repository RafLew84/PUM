package pl.udu.uwr.pum.galleryappjava.model;

public class PictureModel {
    private int id = 0;
    private final String title;
    private final String image;

    public PictureModel(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public PictureModel(int id, String title, String image){
        this(title, image);
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
