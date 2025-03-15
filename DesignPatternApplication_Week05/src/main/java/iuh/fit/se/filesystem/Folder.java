package iuh.fit.se.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {
	private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        this.children.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        this.children.remove(component);
    }

    @Override
    public void displayInfo() {
        System.out.println("Folder: " + name);
        System.out.println("Chứa các thành phần:");
        for (FileSystemComponent component : children) {
            component.displayInfo(); // Gọi đệ quy displayInfo() trên các thành phần con
        }
    }
}
