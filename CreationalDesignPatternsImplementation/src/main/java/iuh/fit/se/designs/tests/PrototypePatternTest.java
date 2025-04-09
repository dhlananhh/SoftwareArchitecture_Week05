package iuh.fit.se.designs.tests;
import iuh.fit.se.designs.PrototypePattern.Employees;
import java.util.List;

public class PrototypePatternTest {
	public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");

        List<String> list1 = empsNew1.getEmpList();
        list1.remove("David");

        System.out.println("Emps List: "+emps.getEmpList());
        System.out.println("EmpsNew List: "+list);
        System.out.println("EmpsNew1 List: "+list1);
    }
}
