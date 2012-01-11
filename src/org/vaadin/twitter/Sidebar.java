package org.vaadin.twitter;

import com.vaadin.ui.VerticalLayout;

public class Sidebar extends VerticalLayout {

    private SidebarList favoritesList;
    private SidebarList historyList;

    public Sidebar() {
        favoritesList = new SidebarList("Favorites");
        addComponent(favoritesList);

        historyList = new SidebarList("History");
        addComponent(historyList);
    }

    public void addToHistory(String searchTerm) {
        historyList.addToList(searchTerm);
    }

    public void addToFavorites(String searchTerm) {
        favoritesList.addToList(searchTerm);
    }

}
