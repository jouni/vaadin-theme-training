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

    private HorizontalLayout resultsLayout;
    private Label searchResultLabel;
    private Button addToFav;
    private Panel tweetsContent;
    
    private String result;

    public TweetsContent() {
        searchBar = new SearchBar();
        addComponent(searchBar);
        
        CssLayout wrapper = new CssLayout();
        wrapper.setSizeFull();
        wrapper.addStyleName("panel");
        wrapper.addStyleName("tweets");
        addComponent(wrapper);
        
        resultsLayout = new HorizontalLayout();
        wrapper.addComponent(resultsLayout);
        
        searchResultLabel = new Label();

        addToFav = new Button("Add to favorites", new ClickListener() {
            public void buttonClick(ClickEvent event) {
                ((TwitterApplication) getApplication()).addToFav(result);
            }
        });

        resultsLayout.addComponent(searchResultLabel);
        resultsLayout.addComponent(addToFav);
        resultsLayout.setVisible(false);

        tweetsContent = new Panel();
        tweetsContent.setSizeFull();
        ((VerticalLayout) tweetsContent.getContent()).setSpacing(true);
        wrapper.addComponent(tweetsContent);

    }

    public void setSearchResult(final TwitterSearch result) {
    	this.result = result.getQueryString();
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