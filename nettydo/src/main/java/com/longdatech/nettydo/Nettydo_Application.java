package com.longdatech.nettydo;

import com.longdatech.nettydo.discardexample.DiscardServer;
import com.longdatech.nettydo.discardexample.EchoServer;
import com.longdatech.nettydo.discardexample.TimeServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Nettydo_Application {

    public static void main(String[] args) {
        SpringApplication.run(Nettydo_Application.class,args);

        int port = 8088;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        try{
            new TimeServer(port).run();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
