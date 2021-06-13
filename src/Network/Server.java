package Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Server {

    //Database connection
    private static Connection connection;

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        connection = DBConnection(); //Connect to database
        Statement statement = connection.createStatement();

        //String[] config = serverConfig();
        ServerSocket serverSocket = new ServerSocket(12345, 2); //Server Socket

        for (; ; ) {
            Socket socket = serverSocket.accept();

            //Get and Read Client data
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            String clientStatement = (String) objectInputStream.readObject(); //This is the client data

            //Send back to database response to client
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            System.out.println(clientStatement);

            //Execute Statement in database
            if(!clientStatement.contains("SELECT")){
                statement.executeUpdate(clientStatement);
            }else{
                String data_row[] = null;
                ArrayList<String[]> data_list = null;
                ResultSet result = null;
                int data_row_counter=1;
                try{
                    result = statement.executeQuery(clientStatement);
                }
                catch (Exception e){
                    System.out.println("Server: "+e);
                }
                try{
                    if(clientStatement.contains("user_information")){
                        data_list = new ArrayList<String[]>();

                        while(result.next()) {
                            data_row = new String[5];
                            data_row[0] = ""+result.getInt("id");
                            data_row[1] = result.getString("username");
                            data_row[2] = result.getString("password");
                            data_row[3] = result.getString("account_type");
                            data_row[4] = result.getString("organisational_unit");
                            data_list.add(data_row);

                        }

                    }

                    else if(clientStatement.contains("organisational_unit_information")){
                        data_list = new ArrayList<String[]>();


                        while(result.next()) {
                            data_row = new String[5];
                            data_row[0] = result.getString("id");
                            data_row[1] = result.getString("organisational_unit_name");
                            data_row[2] = result.getString("credits");
                            data_row[3] = result.getString("assets");
                            data_row[4] = result.getString("quantity");
                            data_list.add(data_row);

                        }
                    }
                    else if(clientStatement.contains("asset_type")){
                        data_list = new ArrayList<String[]>();


                        while(result.next()) {
                            data_row = new String[2];
                            data_row[0] = result.getString("id");
                            data_row[1] = result.getString("asset_names");
                            data_list.add(data_row);

                        }
                    }
                    else if (clientStatement.contains("current_trades")){
                        data_list = new ArrayList<String[]>();


                        while(result.next()) {
                            data_row = new String[6];
                            data_row[0] = result.getString("id");
                            data_row[1] = result.getString("organisational_unit");
                            data_row[2] = result.getString("asset_name");
                            data_row[3] = result.getString("quantity");
                            data_row[4] = result.getString("price");
                            data_row[5] = result.getString("timestamp");
                            data_list.add(data_row);

                        }
                    }
//                    else if(clientStatement.contains("trade_history")){
//                        data_row = new String[data_row_counter][4];
//
//                        while(result.next()) {
//
//                            data_row[data_row_counter-1][0] = result.getString("offer_type");
//                            data_row[data_row_counter-1][1] = result.getString("organisational_unit");
//                            data_row[data_row_counter-1][2] = result.getString("asset_name");
//                            data_row[data_row_counter-1][3] = result.getString("quantity");
//                            data_row[data_row_counter-1][3] = result.getString("price");
//                            data_row[data_row_counter-1][3] = result.getString("date");
//                            ++data_row_counter;
//
//                        }
//                    }

                }catch (Exception e){
                    System.out.println("Server: "+e);

                }
                objectOutputStream.writeObject(data_list); //send back to client
            }


            //Close streams
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        }
    }

    /**
     * Establishes connection to MySQL database
     */
    private static Connection DBConnection() {
        String DB_URL = "jdbc:mysql://localhost:3306/eatp";
        String USERNAME = "root";
        String PASSWORD = "";

        try {

            return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        }
        catch (SQLException e) {

            throw new RuntimeException("Error connecting to the database", e);

        }
    }

    private static String[] serverConfig() throws FileNotFoundException {
        String[] config = new String[1];
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
}
