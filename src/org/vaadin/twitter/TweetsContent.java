package org.vaadin.twitter;

import org.vaadin.twitter.TwitterSearch.Tweet;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class TweetsContent extends CssLayout {

    private SearchBar searchBar;

    private Panel tweetsContent;

    public TweetsContent() {
        searchBar = new SearchBar();
        addComponent(searchBar);

        tweetsContent = new Panel();
        tweetsContent.setSizeFull();
        ((VerticalLayout) tweetsContent.getContent()).setSpacing(true);
        addComponent(tweetsContent);

    }

    public void setSearchResult(final TwitterSearch result) {
        searchBar.updateSearchHeader(result.getQueryString());

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