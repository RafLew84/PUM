package pl.udu.uwr.pum.carsyappjava.data;

public class CostDateItem extends CostListItem {
    private String date;

    public CostDateItem(String date){
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int getType() {
        return TYPE_DATE;
    }


}
