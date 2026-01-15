package Test;

import Base.BaseTest;
import Page.Event;
import Page.PageDeviation;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

public class EventTest extends BaseTest {
    @Test
    public void EventProgress(){
        Event event = new Event(page);
        event.Eventinfo();
        System.out.println("Test completed");
    }
}
