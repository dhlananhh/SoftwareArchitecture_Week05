package iuh.fit.se.ui;

public class Dialog implements UIComponent {
	private String title;

    public Dialog(String title) {
        this.title = title;
    }

    @Override
    public void render() {
        System.out.println("Render Dialog: " + title);
    }

    @Override
    public void onClick() {
        System.out.println("Dialog '" + title + "' shown.");
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
}
