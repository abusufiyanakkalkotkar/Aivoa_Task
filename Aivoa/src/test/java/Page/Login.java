package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Login {
    private final Page page;

    public Login(Page page) {
        this.page = page;
    }

    public void LoginPage() {
        page.navigate("http://216.48.184.249:5289/login");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@company.com")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@company.com")).fill("testing@aivoa.net");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("••••••••")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("••••••••")).fill("password123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In to Workspace")).click();

    }
}