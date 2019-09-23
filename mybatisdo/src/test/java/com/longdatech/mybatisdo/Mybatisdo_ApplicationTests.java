package com.longdatech.mybatisdo;

import ch.qos.logback.core.net.SyslogOutputStream;
import jdk.internal.util.xml.impl.Input;
import org.junit.Test;
import org.springframework.boot.ExitCodeEvent;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class Mybatisdo_ApplicationTests {

//    @Test
    public void test1(HttpServletRequest a){
        Collection c;
    }

    @Test
    public void test2() throws Exception {
        final PipedOutputStream out = new PipedOutputStream();
        final PipedInputStream in = new PipedInputStream(out);

        Thread t1 = new Thread(()->{
            try {
                out.write("你好，我叫李银龙".getBytes());
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                int temp = in.read();
                while ( (temp ) != -1){
                    System.out.println( (char) temp );
                    temp = in.read();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        // 由高位到低位
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }

    /**
     * byte[]转int
     * @param bytes
     * @return
     */
    public static int byteArrayToInt(byte[] bytes) {
        int value = 0;
        // 由高位到低位
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (bytes[i] & 0x000000FF) << shift;// 往高位游
        }
        return value;
    }


    //测试数据
    public static void main(String[] args) {
//        byte[] b = intToByteArray(128);
//        System.out.println(Arrays.toString(b));//打印byte的每一个字节
//
//        int i = byteArrayToInt(b);
//        System.out.println(i);  //打印byte转变为Int后的数据
//        String string = "h";

//        byte[] bytes = string.getBytes();//获得byte数组

//        System.out.println("bytes-->" + Arrays.toString(bytes));//打印byte数组
//
//        System.out.println("string-->" + new String(bytes));//获得byte数组转换来的String数据，并打印
    }

    @Test
    public void test3(){
        byte[] bytes = new byte[256];
        int j = -10000000;
        for (int i = 0; i < 256; i++){
            bytes[i] = (byte) j;
            System.out.println(bytes[i]);
            j++;
        }
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void test4(){
        byte a = (byte) 10000000;
        System.out.println(a);
    }

    @Test
    public void test6() throws Exception {
        byte[] str1 = "林".getBytes("GBK");
        System.out.println(Arrays.toString(str1));

        byte[] str2 = "李".getBytes("GBK");
        System.out.println(Arrays.toString(str2));

        byte[] str3 = "木".getBytes("GBK");
        System.out.println(Arrays.toString(str3));

        byte[] str4 = "村".getBytes("GBK");
        System.out.println(Arrays.toString(str4));

        byte[] str5 = "样".getBytes("GBK");
        System.out.println(Arrays.toString(str5));

        byte[] str6 = "杨".getBytes("GBK");
        System.out.println(Arrays.toString(str6));

        byte[] str10 = {-47,-7};

        System.out.println(new String(str10,"GBK"));
//        String str = "你好h";
//        byte[] bytes = str.getBytes("GBK");
//        System.out.println(new String(bytes,"GBK"));
    }

    @Test
    public void test7() throws Exception{
//        InputStream in = new FileInputStream("E:\\cc.java");
//        System.out.println(in.available());
//        System.out.println(in.available());
//        byte[] bytes = new byte[in.available()];
//        in.read(bytes);
//        System.out.println(in.available());
//        System.out.println(new String(bytes,"GBK"));

        Reader reader = new FileReader("E:\\cc.java");
        char a = Character.MAX_VALUE;
        System.out.println((int)a);
        char b = '䨻';
        System.out.println((int)b);
        int d = 19903;
        char e = 197;
        System.out.println(e);
//        for(int i = 0; i < 65535; i++){
//            char c = (char) i;
//            System.out.print(c);
//        }
    }

    @Test
    public void test8() throws Exception{
        Reader reader = new FileReader("E:\\cc.java");
        char[] chars = new char[5000];
        reader.read(chars);
        System.out.println(new String(chars));
    }

    @Test
    public void test9() throws Exception{
        OutputStream out = new FileOutputStream("E:\\test.text");
        String hello = "Hello,My name is 李银龙";
        out.write(hello.getBytes());
        out.close();

    }
    @Test
    public void test10() throws Exception{
        InputStream in = new FileInputStream("E:\\test.text");
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        System.out.println(new String(bytes));
    }

    @Test
    public void test11() throws Exception{
        Reader reader = new FileReader("E:\\test1.txt");
        char[] chars = new char[5000];
        reader.read(chars);
        System.out.println(new String(chars));
        reader.close();
    }

    @Test
    public void test12() throws Exception{
        Writer writer = new FileWriter("E:\\test1.txt");
        String str = "hello ,my name is 李银龙, FileWriter";
        writer.write(str);
        writer.close();
    }

    @Test
    public void test13(){
        File file = new File("E:\\test1.txt");
    }

    @Test
    public void test14() throws Exception{
        String hello = "李银龙";
        InputStream in = new ByteArrayInputStream(hello.getBytes());
    }

    @Test
    public void test15() throws Exception{
        LylOut o = new LylOut("E:\\lylout.txt");
        Random random = new Random();
        System.setOut(o);

        System.out.println("哈哈哈哈,嘻嘻嘻嘻" + random.nextInt());
        System.out.println("哈哈哈哈,嘻嘻嘻嘻" + random.nextInt());
        System.out.println("哈哈哈哈,嘻嘻嘻嘻" + random.nextInt());

    }

    class LylOut extends PrintStream {
        public LylOut(String fileName) throws FileNotFoundException {
            super(fileName);
        }

        public void println(String x) {
            this.append(x);
        }

        public PrintStream append(CharSequence csq) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (csq == null)
                print("null");
            else
                super.println(dateFormat.format(new Date()) + ":" + csq.toString());
            return this;
        }
    }






















}
