package GenericsAndCollections;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;

//1. ʹ��ArrayList���ϣ��������10����ͬ��Ԫ�أ���ʹ��Iterator�����ü��ϡ�
public class MyArrayList {
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.add("java");
        for (int i=0;i<9;i++){
            list.add(i);
        }
        System.out.println(list.get(0));   //���ض�Ӧ������Ԫ��
        System.out.println(list.size());   //���ؼ��ϵĴ�С(Ԫ�ظ���)
        System.out.println(list.set(1,"Hello"));   //���ö�Ӧ������Ԫ��,���ر��޸ĵ�Ԫ��
        System.out.println(list.remove("Hello"));   //ɾ����"2"��ͬ�ĵ�һ�����ֵ�Ԫ��,����booleanֵ
        System.out.println(list.remove(3));   //ɾ����Ӧ������Ԫ��,���ر��޸ĵ�Ԫ��
        System.out.println(list);   //������ϵ�����Ԫ��

    }
}
