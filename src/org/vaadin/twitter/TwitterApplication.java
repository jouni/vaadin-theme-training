package org.vaadin.twitter;

import com.vaadin.Application;
import com.vaadin.ui.Window;

public class TwitterApplication extends Application {

    @Override
    public void init() {
        setTheme("twitter");
        Window mainWindow = new Window("Twitter search");
        setMainWindow(mainWindow);
    }
}
