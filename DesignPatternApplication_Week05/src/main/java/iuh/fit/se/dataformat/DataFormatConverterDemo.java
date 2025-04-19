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
}
