package Test;

import Base.BaseTest;
import Page.PageDeviation;
import org.testng.annotations.Test;

public class DeviationPage extends BaseTest {
    @Test
    public void testDevation(){
        PageDeviation dev = new PageDeviation(page);
        dev.Deviation();
        System.out.println("Test completed");
    }
}
