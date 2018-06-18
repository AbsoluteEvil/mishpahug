package tests;


import org.testng.annotations.Test;


public class loginTest extends TestBase {
    @Test
    public void testCreateGroupLongName() {
        app.getGroupHelper().initGroupCreation();
    }

}
