package GenericsAndCollections;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;

//1. 使用ArrayList集合，对其添加10个不同的元素，并使用Iterator遍历该集合。
public class MyArrayList {
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.add("java");
        for (int i=0;i<9;i++){
            list.add(i);
        }
        System.out.println(list.get(0));   //返回对应引索的元素
        System.out.println(list.size());   //返回集合的大小(元素个数)
        System.out.println(list.set(1,"Hello"));   //设置对应引索的元素,返回被修改的元素
        System.out.println(list.remove("Hello"));   //删除与"2"相同的第一个出现的元素,返回boolean值
        System.out.println(list.remove(3));   //删除对应引索的元素,返回被修改的元素
        System.out.println(list);   //输出集合的所有元素

    }
}
