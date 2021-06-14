package User;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class Users {

    private static String username;
    private static String password;
    private static String type;

    public static String resetPass(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /***
     * Assigns new user a unique username and password.
     * @param username  users unique username
     * @param password  users password
     * @param type type of user
     */
    Users(String username, String password, String type) {

        this.username = username;
        this.password = password;
        this.type = type;
    }

    public static String getHash(byte[] inputBytes, String algorithm){
        String value = "";
        try{
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(inputBytes);
            byte[] digestedBytes = messageDigest.digest();
            value = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        } catch (Exception e){

        }
        return value;
    }


    /***
     * ViewCurrentBuyOffers retrieves all active buy offers from database.
     * @return statement string to retrieve all active buy offers from database
     */
    public static String viewCurrentBuyOffers(){

         String statement = "SELECT * FROM current_trades WHERE offer_type = 'BUY';";

         return statement;
     }

    /***
     * ViewCurrentSellOffers retrieves all active sell offers from database.
     * @return statement string to retrieve all active sell offers from database
     */
    public static String viewCurrentSellOffers(){

        String statement = "SELECT * FROM current_trades WHERE offer_type = 'SELL';";

        return statement;
    }

    /***
     * RemoveTrade deletes an active trade from marketplace.
     * @param assetName name of asset
     * @return statement string to deletes an active trade from marketplace
     */
    public static String removeTrade(String assetName){

         String statement = "DELETE FROM current_trades WHERE asset_name = '" + assetName + "';";

         return statement;
    }

    public static String viewTradeHistory(String assetName){

        String statement = "SELECT * FROM trade_history WHERE asset_name = '"+ assetName + "';";

        return statement;
    }
}
