package iuh.fit.se.dataformat;

public interface JsonDataConverter {
	String toJson(XmlData xmlData);
    XmlData toXml(JsonData jsonData);
}
