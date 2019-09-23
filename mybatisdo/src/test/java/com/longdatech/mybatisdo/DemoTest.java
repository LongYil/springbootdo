package com.longdatech.mybatisdo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.ExitCodeEvent;
import sun.nio.ch.FileChannelImpl;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.*;
import java.util.Scanner;

@Slf4j
public class DemoTest implements Serializable{


    private static final long serialVersionUID = 8644840316954922164L;

    @Test
    public void test() throws Exception {
        PushbackInputStream in = new PushbackInputStream(new FileInputStream("E:\\out.txt"));


        byte[] bytes = new byte[in.available()];
        for (int i = 0; i < bytes.length; i++) {
            int a = in.read();
            bytes[i] = (byte) a;
        }

        System.out.println(new String(bytes) + ":" + in.available());

        for (int k = 0; k < 10; k++) {
            in.unread(bytes[k]);
        }

        byte[] b = new byte[in.available()];
        in.read(b);
        System.out.println(new String(b) + ":" + in.available());

//        for (int i = 0; i < bytes.length; i++) {
//            int a = in.read();
//            bytes[i] = (byte) a;
//        }
//
//        System.out.println(new String(bytes) + ":" + in.available());

    }

    @Test
    public void test2() throws Exception {
        String fileName = "Hello,How Are You!";
        PushbackInputStream push = null;
        ByteArrayInputStream bat = null;
        bat = new ByteArrayInputStream(fileName.getBytes());
        push = new PushbackInputStream(bat); //回退流
        int temp = 0;
        while ((temp = push.read()) != -1) {
            if (temp == ',') {  //遇到逗号，在逗号前加（，boy）
                push.unread('5');
                temp = push.read();
                System.out.print(",boy" + (char) temp);
            } else {
                System.out.print((char) temp); //正常打印流内容
            }
        }
    }

    @Test
    public void test3(){

        try(InputStream in = new FileInputStream("E:\\out.tx")){
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            System.out.println(new String(bytes));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test4() throws Exception{

        try(BufferedReader in = new BufferedReader(new FileReader("E:\\out.txt"))){
            String temp = in.readLine();
            while (temp != null){
                System.out.println(temp);
                temp = in.readLine();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test5() throws Exception{
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\out.txt"));
        bufferedInputStream.available();
        InputStream inputStream = new FileInputStream("");
    }

    @Test
    public void test6() throws Exception{
        OutputStream outputStream = new FileOutputStream("E:\\out.txt",false);
        outputStream.write("略略略略略".getBytes());
        outputStream.flush();
    }

    @Test
    public void test7() throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\random.txt", "rw");
        randomAccessFile.seek(5);
        long a = randomAccessFile.getFilePointer();
        System.out.println(a);
    }

    @Test
    public void test8() throws Exception{
        File file = new File("E:\\random.txt");
        Reader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String temp = "";
        while ((temp = bufferedReader.readLine()) != null){
            System.out.println(temp);
        }


//        char[] chars = new char[50];
//        reader.read(chars);
//        System.out.println(new String(chars));
    }

    @Test
    public void test9(){
        File file = new File("E:\\random.txt");
        long l = file.length();
        System.out.println(l);
    }

    @Test
    public void test10() throws Exception{
        PipedOutputStream outputStream = new PipedOutputStream();
        InputStream inputStream = new PipedInputStream(outputStream);
        outputStream.write("你好啊".getBytes());

        Thread.sleep(500);

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        System.out.println(new String(bytes));

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while(true) {
            System.out.println("请输入：");
            while(scanner.hasNext()) {
                String string = scanner.nextLine();
                if(string.equals("拜拜")) {
                    System.out.println("客户端退出");
                    scanner.close();
                    //client.close();
                    break;
                }
            }
        }

    }

    @Test
    public void test11(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串(中间能加空格或符号)");
        String a = input.nextLine();
        System.out.println("请输入一个字符串(中间不能加空格或符号)");
        String b = input.next();
        System.out.println("请输入一个整数");
        int c;
        c = input.nextInt();
        System.out.println("请输入一个double类型的小数");
        double d = input.nextDouble();
        System.out.println("请输入一个float类型的小数");
        float f = input.nextFloat();
        System.out.println("按顺序输出abcdf的值：");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(f);
    }

    @Test
    public void test12() throws Exception{
        byte[] a = "哈哈哈".getBytes();
        InputStream stream1 = new ByteArrayInputStream(a);
        InputStream inputStream = new FileInputStream("");

    }

    @Test
    public void test13() throws Exception{
        System.out.println();
        InputStream inputStream = new FileInputStream("E:\\in.txt");


        OutputStream outputStream = new FileOutputStream("E:\\out.txt");

        int temp = inputStream.read();

        while (temp != -1){
            outputStream.write(temp);
            temp = inputStream.read();
        }

        outputStream.write("=====================已结束===================".getBytes());
        outputStream.close();

    }

    @Test
    public void test14(){
        DatagramChannel datagramChannel;//面向数据报 UDP
        SocketChannel socketChannel;//面向数据流 TCP
        FileChannel fileChannel;//面向文件
        ServerSocketChannel serverSocketChannel;//面向监听流
    }

    @Test
    public void test15() throws Exception{
        FileInputStream inputStream = new FileInputStream("E:\\out.txt");
        FileChannel cm = inputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        int k = cm.read(byteBuffer);

        while (k != -1){
            System.out.println("read:" + k);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.clear();
            k = cm.read(byteBuffer);
        }
        inputStream.close();
    }

    @Test
    public void test16() throws Exception{
        byte[] bytes = new byte[1024];
        InputStream inputStream = new FileInputStream("E:\\out.txt");
        InputStream bf = new BufferedInputStream(inputStream);

        inputStream.read(bytes);
        bf.read(bytes);
    }

    @Test
    public void test17() throws Exception{
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("E:\\my.data"));

        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeBoolean(false);
        dataOutputStream.writeChar('a');
        dataOutputStream.writeChar('b');
        dataOutputStream.writeChar('c');

        dataOutputStream.flush();
        dataOutputStream.close();
    }

    @Test
    public void test18() throws Exception {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("E:\\my.data"));

        try{
            boolean b1 = dataInputStream.readBoolean();
            boolean b2 = dataInputStream.readBoolean();
            boolean b3 = dataInputStream.readBoolean();
            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);
        }catch (Exception e){
            e.printStackTrace();
        }


        char c1 = dataInputStream.readChar();
        char c2 = dataInputStream.readChar();
//        char c3 = dataInputStream.readChar();

        System.out.println(c1);
        System.out.println(c2);
//        System.out.println(c3);
    }

    @Test
    public void test19() throws Exception{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("E:\\obj.data"));
        for (int i = 0; i < 10; i++){
            outputStream.writeObject(new Person(i,"i"));
        }
        outputStream.close();
    }

