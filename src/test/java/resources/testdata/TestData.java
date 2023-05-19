package resources.testdata;

import org.testng.annotations.DataProvider;

/**
 * Created by Jay
 */
public class TestData {

    @DataProvider(name = "credentials")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"Tester","Harrow"},
                {"Software Developer","Central London"},
                {"Game Developer","Croyden"},
                {"Web Developer","Central London"},
                {"Hardware Developer","Central London"},
                {"OS Developer","Central London"},
                {"Desktop App Developer","Glassgow"},
        };
        return data;
    }

}
