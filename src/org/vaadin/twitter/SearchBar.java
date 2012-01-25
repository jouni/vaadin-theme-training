package org.vaadin.twitter;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class SearchBar extends CssLayout {

    private TextField search;
    private Button searchButton;
   

    public SearchBar() {
    	addStyleName("layout-panel");
    	addStyleName("search-bar");
    	
        search = new TextField();
        searchButton = new Button("Search");
        searchButton.setStyleName("search-button");
        searchButton.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                ((TwitterApplication) getApplication()).doSearch(""
                        + search.getValue());
            }
        });

        searchButton.setClickShortcut(KeyCode.ENTER);
        
        addComponent(searchButton);
        addComponent(search);
        
    }

    public void updateSearchHeader(String result) {
        
        search.setValue(result.trim());

    }

}
