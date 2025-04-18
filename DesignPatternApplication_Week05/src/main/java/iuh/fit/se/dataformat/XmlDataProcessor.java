package iuh.fit.se.dataformat;

public class XmlDataProcessor {
	public String processXml(XmlData xmlData) {
        System.out.println("Processing XML data: " + xmlData.getData());
        // Thực hiện xử lý XML thực tế ở đây
        return "<xml><data>" + xmlData.getData() + "</data></xml>";
    }

    public XmlData parseXml(String xmlString) {
        System.out.println("Parsing XML string: " + xmlString);
        // Thực hiện phân tích XML thực tế ở đây
        String data = xmlString.replaceAll("<\\/?xml>|<\\/?data>", "");
        return new XmlData(data);
    }
}
