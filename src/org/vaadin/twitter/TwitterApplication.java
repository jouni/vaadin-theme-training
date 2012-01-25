package org.vaadin.twitter;

import com.vaadin.Application;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

public class TwitterApplication extends Application {

	private static final long serialVersionUID = 1874601784886118816L;
	private TweetsContent tweetsContent;
    private Sidebar sidebar;

    @Override
    public void init() {
        setTheme("twitter");
        CssLayout mainLayout = new CssLayout();
        mainLayout.setSizeFull();
        mainLayout.addStyleName("main-layout");
        Window mainWindow = new Window("Twitter search", mainLayout);
        setMainWindow(mainWindow);

        sidebar = new Sidebar();
        sidebar.setWidth("200px");
        tweetsContent = new TweetsContent();
        tweetsContent.setSizeFull();
        tweetsContent.addStyleName("content");

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
