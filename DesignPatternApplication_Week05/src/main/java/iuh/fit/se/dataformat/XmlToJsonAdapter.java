package iuh.fit.se.dataformat;

public class XmlToJsonAdapter implements JsonDataConverter {
	private XmlDataProcessor xmlProcessor;

    public XmlToJsonAdapter(XmlDataProcessor xmlProcessor) {
        this.xmlProcessor = xmlProcessor;
    }

    @Override
    public String toJson(XmlData xmlData) {
        System.out.println("Converting XML to JSON...");
        String processedXml = xmlProcessor.processXml(xmlData);
        // Thực hiện chuyển đổi từ chuỗi XML đã xử lý sang chuỗi JSON
        String jsonData = "{ \"data\": \"" + extractDataFromXmlString(processedXml) + "\" }";
        return jsonData;
    }

    private String extractDataFromXmlString(String xmlString) {
        return xmlString.replace("</xml>", "").replace("<xml>", "").replace("<data>", "").replace("</data>", "");
    }
    
    @Override
    public XmlData toXml(JsonData jsonData) {
        System.out.println("Converting JSON to XML...");
        String jsonDataContent =  jsonData.getData();
        // Thực hiện chuyển đổi từ chuỗi JSON sang chuỗi XML
        String xmlString = "<xml><data>" + jsonDataContent + "</data></xml>";
        return xmlProcessor.parseXml(xmlString);
    }
}
