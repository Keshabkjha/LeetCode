import java.util.*;
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Hashtable<String , Integer> table = new Hashtable<>();
        for(int i = 0 ; i < list1.length ; i++){
            table.put(list1[i],i);
        }
        int min = Integer.MAX_VALUE;
        HashMap<Integer , ArrayList<String>> map = new HashMap<>();
        for(int i = 0 ; i < list2.length ; i++){
            if(table.containsKey(list2[i])){
                int indexSum = table.get(list2[i]) + i;
                if(map.containsKey(indexSum)){
                    ArrayList<String> list = map.get(indexSum);
                    list.add(list2[i]);
                    map.put(indexSum, list);
                }
                else{
                    ArrayList<String> list = new ArrayList<>();
                    list.add(list2[i]);
                    map.put(indexSum, list);
                }
                min = Math.min(indexSum , min);
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i : map.keySet()){
            if(i == min){
                ArrayList<String> holyFuck = map.get(i);
                for(String s : holyFuck){
                    ans.add(s);
                }
            }
        }
        String[] ansStr = new String[ans.size()];
        int i =0;
        for(String s  : ans){
            ansStr[i++] = s;
        }
        return ansStr;
    }
}