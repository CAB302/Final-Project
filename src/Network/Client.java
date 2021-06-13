package Network;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Client {

    private static Socket socket;

    //Connect to server
    public Client() throws IOException {
        //String[] config = clientConfig();
        //socket = new Socket(config[0], Integer.parseInt(config[1]));
//        socket = new Socket("127.0.0.1", 12345);
    }

    //Use this main to test the Client send data This will be later deleted
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Client x = new Client();
        x.sendData("INSERT INTO asset_types (asset_names) VALUES ('nig');");
    }

    public ArrayList<String[]> sendData(String databaseStatement) throws IOException, ClassNotFoundException  {

        socket = new Socket("127.0.0.1", 12345);

        //Create object to send data
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

        //Send data to server
        objectOutputStream.writeObject(databaseStatement);
        objectOutputStream.flush();

        //Create object to receive data
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        if(!databaseStatement.contains("SELECT")){
            return null;
        }else{

            //Receive data from server

            ArrayList<String[]> response = (ArrayList<String[]>) objectInputStream.readObject();

            //See what the server sent back will delete later
            for (String i[] : response) {
                System.out.println(Arrays.toString(i));
            }

            return response; //Return to GUI
        }
    }

    //Read client configuration file and return client configuration
    private static String[] clientConfig() throws FileNotFoundException {
        String[] config = new String[2];
        int index = 0;

        //Open server config file
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);

        //Get server address and port from file
        while (myReader.hasNextLine()) {

            config[index] = myReader.nextLine();
            index += 1;

        }
        return config;
    }

    public void close() throws IOException {
//        socket.close();
    }
}