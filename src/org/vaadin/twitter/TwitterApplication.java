package org.vaadin.twitter;

import com.vaadin.Application;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class TwitterApplication extends Application {

    private TweetsContent tweetsContent;
    private Sidebar sidebar;

    @Override
    public void init() {
        setTheme("twitter");
        CssLayout mainLayout = new CssLayout();
        mainLayout.setStyleName("main-layout");
        mainLayout.setHeight("100%");
        Window mainWindow = new Window("Twitter search", mainLayout);
        setMainWindow(mainWindow);

        sidebar = new Sidebar();
        sidebar.setWidth("200px");
        tweetsContent = new TweetsContent();
        
        mainLayout.addComponent(sidebar);
        mainLayout.addComponent(tweetsContent);
    }

    public void doSearch(String searchTerms) {
        TwitterSearch tweets = new TwitterSearch(searchTerms);
        tweetsContent.setSearchResult(tweets);
        sidebar.addToHistory(searchTerms);

    }

    public void addToFav(String result) {
        // TODO Auto-generated method stub
        sidebar.addToFavorites(result);
    }
}
