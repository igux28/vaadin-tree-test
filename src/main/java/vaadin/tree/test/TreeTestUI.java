package vaadin.tree.test;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import vaadin.tree.test.component.tree.ModuleTreeMenu;
import vaadin.tree.test.jpa.DataProvider;
import vaadin.tree.test.jpa.WorkProjectModule;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class TreeTestUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        
        ModuleTreeMenu moduleTreeMenu = new ModuleTreeMenu();
        
        layout.addComponents( moduleTreeMenu);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "TreeTestUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = TreeTestUI.class, productionMode = false)
    public static class TreeTestUIServlet extends VaadinServlet {
    }
}
