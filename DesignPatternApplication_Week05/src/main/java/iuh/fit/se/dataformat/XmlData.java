package iuh.fit.se.dataformat;

public class XmlData {
	private String data;

    public XmlData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "XmlData{" +
               "data='" + data + '\'' +
               '}';
    }
}
