package com.wjq.netty.zerocopy;


import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName OldServer.java
 * @createTime 2019年11月06日 09:00:00
 */
public class OldServer {


    public static void main(String[] args) throws Exception{


        ServerSocket serverSocket = new ServerSocket(9999);
        while (true){
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            try{

                byte[] byteArray = new byte[4096];
                while (true){

                   int count = 0;

                   while (-1 != count) {
                     count =  dataInputStream.read(byteArray);

                   }

                }



            }catch (Exception e){
                e.printStackTrace();
            }





        }




    }


}
