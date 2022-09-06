package pl.udu.uwr.pum.mvpbasicsjava;

public class Presenter {
    private final MyView myView;

    public Presenter(MyView myView){
        this.myView = myView;
    }

    public Model getData(){
        return new Model("text", 1, 2);
    }

    public void getDetails(){
        myView.onDisplay(getData().getData());
    }
}
