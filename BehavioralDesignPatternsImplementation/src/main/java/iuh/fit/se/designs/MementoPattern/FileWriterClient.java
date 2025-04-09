package iuh.fit.se.designs.MementoPattern;

public class FileWriterClient {
	public static void main(String[] args) {
		FileWriterCaretaker caretaker = new FileWriterCaretaker();

        FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
        fileWriter.write("First Set of Data\n");
        System.out.println(fileWriter+"\n\n");

        // Lưu trạng thái hiện tại
        caretaker.save(fileWriter);
        // Bây giờ viết thêm dữ liệu
        fileWriter.write("Second Set of Data\n");

        // Kiểm tra nội dung hiện tại
        System.out.println(fileWriter+"\n\n");

        // Khôi phục về trạng thái đã lưu trước đó
        caretaker.undo(fileWriter);

        // Kiểm tra lại nội dung sau khi khôi phục
        System.out.println(fileWriter+"\n\n");
	}
}
