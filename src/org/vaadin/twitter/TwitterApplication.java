package org.vaadin.twitter;

import javax.sql.rowset.serial.SerialArray;

import com.vaadin.Application;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class TwitterApplication extends Application {

    private TweetsContent tweetsContent;
    private Sidebar sidebar;
	private SearchBar searchBar;

    @Override
    public void init() {
        setTheme("twitter");
        CssLayout mainLayout = new CssLayout();
        
        Label logo = new Label("Kieppi");
        logo.addStyleName("logo");
        mainLayout.addComponent(logo);
        logo.setSizeUndefined();
        
        mainLayout.addStyleName("main");
        mainLayout.setSizeFull();
        Window mainWindow = new Window("Twitter search", mainLayout);
        setMainWindow(mainWindow);

        sidebar = new Sidebar();
        sidebar.addStyleName("sidebar");
        sidebar.addStyleName("panel");
        sidebar.setWidth("200px");
        
        searchBar = new SearchBar();
        searchBar.addStyleName("searchbar");
        searchBar.addStyleName("panel");
        
        tweetsContent = new TweetsContent();
        tweetsContent.addStyleName("tweets-content");
        tweetsContent.addStyleName("panel");
        tweetsContent.setSizeFull();

        mainLayout.addComponent(sidebar);
        mainLayout.addComponent(searchBar);        
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
