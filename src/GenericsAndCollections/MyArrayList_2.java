package GenericsAndCollections;

import java.util.ArrayList;

public class MyArrayList_2 {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(100);
        list.add(70);
        list.add(55);
        list.add(54);
        list.add(78);
        list.add(88);
        list.add(91);
        list.add(51);
        //遍历1
        for (int i=0;i<list.size();i++){
            if(list.get(i)<60){
                list.remove(i);
                i--;   //使下标回归原始
            }
        }
        System.out.println(list);
        //遍历2
        for (int i=list.size()-1;i>=0;i--){
            if(list.get(i)<60){
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
