package Trade_Program;

import static org.junit.jupiter.api.Assertions.*;
import Network.Client;
import User.Admin;
import User.Member;
import org.junit.jupiter.api.*;
import java.io.IOException;

public class ProgramTester {

    private Admin admin = new Admin("admin1", "password", "Admin");
    private Member member = new Member("member1", "password", "Member", "org1");
    private Client client;

    /*
     * Create a new Client before each test
     */
    @BeforeEach
    public void newClient() throws Exception {
        client = new Client();
    }

    @Test
    /* A typical case - passed by both versions */
    public void createAdmin() throws IOException, ClassNotFoundException {
        String username = "sdf";
        String password = "pass";
        assertEquals(client.sendData(admin.createUserAdmin(username,password)), null);
    }

    @Test
    /* A typical case - passed by both versions */
    public void createMember() throws IOException, ClassNotFoundException {
        String username = "sdf";
        String password = "pass";
        String organisation = "org";
        assertEquals(client.sendData(admin.createUserMember(username,password,organisation)), null);
    }

    @Test
    /* A typical case - passed by both versions */
    public void createAssetType() throws IOException, ClassNotFoundException {
        String typeName = "sdf";

        assertEquals(client.sendData(admin.createAssetType(typeName)), null);
    }

    @Test
    /* A typical case - passed by both versions */
    public void createOrg() throws IOException, ClassNotFoundException {
        String orgName= "sdf";
        String credits = "100";
        String assets = "poo";
        String quantity = "600";
        assertEquals(client.sendData(admin.createOrg(orgName, credits, assets, quantity)), null);
    }

    @Test
    /* A typical case - passed by both versions */
    public void editOrgCredits() throws IOException, ClassNotFoundException {
        String orgName= "sdf";
        String updatedCredits = "100";

        assertEquals(client.sendData(admin.editOrgCredits(orgName,updatedCredits)), null);
    }

    @Test
    /* A typical case - passed by both versions */
    public void editOrgAsset() throws IOException, ClassNotFoundException {
        String orgName= "sdf";
        String assetName = "chips";
        String quantity = "17";

        client.sendData(admin.editOrgAssets(orgName,assetName,quantity));

        assertEquals(client.sendData(admin.getOrgs()), null);
    }

    @Test
    /* A typical case - passed by both versions */
    public void getOrgs() throws IOException, ClassNotFoundException {

        assertEquals(client.sendData(admin.getOrgs()), null);

    }

    @Test
    /* A typical case - passed by both versions */
    public void getUsers() throws IOException, ClassNotFoundException {

        assertEquals(client.sendData(admin.getUsers()), null);

    }

    @Test
    /* A typical case - passed by both versions */
    public void getAssetTypes() throws IOException, ClassNotFoundException {

        assertEquals(client.sendData(admin.getAssetsTypes()), null);

    }

    @Test
    /* A typical case - passed by both versions */
    public void getCurrentBuy() throws IOException, ClassNotFoundException {

        assertEquals(client.sendData(member.viewCurrentBuyOffers()), null);

    }

    @Test
    /* A typical case - passed by both versions */
    public void getCurrentSell() throws IOException, ClassNotFoundException {
        String orgName= "sdf";
        String updatedCredits = "100";

        assertEquals(client.sendData(member.viewCurrentSellOffers()), null);
    }

    @Test
    /* A typical case - passed by both versions */
    public void getTradeHistory() throws IOException, ClassNotFoundException {
        String assetName = "sdf";

        assertEquals(client.sendData(member.viewTradeHistory(assetName)), null);
    }

    @Test
    /* A typical case - passed by both versions */
    public void removeTrade() throws IOException, ClassNotFoundException {
        String assetName = "sdf";

        assertEquals(client.sendData(member.removeTrade(assetName)), null);
    }
}
