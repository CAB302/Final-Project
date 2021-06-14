package Trade_Program;

import GUI.*;
import Network.Client;
import javax.swing.*;
import java.io.IOException;

public class Program {

    public static Client client;

    public static void main(String[] args) {

        try {
            //Start and connect sever
            client = new Client();

            //Start Gui
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {new Login().setVisible(true); }
            });
        } catch (IOException e) {
            System.out.println("Server must first be running");
        }

    }
}
