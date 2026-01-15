package Test;

import Base.BaseTest;
import Page.EventDraft;
import org.testng.annotations.Test;

public class DraftEvent extends BaseTest {
    @Test
    public void Draft(){
        EventDraft draft = new EventDraft(page);
        draft.Draft();
        System.out.println("Test completed");

    }

}
