package org.vaadin.twitter;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

public class Sidebar extends CssLayout {

	private static final long serialVersionUID = -1458716135182528943L;
	private SidebarList favoritesList;
    private SidebarList historyList;

    public Sidebar() {
    	
    	Label logo = new Label("Kieppi");
    	logo.setStyleName("logo");
    	addComponent(logo);
    	
    	CssLayout panelWrap = new CssLayout();
    	panelWrap.addStyleName("panel");
    	panelWrap.addStyleName("sidebar");
    	
        favoritesList = new SidebarList("Favorites");
        panelWrap.addComponent(favoritesList);

        historyList = new SidebarList("History");
        panelWrap.addComponent(historyList);
        
        addComponent(panelWrap);
    }

    public void addToHistory(String searchTerm) {
        historyList.addToList(searchTerm);
    }

    public void addToFavorites(String searchTerm) {
        favoritesList.addToList(searchTerm);
    }

}