    @Test
    public void test20() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\obj.data"));
        Object obj = objectInputStream.readObject();
        while (obj != null){
            System.out.println(obj.toString());
            obj = objectInputStream.readObject();
        }
    }

    @Test
    public void test21() throws Exception{

        long d = Long.parseLong("2147483648");
        System.out.println(d);
        int i = 0;
        d = d/2;
        while (d !=1 ){
            d/=2;
            i++;
        }
        System.out.println(i+1);
    }


    @Test
    public void test22() throws Exception{
        InputStream inputStream = new FileInputStream("E:\\out.txt");
        Reader reader = new InputStreamReader(inputStream);
        char[] chars = new char[1000];
        reader.read(chars);
        System.out.println(new String(chars));
    }

    @Test
    public void test23() throws Exception{
        OutputStream outputStream = new FileOutputStream("E:\\out.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");

        FilterReader filterReader ;
        Reader reader;
    }

    @Test
    public void test24() throws Exception{
        PipedWriter pipedWriter = new PipedWriter();
        pipedWriter.write("hello，world");
        PipedReader pipedReader = new PipedReader(pipedWriter);
        System.out.println(pipedReader.read());
    }

    @Test
    public void test25() throws Exception{
        InputStream inputStream1 = new FileInputStream("E:\\out.txt");
        InputStream inputStream2 = new FileInputStream("E:\\in.txt");

        InputStream inputStream = new SequenceInputStream(inputStream1,inputStream2);
        byte[] bytes = new byte[2000];
        inputStream.read(bytes);
        System.out.println(new String(bytes));
        bytes = new byte[2000];
        inputStream.read(bytes);
        System.out.println(new String(bytes));
    }

    @Test
    public void test26() throws Exception{
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader("Mary had 1 little lamb... \r and I have 2"));
        int i = 0;
        while(tokenizer.nextToken() != StreamTokenizer.TT_EOF){
            i++;
            if(tokenizer.ttype == StreamTokenizer.TT_WORD) {

                System.out.println(tokenizer.sval + "*");
            } else if(tokenizer.ttype == StreamTokenizer.TT_NUMBER) {

                System.out.println(tokenizer.nval + "#");

            } else if(tokenizer.ttype == StreamTokenizer.TT_EOL) {

                System.out.println("%");
            }
        }
        System.out.println(i);

    }

    @Test
    public void test160() throws Exception{
        IntBuffer intBuffer = IntBuffer.allocate(50);
        int[] ary = new int[8];
        intBuffer.put(ary);


    }

    @Test
    public void test27() throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\in.txt","rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);

        int bytesRead = fileChannel.read(byteBuffer);

        while (bytesRead != -1){
//            System.out.println("Read:" + bytesRead);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
            bytesRead = fileChannel.read(byteBuffer);
        }
        randomAccessFile.close();
    }



    class Person implements Serializable{

        private static final long serialVersionUID = 8845918883507469747L;
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception{
        PipedOutputStream outputStream = new PipedOutputStream();
        InputStream inputStream = new PipedInputStream(outputStream);
        outputStream.write("你好啊".getBytes());

        Thread.sleep(500);

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        System.out.println(new String(bytes));

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while(true) {
            System.out.println("请输入：");
            while(scanner.hasNext()) {
                String string = scanner.nextLine();
                System.out.println(string);
                if(string.equals("拜拜")) {
                    System.out.println("客户端退出");
                    scanner.close();
                    //client.close();
                    break;
                }
            }
        }
    }
}
