import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question1 {

    public static void main(String[] args) {
        //List 1  List 2   Amount
        String s1 = "ankit";
        String s2 = "Jain";
        if (s1.compareToIgnoreCase(s2) > 0)
            System.out.println("1");
        List<String> lenders = new ArrayList<>();
        List<String> receivers = new ArrayList<>();
        List<Integer> amount = new ArrayList<>(); //assuming the amount to be integers

        lenders.add("Sachin");
        lenders.add("Sanjib");
        lenders.add("Aashish");
        lenders.add("Aashish");
        lenders.add("Manu");

        receivers.add("Aashish");
        receivers.add("Sachin");
        receivers.add("Sanjib");
        receivers.add("Manu");
        receivers.add("Aashish");

        amount.add(20);
        amount.add(70);
        amount.add(40);
        amount.add(100);
        amount.add(100);

        // first part print for each person, how much he owes total amount
        calculateTotalAmountOwed(lenders, receivers, amount);
    }

    private static void calculateTotalAmountOwed(List<String> lenders, List<String> receivers, List<Integer> amount) {
        //hashmap<String, Integer> // person to amount owed
        HashMap<String, Integer> innerhashMap = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();
        //================
        // A B 20 - A has to give B Rs. 20 //subtract 10
        //   C 30
        // A B 10
        //================
        // A B 20
        // A C 30
        // B A 10
        // expectation
        // A B 10
        // A C 30
        int n = lenders.size();
        for (int i = 0; i < n; i++) {
            String person1 = lenders.get(i);
            String person2 = receivers.get(i);
            int currentAmount = amount.get(i);
            if (person1.compareToIgnoreCase(person2) < 0)
                if (map.containsKey(person1)) {
                    HashMap<String, Integer> stringIntegerHashMap = map.get(person1);
                    if (stringIntegerHashMap.containsKey(person2)) {
                        int val = stringIntegerHashMap.get(person2);
                        val = val + currentAmount;
                        stringIntegerHashMap.put(person2, val);
                    } else {
                        stringIntegerHashMap.put(person2, currentAmount);
                    }

                } else {
                    HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
                    stringIntegerHashMap.put(person2, currentAmount);
                    map.put(person1, stringIntegerHashMap);
                }

            else if (person1.compareToIgnoreCase(person2) > 0) {
                if (map.containsKey(person2)) {
                    HashMap<String, Integer> stringIntegerHashMap = map.get(person2);
                    if (stringIntegerHashMap.containsKey(person1)) {
                        int val = stringIntegerHashMap.get(person1);
                        val = val - currentAmount;
                        stringIntegerHashMap.put(person1, val);
                    } else {
                        stringIntegerHashMap.put(person1, -currentAmount);
                    }

                } else {
                    HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
                    stringIntegerHashMap.put(person1, -currentAmount);
                    map.put(person2, stringIntegerHashMap);
                }

            }
        }
        System.out.println(map);
    }
}

