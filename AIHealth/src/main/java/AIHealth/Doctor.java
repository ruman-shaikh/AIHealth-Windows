package AIHealth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor extends Person{
    String did;
    String institute_id, specialization, institute_name;
    int patCount;
    
    Doctor(String un) {
        super(un);
        getDID(usrName);
        patCount=0;
        System.out.println("DID: " + did);
    }
    
    void getDID(String usrName) {
	Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aihealth","root","1440"); 
            if (con != null) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from doctor_log where use_name='" + usrName + "';");
                if (rs.next()) {
                    did = rs.getString(1);
                }
            }
            else
                System.out.println("Connection Error");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    void getInfo() {
	Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aihealth","root","1440"); 
            if (con != null) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from doctor where did=" + did + ";");
                if (rs.next()) {
                    lname = rs.getString(2);
                    fname = rs.getString(3);
                    address = rs.getString(4);
                    age = rs.getString(5);
                    specialization = rs.getString(6);
                    ph_no = rs.getString(7);
                    institute_id = rs.getString(8);
                }
                Statement stmt3 = con.createStatement();
                ResultSet rs3 = stmt3.executeQuery("select name from institute where (select institute_id from doctor where did=" + did + ")=iid;");
                if(rs3.next()) {
                    institute_name = rs3.getString(1);
                }
            }
            else
                System.out.println("Connection Error");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    String[][] PatientList() {
        Connection con;
        String[][] errStr = new String[100][100];
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aihealth","root","1440"); 
                if (con != null) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select count(did) from doc_pat where did=" + did + ";");
                    if (rs.next()) {
                        patCount = Integer.parseInt(rs.getString(1));
                    }
                    Statement stmt2 = con.createStatement();
                    ResultSet rs2 = stmt2.executeQuery("select pid from doc_pat where did=" + did + ";");
                    String[] patList = new String[patCount];
                    for (int i=0;i<patCount;i++) {
                        rs2.next();
                        patList[i] = rs2.getString(1);
                    }
                    String patDetails[][] = new String[patCount][5];
                    for(int k=0;k<patCount;k++) {
                        Statement stmt3 = con.createStatement();
                        ResultSet rs3 = stmt3.executeQuery("select * from patient where pid=" + patList[k] + ";");
                        rs3.next();
                        patDetails[k][0] = rs3.getString(2);
                        patDetails[k][1] = rs3.getString(3);
                        patDetails[k][2] = rs3.getString(4);
                        patDetails[k][3] = rs3.getString(5);
                        patDetails[k][4] = rs3.getString(6);
                    }
                    for(int k=0;k<patCount;k++) {
                        System.out.println(patDetails[k][0] + " " + patDetails[k][1] + " " + patDetails[k][2] + " " + patDetails[k][3] + " " + patDetails[k][4]);
                    }
                    errStr = patDetails;
                    return patDetails;
                }
                else
                    System.out.println("Connection Error");
            }
            catch(Exception e) {
                System.out.println(e);
            }
            return errStr;
    }
    
    void displayData(){
        System.out.println("DID: " + did);
        System.out.println("Name: " + fname + " " + lname);
        System.out.println("Age: " + age + "\nAddress: " + address);
        System.out.println("Phone Number: " + ph_no);
        System.out.println("Specialization: " + specialization);
        System.out.println("Institute ID: " + institute_id);
        System.out.println("Institute Name: " + institute_name);
    }
}
