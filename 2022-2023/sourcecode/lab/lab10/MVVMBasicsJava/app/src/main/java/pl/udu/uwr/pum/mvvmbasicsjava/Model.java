package pl.udu.uwr.pum.mvvmbasicsjava;

public class Model {
    private final String text;
    private final int score;
    private final int ratio;

    public Model(String text, int score, int ratio) {
        this.text = text;
        this.score = score;
        this.ratio = ratio;
    }

    public String getData(){
        return text + " " + score + " " + ratio;
    }
}