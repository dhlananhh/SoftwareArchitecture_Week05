package iuh.fit.se.ui;

import java.util.ArrayList;
import java.util.List;

public class Window implements UIComponent {
	private String title;
    private List<UIComponent> components = new ArrayList<>();

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<UIComponent> getComponents() {
		return components;
	}

	public void setComponents(List<UIComponent> components) {
		this.components = components;
	}

	public Window(String title) {
        this.title = title;
    }

    public void addComponent(UIComponent component) {
        components.add(component);
    }

    public void removeComponent(UIComponent component) {
        components.remove(component);
    }

    public UIComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public void render() {
        System.out.println("Render Window: " + title);
        for (UIComponent component : components) {
            component.render();
        }
    }

    @Override
    public void onClick() {
        System.out.println("Window '" + title + "' clicked (handling click for its children).");
        for (UIComponent component : components) {
            component.onClick();
        }
    }
}
