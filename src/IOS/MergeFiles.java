package IOS;

import java.io.*;

//使用文件字节输入/输出流，合并两个指定的文件。
public class MergeFiles {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fi1 = new FileInputStream("E:\\javaSE\\untitled\\untitled1\\test1.txt");
        FileInputStream fi2 = new FileInputStream("E:\\javaSE\\untitled\\untitled1\\test2.txt");
        FileOutputStream fo3 = new FileOutputStream("test3.txt");
        int lne;
        byte[] b1 = new byte[1024];
        byte[] b2 = new byte[1024];
        try {
            while (( lne= fi1.read(b1)) != -1) {
                fo3.write(b1,0,lne);
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file.");
        }
        try {
            while (( lne= fi2.read(b2)) != -1) {
                fo3.write(b2,0,lne);
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
