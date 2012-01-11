package org.vaadin.twitter;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SidebarList extends VerticalLayout {

    Map<String, Button> searchButtons = new HashMap<String, Button>();
    Label captionLabel = new Label();

    public SidebarList(String caption) {
        captionLabel.setValue(caption);
        addComponent(captionLabel);
    }

    public void addToList(final String searchTerms) {
        if (searchButtons.containsKey(searchTerms)) {
            Button dumButton = searchButtons.get(searchTerms);
            removeComponent(dumButton);
            addComponent(dumButton, 1);
        } else {

            Button btn = new Button(searchTerms);
            btn.addListener(new Button.ClickListener() {

                public void buttonClick(ClickEvent event) {
                    ((TwitterApplication) getApplication())
                            .doSearch(searchTerms);
                }
            });

            searchButtons.put(searchTerms, btn);

            addComponent(btn, 1);
        }
    }

}
