package User;

public class Users {

    private static String username;
    private static String password;
    private static String type;

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


    /***
     * GetUserByUserNameAndPassword sdfsdf
     * @param username
     * @param password
     * @return
     */
    /*
    public String getUserByUserNameAndPassword(String username, String password) {

        String statement = "SELECT * FROM Current trades WHERE offer = Buy;";

        return statement;

        try {
            Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password
                    + "'";
            // String queryString = "SELECT * FROM users WHERE username = '" + username + "'
            // AND password = '" + password + "' AND account_type = '" + + "'";

            // System.out.println("BACKEND query:\t\t" + queryString);
            ResultSet results = statement.executeQuery(queryString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */

    /***
     * ViewCurrentBuyOffers retrieves all active buy offers from database.
     * @return statement string to retrieve all active buy offers from database
     */
    public static String viewCurrentBuyOffers(){

         String statement = "SELECT * FROM current_trades";

         return statement;
     }

    /***
     * ViewCurrentSellOffers retrieves all active sell offers from database.
     * @return statement string to retrieve all active sell offers from database
     */
    public String viewCurrentSellOffers(){

        String statement = "SELECT * FROM current_trades WHERE offer = Sell;";

        return statement;
    }

    /***
     * RemoveTrade deletes an active trade from marketplace.
     * @param assetName name of asset
     * @return statement string to deletes an active trade from marketplace
     */
    public String removeTrade(String assetName){

         String statement = "DELETE FROM current_trades WHERE asset =" + assetName + ";";

         return statement;
    }
    public static String resetPass(String username, String pass){
        String statement = "UPDATE user_information SET password='"+pass+"' WHERE account_type='user' AND username='"+username+"'";
        return statement;
    }
}
