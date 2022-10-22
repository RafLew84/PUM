package pl.udu.uwr.pum.offlinecachingbasicsjava.data.response;

public class Employment {
    private String title;
    private String key_skill;

    public Employment(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
