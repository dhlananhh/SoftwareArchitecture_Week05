package iuh.fit.se.ui;

import java.util.ArrayList;
import java.util.List;

public class Panel implements UIComponent {
	private String name;
    private List<UIComponent> components = new ArrayList<>();

    public Panel(String name) {
        this.name = name;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UIComponent> getComponents() {
		return components;
	}

	public void setComponents(List<UIComponent> components) {
		this.components = components;
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
        System.out.println("Render Panel: " + name);
        for (UIComponent component : components) {
            component.render();
        }
    }

	@Override
	public void onClick() {
		System.out.println("Panel '" + name + "' clicked (handling click for its children).");
        for (UIComponent component : components) {
            component.onClick();
        }
	}
}
