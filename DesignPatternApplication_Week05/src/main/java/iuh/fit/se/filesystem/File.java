package iuh.fit.se.filesystem;

public class File implements FileSystemComponent {
	private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("File: " + name + ", Kích thước: " + size + "KB");
    }
}
