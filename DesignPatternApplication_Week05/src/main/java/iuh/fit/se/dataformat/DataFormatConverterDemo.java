package iuh.fit.se.dataformat;

public class DataFormatConverterDemo {
	public static void main(String[] args) {
		String xmlData = "<order><id>123</id><item>Laptop</item></order>"; 

        XmlDataSystem xmlSystem = new XmlDataSystem(); 
        DataConverter adapter = new XmlToJsonAdapter(xmlSystem); 
        String jsonData = adapter.convertFormat(xmlData); 

        System.out.println("Dữ liệu JSON đã chuyển đổi:");
        System.out.println(jsonData);
	}
}
