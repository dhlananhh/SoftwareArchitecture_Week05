package iuh.fit.se.dataformat;

public class XmlToJsonAdapter implements DataConverter {
	private XmlDataSystem xmlDataSystem; // Composition: chứa instance Adaptee

    public XmlToJsonAdapter(XmlDataSystem system) {
        this.xmlDataSystem = system;
    }

    @Override
    public String convertFormat(String xmlData) {
        System.out.println("Adapter: Chuyển đổi XML sang JSON...");
        String jsonData = xmlDataSystem.processXmlData(xmlData); // Gọi phương thức của Adaptee
        return jsonData; // Trả về dữ liệu đã chuyển đổi (dạng JSON mô phỏng)
    }
}
