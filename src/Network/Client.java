package Network;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

public class Client {

    private static Socket socket;
    private static String[] config;

    /***
     * Connects to server
     * @throws IOException
     */
    public Client() throws IOException {
        config = clientConfig();
    }

    /***
     * sendData sends a database statement to the server then waits and returns server reply.
     * @param databaseStatement Database statement that the will execute
     * @return Database output from server
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ArrayList<String[]> sendData(String databaseStatement) throws IOException, ClassNotFoundException  {

        socket = new Socket(config[0], Integer.parseInt(config[1]));

        //Create object to send data
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

        //Send data to server
        objectOutputStream.writeObject(databaseStatement);
        objectOutputStream.flush();

        //Create object to receive data
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        if(!databaseStatement.contains("SELECT")){

            //Close Streams
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();

            return null;
        }else{

            //Receive data from server
            ArrayList<String[]> response = (ArrayList<String[]>) objectInputStream.readObject();

            //Close Streams
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();

            return response; //Return to GUI
        }
    }

    /***
     * ClientConfig reads the client configuration file.
     * @return String array containing client configuration
     * @throws FileNotFoundException
     */
    private static String[] clientConfig() throws FileNotFoundException {
        String[] config = new String[2];

        //Open and read client config file
        URL path = Client.class.getResource("app.config");
        Properties prop = new Properties();
        InputStream is = new FileInputStream(path.getFile());

        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        config[0] = prop.getProperty("app.ip");
        config[1] = prop.getProperty("app.port");

        return config;
    }
}