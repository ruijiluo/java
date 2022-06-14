package IOS;

import java.io.*;
import java.util.Scanner;

public class Keywords {
    public static void main(String[] args) throws IOException {
        BufferedReader b1= new BufferedReader(new FileReader("E:\\javaSE\\untitled\\test4.txt"));
        String[] str = new String[50];
        String str1;
        int i=0;
        while((str[i]=b1.readLine())!=null){   //读取文件中的每一行
            i++;
        }
        System.out.println("输入字符串:");
        Scanner s1=new Scanner(System.in);
        str1=s1.next();
        int k=0;
        for(int j=0;j<i;j++){   //比较每一行的内容
            if(str[j].equals(str1)){   //如果相等，则输出
                System.out.println("该字符串是java关键字");
                k=1;
            }
        }
        if(k==0){
            System.out.println("该字符串是java关键字");
        }
        b1.close();
    }
}
