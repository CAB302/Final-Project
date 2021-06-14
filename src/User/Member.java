package User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member extends Users{

    public static String organisationName;


    public Member(String username, String password, String type, String organisation) {
        super(username, password, type);
        organisationName = organisation;
    }

    /***
     * ChangePassword updates user members password.
     * @param newPassword   user members new password
     * @return statement string to creates a new organisation unit in database
     */
    public static String changePassword(String username, String newPassword) {

        String hashPassword = getHash(newPassword.getBytes(), "SHA-1");
        String statement = "UPDATE user_information SET password = '" + hashPassword + "' WHERE username = '" + username + "';";
        return statement;
    }

    /***
     * SellOffer uploads asset into the marketplace.
     * @param asset name of asset
     * @param quantity number of assets
     * @param quantity number of assets
     * @return statement string to creates a new organisation unit in database
     */
    public static String sellOffer(String asset, String quantity, String price) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
        Date date = new Date(System.currentTimeMillis());

        String statement = "INSERT INTO current_trades (offer_type, organisational_unit, asset_name, quantity, price, date) VALUES ('SELL', '" +
                organisationName + "', '" + asset + "', '" + quantity + "', '" + price + "', '" + formatter.format(date) + "');";

        return statement;
    }

    /***
     * BuyOffer uploads asset into the marketplace.
     * @param asset name of asset
     * @param quantity number of assets
     * @return statement string to creates a new organisation unit in database
     */
    public static String buyOffer(String asset, String quantity, String price) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
        Date date = new Date(System.currentTimeMillis());

        String statement = "INSERT INTO current_trades (offer_type, organisational_unit, asset_name, quantity, price, date) VALUES ('BUY', '" +
                organisationName + "', '" + asset + "', '" + quantity + "', '" + price + "', '" + formatter.format(date) + "');";

        return statement;
    }

    /***
     * ViewOrgTrades retrieves all organisations current active trade from database.
     * @return statement string to creates a new organisation unit in database
     */
    public static String viewOrgTrades() {

        String statement = "SELECT * FROM current_trades WHERE organisational_unit = '" + organisationName + "';";

        return statement;
    }

    /***
     * ViewOrgAssets retrieves all organisations assets from database.
     * @return statement string to creates a new organisation unit in database
     */
    public static String viewOrgAssets() {

        String statement = "SELECT * from organisational_unit_information WHERE organisational_unit_name = '" + organisationName + "';";

        return statement;
    }
}