package pl.udu.uwr.pum.carsyappjava.data;

public class CostGeneralItem extends CostListItem {
    private Cost cost;

    public Cost getCost() {
        return cost;
    }

    public CostGeneralItem(Cost cost){
        this.cost = cost;
    }


    @Override
    public int getType() {
        return TYPE_GENERAL;
    }


}
