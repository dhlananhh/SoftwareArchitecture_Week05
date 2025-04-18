package iuh.fit.se.ui;

import java.util.List;

public class UIStructureExample {

	public static void main(String[] args) {
		// Tạo các thành phần đơn lẻ
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");
        Dialog errorDialog = new Dialog("Error!");
        NavigationBar mainNav = new NavigationBar(List.of("Home", "Products", "Services"));

        // Tạo một panel và thêm các thành phần vào
        Panel buttonPanel = new Panel("Button Panel");
        buttonPanel.addComponent(submitButton);
        buttonPanel.addComponent(cancelButton);

        // Tạo một cửa sổ và thêm các thành phần vào
        Window mainWindow = new Window("Main Application");
        mainWindow.addComponent(mainNav);
        mainWindow.addComponent(buttonPanel);
        mainWindow.addComponent(errorDialog);

        // Render toàn bộ cấu trúc UI
        mainWindow.render();
        System.out.println("\nSimulating Clicks:");
        mainWindow.onClick();
        System.out.println("\nClicking on Button Panel:");
        buttonPanel.onClick();
        System.out.println("\nClicking on Submit Button:");
        submitButton.onClick();
	}

}
