package pl.udu.uwr.pum.mvcbasicsjava;

import android.widget.TextView;

public class MyView {
    private final TextView textView;
    private final Model model;

    public MyView(TextView textView, Model model) {
        this.textView = textView;
        this.model = model;
    }

    public void display(){
        textView.setText(model.getData());
    }
}
