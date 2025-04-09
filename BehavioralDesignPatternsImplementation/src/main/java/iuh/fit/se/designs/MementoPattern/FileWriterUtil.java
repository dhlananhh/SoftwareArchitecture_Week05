package iuh.fit.se.designs.MementoPattern;

public class FileWriterUtil {
	private String fileName;
    private StringBuilder content;

    public FileWriterUtil(String file){
        this.fileName=file;
        this.content=new StringBuilder();
    }
    
    @Override
    public String toString(){
        return this.content.toString();
    }

    public void write(String str){
        content.append(str);
    }

    // Phương thức tạo một Memento để lưu trạng thái hiện tại
    public Memento save(){
        // Tạo một bản sao sâu (deep copy) của nội dung để đảm bảo tính độc lập
        return new Memento(this.fileName,new StringBuilder(this.content));
    }

    // Phương thức để khôi phục trạng thái từ một đối tượng Memento
    public void undoToLastSave(Object obj){
        Memento memento = (Memento) obj;
        this.fileName= memento.fileName;
        this.content=memento.content;
    }

    // Lớp bên trong Memento
    private class Memento{
        private String fileName;
        private StringBuilder content;

        // Constructor của Memento chỉ được gọi từ Originator
        public Memento(String file, StringBuilder content){
            this.fileName=file;
            // Lưu ý: tạo bản sao sâu để Memento và FileWriterUtil không tham chiếu cùng một đối tượng
            this.content=content;
        }
    }
}
