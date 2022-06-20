package pl.edu.uwr.pum.quickyogaappjava;

public class YogaPose {
    private final int id;
    private final String name;
    private final int image;
    private boolean isCompleted = false;
    private boolean isSelected = false;

    public YogaPose(int id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
