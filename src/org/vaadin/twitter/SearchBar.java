package org.vaadin.twitter;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class SearchBar extends CssLayout {

    private TextField search;
    private Button doSearch;

    public SearchBar() {
    	addStyleName("panel");
    	addStyleName("search-bar");
        search = new TextField();
        doSearch = new Button("Search");
        doSearch.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                ((TwitterApplication) getApplication()).doSearch(""
                        + search.getValue());
            }
        });

        doSearch.setClickShortcut(KeyCode.ENTER);
        addComponent(search);
        addComponent(doSearch);

    }

    public void updateSearchHeader(String result) {
        search.setValue(result.trim());
    }

}
