package Trade_Program;

import GUI.Login;
import GUI.Users;
import Network.Client;
import javax.swing.*;
import java.io.IOException;

public class Program {

    public static Client client;

    public static void main(String[] args) throws IOException {
        //Start and connect sever
        client = new Client();

        //Start Gui
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {new Login().setVisible(true); }
        });

        //close client socket
        //client.close();
    }
}
