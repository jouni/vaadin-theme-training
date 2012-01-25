package org.vaadin.twitter;

import org.vaadin.twitter.TwitterSearch.Tweet;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class TweetsContent extends CssLayout {

    private SearchBar searchBar;

    private Panel tweetsContent;
    
    private Label searchResultLabel;
    private Button addToFav;
    private HorizontalLayout resultsLayout;
    private String result;

    public TweetsContent() {
    	addStyleName("content");
    	
        searchBar = new SearchBar();
        addComponent(searchBar);

        
        
        tweetsContent = new Panel();
        tweetsContent.setSizeFull();
        ((VerticalLayout) tweetsContent.getContent()).setSpacing(true);
        addComponent(tweetsContent);

        resultsLayout = new HorizontalLayout();

        
        addComponent(resultsLayout);

        searchResultLabel = new Label();

        addToFav = new Button("Add to favorites", new ClickListener() {
            public void buttonClick(ClickEvent event) {
                ((TwitterApplication) getApplication()).addToFav(result);
            }
        });

        resultsLayout.addComponent(searchResultLabel);
        resultsLayout.addComponent(addToFav);
        resultsLayout.setVisible(false);
    }

    public void setSearchResult(final TwitterSearch result) {
        searchBar.updateSearchHeader(result.getQueryString());

        resultsLayout.setVisible(true);
        searchResultLabel.setValue("Results for " + result.getQueryString().trim());
        
        tweetsContent.removeAllComponents();
        for (Tweet tweet : result.latest()) {
            TweetLayout tweetlayout = new TweetLayout(tweet);
            tweetsContent.addComponent(tweetlayout);
        }

        Button moreButton = new Button("More", new ClickListener() {
            public void buttonClick(ClickEvent event) {
                for (Tweet tweet : result.more()) {
                    TweetLayout tweetlayout = new TweetLayout(tweet);
                    tweetsContent.addComponent(tweetlayout);
                }
            }
        });
        tweetsContent.addComponent(moreButton);
    }
}