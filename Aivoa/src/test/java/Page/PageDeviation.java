package Page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PageDeviation {
    private Page page;

    public PageDeviation(Page page) {
        this.page = page;
    }

    public void Deviation(){
        redirect();
    }

    public void redirect(){
        page.navigate("http://216.48.184.249:5289/login");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@company.com")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@company.com")).fill("testing@aivoa.net");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("••••••••")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("••••••••")).fill("password123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In to Workspace")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Quality Command")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log Event")).click();
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Deviation")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();

    }
}
