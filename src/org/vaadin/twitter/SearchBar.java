package org.vaadin.twitter;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class SearchBar extends VerticalLayout {

    private TextField search;
    private Button doSearch;
    private Label searchResultLabel;
    private Button addToFav;
    private HorizontalLayout resultsLayout;
    private String result;

    public SearchBar() {
        search = new TextField();
        doSearch = new Button("Search");
        doSearch.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                ((TwitterApplication) getApplication()).doSearch(""
                        + search.getValue());
            }
        });

        doSearch.setClickShortcut(KeyCode.ENTER);
        HorizontalLayout fieldsLayout = new HorizontalLayout();
        fieldsLayout.addComponent(search);
        fieldsLayout.addComponent(doSearch);
        resultsLayout = new HorizontalLayout();

        addComponent(fieldsLayout);
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

    public void updateSearchHeader(String result) {
        this.result = result;
        resultsLayout.setVisible(true);
        searchResultLabel.setValue("Results for " + result.trim());
        search.setValue(result.trim());

    }

}
