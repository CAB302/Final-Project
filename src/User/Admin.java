package User;

public class Admin extends Users {

    public Admin(String username, String password, String type) {
        super(username, password, type);
    }

    /***
     * CreateOrg creates a new organisation unit in database.
     * @param orgName   name of organisation
     * @param credits   number of credits the organisation has
     * @param assetName   name of asset
     * @param numOfAssets   number of asset
     * @return statement string to creates a new organisation unit in database
     */
    public static String createOrg(String orgName, String  credits, String assetName, String  numOfAssets) {

        String statement = "INSERT INTO organisational_unit_information (organisational_unit_name, credits, assets, quantity) VALUES ('" + orgName + "', '" +  credits + "', '" + assetName + "', '" + numOfAssets + "');";

        return statement;
    }

    /***
     * CreateUserMember creates a new user member in database.
     * @param username  user members username
     * @param password  user members password
     * @param organisation  user member's organisation unit
     * @return statement string to creates a new user member in database
     */
    public static String createUserMember(String username, String password, String organisation) {

        String hashPassword = getHash(password.getBytes(), "SHA-1");
        String statement = "INSERT INTO user_information (username, password, account_type, organisational_unit) VALUES ('" + username + "', '" + hashPassword + "', 'member', '" + organisation + "');";

        return statement;
    }

    /***
     * CreateUserAdmin creates a new user admin in database.
     * @param username user admins username
     * @param password user admins password
     * @return statement string to creates a new user admin in database
     */
    public static String createUserAdmin(String username, String password) {

        String hashPassword = getHash(password.getBytes(), "SHA-1");
        String statement = "INSERT INTO user_information (username, password, account_type) VALUES ('" + username + "', '" + hashPassword + "', 'admin');";

        return statement;
    }

    /***
     * CreateAssetType creates a new asset category in database.
     * @param assetType type of asset
     * @return statement string to creates a new asset category in database
     */
    public static String createAssetType(String assetType) {

        String statement = "INSERT INTO asset_types (asset_names) VALUES ('" + assetType + "');";

        return statement;
    }

    /***
     * EditOrgCredits updates the number of credits an organisation has in database.
     * @param orgName name of organisation
     * @param numOfCredits updated number of credits
     * @return statement string to update the number of credits an organisation has in database
     */
    public static String editOrgCredits(String orgName, String numOfCredits) {

        String statement = "UPDATE organisational_unit_information SET credits = '" + numOfCredits + "' WHERE organisational_unit_name = '" + orgName +"';";

        return statement;
    }

    /***
     * EditOrgAssets updates the amount of an asset an organisation has in database.
     * @param orgName name of organisation
     * @param asset name of asset
     * @param numOfAssets   updated number of asset
     * @return statement string to update the amount of an asset an organisation has in database
     */
    public static String editOrgAssets(String orgName, String asset, String numOfAssets) {

        String statement = "UPDATE organisational_unit_information SET quantity = '" + numOfAssets + "' WHERE organisational_unit_name = '" + orgName + "' AND assets = '" + asset + "';";

        return statement;
    }

    /***
     *
     * @return
     */
    public static String getOrgs() {

        String statement = "SELECT * from organisational_unit_information;";

        return statement;
    }

    /***
     *
     * @return
     */
    public static String getUsers() {

        String statement = "SELECT * from user_information;";

        return statement;
    }

    /***
     *
     * @return
     */
    public static String getAssetsTypes() {

        String statement = "SELECT * from asset_types;";

        return statement;
    }

    public static String deleteUser(int id){
        String statement = "DELETE FROM user_information WHERE id="+id+"";

        return statement;
    }
    public static String deleteAsset(int id){
        String statement = "DELETE FROM asset_type WHERE id="+id+"";

        return statement;
    }
    public static String editAsset(String name, int id){
        String statement="UPDATE asset_type SET asset_names='"+name+"' WHERE id="+id;

        return statement;
    }
    public static String editUser(String username, String password,int id){
        String statement="UPDATE user_information SET username='"+username+"', password='"+password+"' WHERE id="+id;

        return statement;
    }
}
