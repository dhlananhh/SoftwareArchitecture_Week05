package iuh.fit.se.ui;

public class Button implements UIComponent {
	private String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public void render() {
        System.out.println("Render Button: " + label);
    }

    @Override
    public void onClick() {
        System.out.println("Button '" + label + "' clicked.");
    }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
    
}
