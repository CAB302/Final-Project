package tradestore;
import java.io.DataInputStream;
import java.io.PrintWriter;

import java.io.DataOutputStream;
import java.net.Socket;

public class JavaClient {
    public JavaClient(){
      startClient();
    }
    public void startClient(){
        new Thread(new Runnable(){
            @Override
            public synchronized void run(){
                try{
                    Socket sendChat = new Socket("localhost", 6666);
                    DataOutputStream dout=new DataOutputStream(sendChat.getOutputStream());


                    while(true){
                        Thread.sleep(1000); // normally 180000

                        dout.writeUTF("Hello Server");
                        break;
                    }
                    dout.flush();
//                    dout.close();

//                    DataInputStream dis = new DataInputStream(sendChat.getInputStream());
//                    System.out.println(((String)dis.readUTF()));

                }catch(Exception err){
                    err.printStackTrace();
                }
            }
        }).start();
    }

}
