package iuh.fit.se.library;

public abstract class Book {
    private String title;
    private String author;
    private String genre; 
    private boolean isBorrowed; 

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isBorrowed = false; 
    }

    public abstract String getBookType(); 

    public void displayBookInfo() {
        System.out.println(
    		"Tiêu đề: " + title + "\nTác giả: " + author + "\nThể loại: " + genre + 
    		"\nLoại sách: " + getBookType() + "\nTình trạng: " + (isBorrowed ? "Đang mượn" : "Có sẵn")
		);
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
    
    
}
