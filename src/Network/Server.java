package Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Server {

    private static Connection connection;

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        connection = dbConnection(); //Connect to database

        String[] config = serverConfig();
        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(config[0]), 5); //Server Socket

        for(;;){
            Socket socket = serverSocket.accept();

            try{
                //Get and Read Client data
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                String clientStatement = (String) objectInputStream.readObject(); //This is the client data

                //Create object to send data
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                //Execute Statement in database
                Statement statement = connection.createStatement();
                if (!clientStatement.contains("SELECT")) {

                    statement.executeUpdate(clientStatement);

                } else {

                    ResultSet result = statement.executeQuery(clientStatement);
                    String data_row[] = null;
                    ArrayList<String[]> data_list = null;

                    if (clientStatement.contains("user_information")) {
                        data_list = new ArrayList<String[]>();

                        while(result.next()) {

                            data_row = new String[4];
                            //data_row[0] = ""+result.getInt("id");
                            data_row[0] = result.getString("username");
                            data_row[1] = result.getString("password");
                            data_row[2] = result.getString("account_type");
                            data_row[3] = result.getString("organisational_unit");
                            data_list.add(data_row);

                        }
                    } else if (clientStatement.contains("organisational_unit_information")) {

                        data_list = new ArrayList<String[]>();

                        while(result.next()) {

                            data_row = new String[4];
                            //data_row[0] = result.getString("id");
                            data_row[0] = result.getString("organisational_unit_name");
                            data_row[1] = result.getString("credits");
                            data_row[2] = result.getString("assets");
                            data_row[3] = result.getString("quantity");
                            data_list.add(data_row);

                        }
                    } else if (clientStatement.contains("asset_type")) {

                        data_list = new ArrayList<String[]>();

                        while(result.next()) {

                            data_row = new String[1];
                            //data_row[0] = result.getString("id");
                            data_row[0] = result.getString("asset_names");
                            data_list.add(data_row);

                        }
                    } else if (clientStatement.contains("current_trades")) {

                        data_list = new ArrayList<String[]>();

                        while(result.next()) {

                            data_row = new String[6];
                            data_row[0] = result.getString("offer_type");
                            data_row[1] = result.getString("organisational_unit");
                            data_row[2] = result.getString("asset_name");
                            data_row[3] = result.getString("quantity");
                            data_row[4] = result.getString("price");
                            data_row[5] = result.getString("date");
                            data_list.add(data_row);

                        }
                    } else if (clientStatement.contains("trade_history")) {

                        data_list = new ArrayList<String[]>();

                        while(result.next()) {

                            data_row = new String[6];
                            data_row[0] = result.getString("offer_type");
                            data_row[1] = result.getString("organisational_unit");
                            data_row[2] = result.getString("asset_name");
                            data_row[3] = result.getString("quantity");
                            data_row[4] = result.getString("price");
                            data_row[5] = result.getString("date");
                            data_list.add(data_row);

                        }
                    }
                    objectOutputStream.writeObject(data_list); //send back to client
                }

                //Close streams
                objectInputStream.close();
                objectOutputStream.close();
                socket.close();

            } catch (IOException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /***
     * dbConnection establishes connection to MySQL database
     * @return database connection
     */
    private static Connection dbConnection() {
        String DB_URL = "jdbc:mysql://localhost:3306/eatp";
        String USERNAME = "root";
        String PASSWORD = "password";

        try {

            return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        }
        catch (SQLException e) {

            throw new RuntimeException("Error connecting to the database", e);

        }
    }


    /***
     * serverConfig
     * @return
     * @throws FileNotFoundException
     */
    private static String[] serverConfig() throws FileNotFoundException {
        String[] config = new String[1];

        //Open and read server config file
        URL path = Client.class.getResource("server.config");
        Properties prop = new Properties();
        InputStream is = new FileInputStream(path.getFile());

        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        config[0] = prop.getProperty("server.port");

        return config;
    }

}
