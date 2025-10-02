import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null || list.size() < 2) {
            return list;
        }
        List<Integer> sortedList = new java.util.ArrayList<>(list);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i) > sortedList.get(j)) {
                    Integer temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        return sortedList;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
         if (list == null || list.size() < 2) {
            return list;
        }
        List<Integer> sortedList = new java.util.ArrayList<>(list);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i) < sortedList.get(j)) {
                    Integer temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        return sortedList;
    }
}