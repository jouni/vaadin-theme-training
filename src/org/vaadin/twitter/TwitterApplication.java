package org.vaadin.twitter;

import com.vaadin.Application;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

public class TwitterApplication extends Application {

    private TweetsContent tweetsContent;
    private Sidebar sidebar;

    @Override
    public void init() {
        setTheme("twitter");
        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setSizeFull();
        Window mainWindow = new Window("Twitter search", mainLayout);
        setMainWindow(mainWindow);

        sidebar = new Sidebar();
        sidebar.setWidth("200px");
        tweetsContent = new TweetsContent();
        tweetsContent.setSizeFull();

        mainLayout.addComponent(sidebar);
        mainLayout.addComponent(tweetsContent);

        mainLayout.setExpandRatio(tweetsContent, 1.0f);
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
