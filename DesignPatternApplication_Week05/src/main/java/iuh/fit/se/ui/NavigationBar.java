package iuh.fit.se.ui;

import java.util.List;

public class NavigationBar implements UIComponent {
	private List<String> items;

    public NavigationBar(List<String> items) {
        this.items = items;
    }

    @Override
    public void render() {
        System.out.println("Render Navigation Bar with items: " + items);
    }

    @Override
    public void onClick() {
        System.out.println("Navigation Bar interacted with.");
    }
}
