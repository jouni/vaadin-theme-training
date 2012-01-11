package org.vaadin.twitter;

import org.vaadin.twitter.TwitterSearch.Tweet;

import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class TweetLayout extends HorizontalLayout {

    private Embedded image;
    private Label metadata;
    private Label name;
    private VerticalLayout labelsLayout;
    private HorizontalLayout metaLayout;
    private Label actualContent;

    public TweetLayout(Tweet tweet) {

        setMargin(true, false, true, false);

        image = new Embedded();
        image.setHeight("64px");
        image.setWidth("64px");

        metadata = new Label();
        name = new Label();
        metaLayout = new HorizontalLayout();
        metaLayout.setSpacing(true);

        addComponent(image);
        labelsLayout = new VerticalLayout();

        metaLayout.addComponent(name);
        metaLayout.addComponent(metadata);

        labelsLayout.addComponent(metaLayout);
        labelsLayout.setSpacing(true);

        actualContent = new Label();
        labelsLayout.addComponent(actualContent);
        addComponent(labelsLayout);

        name.setValue(tweet.getFromUser());
        metadata.setValue(tweet.getCreatedAt());
        actualContent.setValue(tweet.getText());
    }

}
