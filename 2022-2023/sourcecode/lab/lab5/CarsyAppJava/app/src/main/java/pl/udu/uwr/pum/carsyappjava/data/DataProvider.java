package pl.udu.uwr.pum.carsyappjava.data;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public final class DataProvider {
    private DataProvider() {
    }

    public static ArrayList<Car> getCars(){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Home Car", "Skoda", "Fabia", 2002, getGeneralCosts(100)));
        cars.add(new Car("Work Car", "BMW", "Coupe", 2015, getGeneralCosts(50)));
        cars.add(new Car("Fun Car", "Fiat", "125p", 1985, getGeneralCosts(10)));
        return cars;
    }

    private static ArrayList<Cost> getGeneralCosts(int size) {
        ArrayList<Cost> items = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            items.add(new Cost(
                    CostType.values()[new Random().nextInt(CostType.values().length)],
                    LocalDate.of(2022, new Random().nextInt(12) + 1, new Random().nextInt(28) + 1),
                    new Random().nextInt(5000)));
        }
        return items;
    }

    public static ArrayList<CostListItem> getTimeLineList(ArrayList<Cost> costs) {
        ArrayList<CostListItem> items = new ArrayList<>();

        final SortedMap<Month, ArrayList<Cost>> groupedHashMap = groupDataIntoHashMap(costs);

        for (Month date : groupedHashMap.keySet()) {
            ArrayList<Cost> groupingItems = groupedHashMap.get(date);
            if (groupingItems != null) {
                groupingItems.sort(Comparator.comparingInt(o -> o.getDate().getDayOfMonth()));
                groupingItems.forEach(cost -> items.add(new CostGeneralItem(cost)));
            }
            CostDateItem dateItem = new CostDateItem(date.name());
            items.add(dateItem);
        }
        return items;
    }

    private static SortedMap<Month, ArrayList<Cost>> groupDataIntoHashMap(ArrayList<Cost> itemList) {

        SortedMap<Month, ArrayList<Cost>> groupedHashMap = new TreeMap<>();
        for (Cost cost : itemList) {
            Month hashMapKey = cost.getDate().getMonth();
            if (groupedHashMap.containsKey(hashMapKey)) {
                Objects.requireNonNull(groupedHashMap.get(hashMapKey)).add(cost);
            } else {
                ArrayList<Cost> list = new ArrayList<>();
                list.add(cost);
                groupedHashMap.put(hashMapKey, list);
            }
        }
        return groupedHashMap;
    }
}
