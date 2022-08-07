package pl.udu.uwr.pum.carsyappjava.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Consumer;

public final class DataProvider {
    private DataProvider() {
    }

    public static ArrayList<Cost> getGeneralCosts() {
        ArrayList<Cost> items = new ArrayList<>();
        items.add(new Cost(CostType.REFUELING, LocalDate.of(2022, 2, 11), 120));
        items.add(new Cost(CostType.REFUELING, LocalDate.of(2022, 3, 11), 871));
        items.add(new Cost(CostType.SERVICE, LocalDate.of(2022, 4, 23), 1300));
        items.add(new Cost(CostType.PARKING, LocalDate.of(2022, 3, 3), 40));
        items.add(new Cost(CostType.INSURANCE, LocalDate.of(2022, 3, 9), 700));
        items.add(new Cost(CostType.TICKET, LocalDate.of(2022, 3, 12), 100));
        items.add(new Cost(CostType.REFUELING, LocalDate.of(2022, 3, 1), 600));
        items.add(new Cost(CostType.SERVICE, LocalDate.of(2022, 3, 1), 200));
        items.add(new Cost(CostType.REFUELING, LocalDate.of(2022, 4, 24), 400));
        items.add(new Cost(CostType.TICKET, LocalDate.of(2022, 4, 3), 300));
        items.add(new Cost(CostType.REFUELING, LocalDate.of(2022, 2, 20), 300));
        return items;
    }

    public static ArrayList<CostListItem> getTimeLineList() {

        ArrayList<CostListItem> items = new ArrayList<>();
        for (String date : groupedHashMap.keySet()) {
            ArrayList<Cost> groupingItems = groupedHashMap.get(date);
            if (groupingItems != null) {
                groupingItems.sort(Comparator.comparingInt(o -> o.getDate().getDayOfMonth()));
                groupingItems.forEach(cost -> items.add(new CostGeneralItem(cost)));
            }
            CostDateItem dateItem = new CostDateItem(date);
            items.add(dateItem);
        }
        return items;
    }

    private static final HashMap<String, ArrayList<Cost>> groupedHashMap = groupDataIntoHashMap(getGeneralCosts());

    private static HashMap<String, ArrayList<Cost>> groupDataIntoHashMap(ArrayList<Cost> itemList) {

        HashMap<String, ArrayList<Cost>> groupedHashMap = new HashMap<>();

        for (Cost cost : itemList) {
            String hashMapKey = cost.getDate().getMonth().toString();
            if (groupedHashMap.containsKey(hashMapKey)) {
                Objects.requireNonNull(groupedHashMap.get(hashMapKey)).add(cost);
            } else {
                ArrayList<Cost> list = new ArrayList<>();
                list.add(cost);
                list.sort(Comparator.comparingInt(o -> o.getDate().getDayOfMonth()));
                groupedHashMap.put(hashMapKey, list);
            }
        }
        return groupedHashMap;
    }
}
