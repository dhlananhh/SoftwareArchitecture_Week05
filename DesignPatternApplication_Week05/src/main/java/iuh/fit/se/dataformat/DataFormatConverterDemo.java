package iuh.fit.se.dataformat;

public class DataFormatConverterDemo {
	public static void main(String[] args) {
		XmlDataProcessor xmlProcessor = new XmlDataProcessor();
        JsonDataConverter adapter = new XmlToJsonAdapter(xmlProcessor);

        XmlData xmlInput = new XmlData("Sample XML Data");
        String jsonOutput = adapter.toJson(xmlInput);
        System.out.println("JSON Output: " + jsonOutput);
        System.out.println();

        JsonData jsonInput = new JsonData("Sample JSON Data");
        XmlData xmlOutput = adapter.toXml(jsonInput);
        System.out.println("XML Output: " + xmlOutput);
	}
	
	public void useJsonConverter(JsonDataConverter converter, String data) {
        if (data.startsWith("{")) {
            XmlData xmlData = converter.toXml(new JsonData(data.replaceAll("[{}\\s\"data:\"]", "")));
            System.out.println("Processed XML by converter: " + xmlData);
        } else if (data.startsWith("<")) {
            String jsonData = converter.toJson(new XmlData(data.replaceAll("[<>/xml\\sdata=]", "")));
            System.out.println("Processed JSON by converter: " + jsonData);
        } else {
            System.out.println("Invalid data format.");
        }
    }
}
