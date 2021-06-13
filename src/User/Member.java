package User;

public class Member extends Users{

    public String organisationName;

    Member(String username, String password, String type, String organisation) {
        super(username, password, type);
        organisationName = organisation;
    }

    /***
     * ChangePassword updates user members password.

     * @param newPassword   user members new password
     * @return statement string to creates a new organisation unit in database
     */

    public String changePassword(String username, String newPassword) {

        String statement = "UPDATE users SET password = '" + newPassword + "' WHERE username = '" + username;
        return statement;
    }

    /***
     * SellOffer uploads asset into the marketplace.
     * @param asset name of asset
     * @param numOfAssets number of assets
     * @param numOfAssets number of assets
     * @return statement string to creates a new organisation unit in database
     */
    public String sellOffer(String asset, String numOfAssets, String price) {

        String statement = "INSERT INTO current_trades (asset, numOfAssets, price) VALUES (" + asset + ", " + numOfAssets + ", " + price + ");";

        return statement;
    }

    /***
     * BuyOffer uploads asset into the marketplace.
     * @param asset name of asset
     * @param numOfAssets number of assets
     * @return statement string to creates a new organisation unit in database
     */
    public String buyOffer(String asset, String numOfAssets, String price) {

        String statement = "INSERT INTO current_trades (asset, numOfAssets, price) VALUES (" + asset + ", " + numOfAssets + ", " + price + ");";

        return statement;
    }

    /***
     * ViewOrgTrades retrieves all organisations current active trade from database.
     * @return statement string to creates a new organisation unit in database
     */
    public String viewOrgTrades() {

        String statement = "SELECT * FROM current_trades WHERE organisational unit = " + organisationName + ";";

        return statement;
    }

    /***
     * ViewOrgAssets retrieves all organisations assets from database.
     * @return statement string to creates a new organisation unit in database
     */
    public String viewOrgAssets() {

        String statement = "Select * from organisation_unit_information WHERE organisational unit = " + organisationName + ";";

        return statement;
    }
    public static String createAssetOffer(String name, String quantity, String unit, String offer){
        String statement = "INSERT INTO current_trades (organisational_unit, asset_name, quantity, price) VALUES ('"+unit+"', '"+name+"', '"+quantity+"', '"+offer+"')";
        return statement;
    }
}