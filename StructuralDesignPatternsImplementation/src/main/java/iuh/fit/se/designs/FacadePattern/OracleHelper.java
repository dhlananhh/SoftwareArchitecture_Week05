package iuh.fit.se.designs.FacadePattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class OracleHelper {
    public static Connection getOracleDBConnection() {
        Connection connection = null;
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establish the connection
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:yourdatabase", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void generateOraclePDFReport(String tableName, Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            Document document = new Document();
            String filePath = "src/main/resources/pdf-files/" + tableName + "_Oracle_Report.pdf";
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Create directories if they do not exist
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            while (rs.next()) {
                document.add(new Paragraph(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3)));
            }
            document.close();
            System.out.println("Oracle PDF Report generated successfully at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateOracleHTMLReport(String tableName, Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            StringBuilder htmlStringBuilder = new StringBuilder();
            htmlStringBuilder.append("<html><body><table border='1'>");
            while (rs.next()) {
                htmlStringBuilder.append("<tr><td>").append(rs.getString(1)).append("</td><td>")
                        .append(rs.getString(2)).append("</td><td>").append(rs.getString(3)).append("</td></tr>");
            }
            htmlStringBuilder.append("</table></body></html>");
            String filePath = "src/main/resources/pdf-files/" + tableName + "_Oracle_Report.html";
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Create directories if they do not exist
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(htmlStringBuilder.toString().getBytes());
            fileOutputStream.close();
            System.out.println("Oracle HTML Report generated successfully at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
