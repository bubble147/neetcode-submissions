public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
    List<List<Pair>> history = new ArrayList<>();
    if (pairs.isEmpty()) return history;   // 추가

    history.add(new ArrayList<>(pairs));
    for (int i = 1; i < pairs.size(); i++) {
        Pair key = pairs.get(i);
        int j = i - 1;
        while (j >= 0 && pairs.get(j).key > key.key) {
            pairs.set(j + 1, pairs.get(j));
            j--;
        }
        pairs.set(j + 1, key);
        history.add(new ArrayList<>(pairs));
    }
    return history;
}
}
