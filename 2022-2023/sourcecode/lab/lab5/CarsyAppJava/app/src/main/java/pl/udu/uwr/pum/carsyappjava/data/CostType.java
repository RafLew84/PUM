package pl.udu.uwr.pum.carsyappjava.data;

import pl.udu.uwr.pum.carsyappjava.R;

public enum CostType {
    REFUELING("Tankowanie", R.drawable.ic_fuel),
    SERVICE("Serwis", R.drawable.ic_car_repair),
    PARKING("Parking", R.drawable.ic_parking),
    INSURANCE("Ubezpieczenie", R.drawable.ic_general_cost),
    TICKET("Mandat", R.drawable.ic_ticket);

    private final String costType;
    private final int icon;

    CostType(String costType, int icon) {
        this.costType = costType;
        this.icon = icon;
    }

    public String getCostType() {
        return costType;
    }

    public int getIcon() {
        return icon;
    }
}