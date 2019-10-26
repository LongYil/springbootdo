package com.longdatech.mybatisdo;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeImgeSize {

    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        getAllFileName("D:/jpg/test",list);
        String sourcePre = "D:/jpg/test/";
        String dstPre = "D:/jpg2/";

//        Thumbnails.of(result + "sijili.jpg").size(200, 300).toFile(result + "image_200x300.jpg");


        list.forEach(item->{
            try {
                updateImage(sourcePre + item,dstPre + item,120);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    //获取文件里的所有图片名称
    public static java.util.List getAllFileName(String path, ArrayList<String> fileName) {
        File file = new File(path);
        File[] files = file.listFiles();
        String[] names = file.list();
        if (names != null)
            fileName.addAll(Arrays.asList(names));
        List imageListNameList = new ArrayList();
        for (File a : files) {
            if (a.isDirectory()) {
                imageListNameList.addAll(fileName);
            }
        }
        return imageListNameList;
    }




    public static void updateImage(String inPath,String outPath,int wid) throws IOException {

        InputStream inputStream = new FileInputStream(new File(inPath));

        BufferedImage bufferedImage = ImageIO.read(inputStream);

        int height = bufferedImage.getHeight(); //图片的高
        int width = bufferedImage.getWidth();  //图片的宽

        int newHeight =160;
        int newWidth =120;
        //
//        if(wid>width){
//            double s = wid/width;
//            newHeight = (int) ((int) height*s);
//            newWidth = (int) ((int) width*s);
//        }
//        if(wid<width){
//            double s = width/wid;
//            newHeight = (int) ((int) height/s);
//            newWidth = (int) ((int) width/s);
//        }

        BufferedImage image = new BufferedImage(newWidth,newHeight, BufferedImage.TYPE_INT_BGR);

        Graphics garphics = image.createGraphics();
        garphics.drawImage(bufferedImage, 0, 0, newWidth, newHeight, null);

        OutputStream outputStream = new FileOutputStream(new File(outPath));

        JPEGImageEncoder j = JPEGCodec.createJPEGEncoder(outputStream);
        j.encode(image);

        outputStream.close();

    }

    //390*567   *160


}