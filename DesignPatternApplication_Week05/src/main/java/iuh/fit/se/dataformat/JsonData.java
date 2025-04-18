package iuh.fit.se.dataformat;

public class JsonData {
	private String data;

    public JsonData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "JsonData{" +
               "data='" + data + '\'' +
               '}';
    }
}
