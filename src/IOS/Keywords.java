package IOS;

import java.io.*;
import java.util.Scanner;

public class Keywords {
    public static void main(String[] args) throws IOException {
        BufferedReader b1= new BufferedReader(new FileReader("E:\\javaSE\\untitled\\test4.txt"));
        String[] str = new String[50];
        String str1;
        int i=0;
        while((str[i]=b1.readLine())!=null){   //��ȡ�ļ��е�ÿһ��
            i++;
        }
        System.out.println("�����ַ���:");
        Scanner s1=new Scanner(System.in);
        str1=s1.next();
        int k=0;
        for(int j=0;j<i;j++){   //�Ƚ�ÿһ�е�����
            if(str[j].equals(str1)){   //�����ȣ������
                System.out.println("���ַ�����java�ؼ���");
                k=1;
            }
        }
        if(k==0){
            System.out.println("���ַ�����java�ؼ���");
        }
        b1.close();
    }
}
