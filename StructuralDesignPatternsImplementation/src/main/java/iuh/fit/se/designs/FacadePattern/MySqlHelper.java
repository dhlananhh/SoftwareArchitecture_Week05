package iuh.fit.se.designs.FacadePattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class MySqlHelper {
    public static Connection getMySqlDBConnection() {
        Connection connection = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/employee_db", "root", "cuchuoi123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void generateMySqlPDFReport(String tableName, Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            Document document = new Document();
            String filePath = "src/main/resources/" + tableName + "_MySql_Report.pdf";
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            while (rs.next()) {
                document.add(new Paragraph(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3)));
            }
            document.close();
            System.out.println("MySQL PDF Report generated successfully at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateMySqlHTMLReport(String tableName, Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            StringBuilder htmlStringBuilder = new StringBuilder();
            htmlStringBuilder.append("<!DOCTYPE html>");
            htmlStringBuilder.append("<html><head><title>").append(tableName).append(" Report</title></head><body>");
            htmlStringBuilder.append("<h1>").append(tableName).append(" Report</h1>");
            htmlStringBuilder.append("<table border='1'>");
            htmlStringBuilder.append("<tr><th>ID</th><th>Name</th><th>Position</th><th>Salary</th></tr>");
            while (rs.next()) {
                htmlStringBuilder.append("<tr><td>").append(rs.getString(1)).append("</td><td>")
                        .append(rs.getString(2)).append("</td><td>").append(rs.getString(3)).append("</td><td>")
                        .append(rs.getString(4)).append("</td></tr>");
            }
            htmlStringBuilder.append("</table></body></html>");
            String filePath = "src/main/resources/" + tableName + "_MySql_Report.html";
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8")) {
                writer.write(htmlStringBuilder.toString());
            }
            System.out.println("MySQL HTML Report generated successfully at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
