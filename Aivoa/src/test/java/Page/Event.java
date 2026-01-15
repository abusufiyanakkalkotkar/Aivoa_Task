package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import java.util.regex.Pattern;

public class Event {
    private Page page;

    public Event(Page page){
        this.page = page;
    }

    public void Eventinfo(){
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
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Short Description *")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Short Description *")).fill("Testing automated incident report");
        page.getByLabel("Preliminary Criticality*").selectOption("Major - Escalate to Management");
        page.getByLabel("Source of Event*").selectOption("Quality Control (Lab)");
        page.getByLabel("Department Owner*").selectOption("Quality Assurance");
        page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Potential Product Impact?")).check();
        page.locator(".w-4.h-4.rounded.border").first().click();
        page.locator(".w-4.h-4.rounded.border.flex.items-center.justify-center.transition-all.duration-200.bg-white").first().click();
        page.locator(".w-4.h-4.rounded.border.flex.items-center.justify-center.transition-all.duration-200.bg-white").first().click();
        page.locator(".w-4.h-4.rounded.border.flex.items-center.justify-center.transition-all.duration-200.bg-white").first().click();
        page.locator(".w-4.h-4.rounded.border.flex.items-center.justify-center.transition-all.duration-200.bg-white").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Affected Items")).click();
        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Add New Entry")).getByRole(AriaRole.COMBOBOX).selectOption("Material / Batch");
        page.getByRole(AriaRole.TEXTBOX).nth(5).click();
        page.getByRole(AriaRole.TEXTBOX).nth(5).fill("Abz");
        page.locator("input[type=\"text\"]").nth(5).click();
        page.locator("input[type=\"text\"]").nth(5).fill("ABT024");
        page.locator(".p-6 > div:nth-child(4) > div > .relative > .block").click();
        page.locator(".p-6 > div:nth-child(4) > div > .relative > .block").fill("Open");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Entry")).click();
        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Yes - Limited to items above")).check();
        page.getByRole(AriaRole.PARAGRAPH).nth(1).click();
        page.locator(".tiptap").first().fill("Automatic test entry for system verification. ");
        page.getByRole(AriaRole.PARAGRAPH).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$"))).click();
        page.locator(".tiptap.ProseMirror.prose.prose-sm.max-w-none.p-3.text-slate-800.dark\\:text-slate-100.focus\\:outline-none.min-h-\\[120px\\].ProseMirror-focused").fill("Material moved to quarantine. ");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close AI Assistant")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit for Triage")).click();
    }
}
