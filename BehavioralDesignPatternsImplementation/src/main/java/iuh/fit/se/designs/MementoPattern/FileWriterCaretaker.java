package iuh.fit.se.designs.MementoPattern;

public class FileWriterCaretaker {
	private Object obj; // Lưu trữ đối tượng Memento (không biết cấu trúc bên trong)

    // Phương thức để lưu trạng thái của Originator
    public void save(FileWriterUtil fileWriter){
        this.obj=fileWriter.save();
    }

    // Phương thức để khôi phục trạng thái của Originator về trạng thái đã lưu
    public void undo(FileWriterUtil fileWriter){
        fileWriter.undoToLastSave(obj);
    }
}
