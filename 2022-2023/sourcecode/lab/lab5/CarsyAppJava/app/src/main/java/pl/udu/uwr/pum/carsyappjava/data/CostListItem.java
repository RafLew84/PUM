package pl.udu.uwr.pum.carsyappjava.data;

public abstract class CostListItem {
    public static final int TYPE_DATE = 0;
    public static final int TYPE_GENERAL = 1;

    abstract public int getType();
}
