package iuh.fit.se.filesystem;

public class FileSystemDemo {

	public static void main(String[] args) {
		Folder rootFolder = new Folder("Root");
        Folder documentsFolder = new Folder("Documents");
        Folder picturesFolder = new Folder("Pictures");

        File file1 = new File("document1.docx", 500);
        File file2 = new File("image1.jpg", 200);
        File file3 = new File("image2.png", 300);

        documentsFolder.addComponent(file1);
        picturesFolder.addComponent(file2);
        picturesFolder.addComponent(file3);

        rootFolder.addComponent(documentsFolder);
        rootFolder.addComponent(picturesFolder);

        rootFolder.displayInfo();
	}

}
