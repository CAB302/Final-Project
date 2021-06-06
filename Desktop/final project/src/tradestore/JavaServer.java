package tradestore;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.Date;
import java.util.Properties;


public class JavaServer {

    public JavaServer(){
        startServer();
    }

    public void startServer(){
        Properties prop = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(new File("src\\tradestore\\app.config").getAbsolutePath());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            prop.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        new Thread(new Runnable(){
            @Override
            public synchronized void run(){
                try{
                    @SuppressWarnings("resource")
                    ServerSocket server = new ServerSocket(Integer.parseInt(prop.getProperty("app.port")));

                    while(true){
                        final Socket data = server.accept();
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(test.getInputStream()));
                        DataInputStream dis = new DataInputStream(data.getInputStream());



//                        dout.close();


                        while(!data.isClosed()) {
                            String line = (String)dis.readUTF();
                            System.out.println(line);

                            if(!line.equals(" ") && !line.equalsIgnoreCase("Hello Server")){
                                String[] word=line.split("-");

                                Connection conn = null;
                                try {
                                    // db parameters
                                    String url = "jdbc:sqlite:trade.db";
                                    // create a connection to the database
                                    conn = DriverManager.getConnection(url);
                                    if(word[0].equalsIgnoreCase("save_user")){

                                        String sql = "INSERT INTO user(username, password, acc_type, org_unit) VALUES(?, ?, ?, ?)";
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setString(1, word[1]);
                                        ps.setString(2, word[2]);
                                        ps.setString(3, word[3]);
                                        ps.setString(4, word[4]);
                                        ps.executeUpdate();
                                    }
                                    else if(word[0].equalsIgnoreCase("edit_user")){

                                        String sql = "UPDATE user SET username=?, password=?, acc_type=?, org_unit=? WHERE rowid=?";
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setString(1, word[2]);
                                        ps.setString(2, word[3]);
                                        ps.setString(3, word[4]);
                                        ps.setString(4, word[5]);
                                        ps.setInt(5, Integer.parseInt(word[1]));
                                        ps.executeUpdate();
                                    }
                                    else if(word[0].equalsIgnoreCase("delete_user")){

                                        String sql = "DELETE FROM user WHERE rowid=?";
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setInt(1, Integer.parseInt(word[1]));
                                        ps.executeUpdate();
                                    }
                                    else if(word[0].equalsIgnoreCase("save_admin")){

                                        String sql = "INSERT INTO admin(username, password) VALUES(?, ?)";
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setString(1, word[1]);
                                        ps.setString(2, word[2]);
                                        ps.executeUpdate();
                                    }
                                    else if(word[0].equalsIgnoreCase("edit_admin")){

                                        String sql = "UPDATE admin SET username=?, password=? WHERE rowid=?";
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setString(1, word[2]);
                                        ps.setString(2, word[3]);
                                        ps.setInt(3, Integer.parseInt(word[1]));
                                        ps.executeUpdate();
                                    }
                                    else if(word[0].equalsIgnoreCase("delete_admin")){

                                        String sql = "DELETE FROM admin WHERE rowid=?";
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setInt(1, Integer.parseInt(word[1]));
                                        ps.executeUpdate();
                                    }
                                    else if(word[0].equalsIgnoreCase("save_org")){

                                        String sql = "INSERT INTO org_unit(name, credits) VALUES(?, ?)";
                                        PreparedStatement ps = conn.prepareStatement(sql);

                                        ps.setString(1, word[1]);
                                        ps.setString(2, word[2]);
                                        ps.executeUpdate();
                                    }
                                    else if(word[0].equalsIgnoreCase("save_asset")){

                                        String sql = "INSERT INTO asset(name) VALUES(?)";
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setString(1, word[1]);
                                        ps.executeUpdate();
                                    }
                                    else if(word[0].equalsIgnoreCase("edit_asset")){

                                        String sql = "UPDATE asset SET name=? WHERE rowid=?";
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setString(1, word[2]);
                                        ps.setInt(2, Integer.parseInt(word[1]));
                                        ps.executeUpdate();
                                    }
                                    else if(word[0].equalsIgnoreCase("delete_asset")){

                                        String sql = "DELETE FROM asset WHERE rowid=?";
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setInt(1, Integer.parseInt(word[1]));
                                        ps.executeUpdate();
                                    }
                                    else if(word[0].equalsIgnoreCase("login")){
                                        String sql = "SELECT * FROM admin WHERE username=? AND password=?";
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setString(1, word[1]);
                                        ps.setString(2, word[2]);
                                        ResultSet rs = ps.executeQuery();
                                        DataOutputStream dout=new DataOutputStream(data.getOutputStream());
                                        if(rs.next()){
                                            dout.writeUTF("LoggedIn");
                                        }else{
                                            dout.writeUTF("NotVerified");
                                        }
                                        dout.flush();
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e.getMessage());
                                } finally {
                                    try {
                                        if (conn != null) {
                                            conn.close();
                                        }
                                    } catch (SQLException ex) {
                                        System.out.println(ex.getMessage());
                                    }
                                }
                            }

                            data.close();

                        }
//                        reader.close();

                    }
                }catch(Exception err){
                    err.printStackTrace();
                }
            }
        }).start();
    }
}
