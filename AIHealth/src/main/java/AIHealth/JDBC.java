package AIHealth;
import java.sql.*;

public class JDBC {
    public int DoctorDBConnect(String usrName, String pwd) {
        int result = -1;
	Connection con;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aihealth","root","1440"); 
                if (con != null) {
                    String pwdDB = new String();
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from doctor_log where use_name='" + usrName + "';");
                    if (rs.next()) {
                        pwdDB = rs.getString(3);
                    }
                    if (pwd.equals(pwdDB) == true)
                        result = 1;
                    else if (pwd.equals(pwdDB) == false)
                        result = 0;
                }
                else
                    System.out.println("Connection Error");
            }
            catch(Exception e) {
                System.out.println(e);
            }
            return result;
    }
    
    public int PatientDBConnect(String usrName, String pwd) {
        int result = -1;
	Connection con;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aihealth","root","1440"); 
                if (con != null) {
                    String pwdDB = new String();
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from patient_log where use_name='" + usrName + "';");
                    if (rs.next()) {
                        pwdDB = rs.getString(3);
                    }
                    if (pwd.equals(pwdDB) == true)
                        result = 1;
                    else if (pwd.equals(pwdDB) == false)
                        result = 0;
                }
                else
                    System.out.println("Connection Error");
            }
            catch(Exception e) {
                System.out.println(e);
            }
            return result;
    }
    
    public String[][] PatientList(String UsrName) {
        Connection con;
        String countStr = new String();
        String[][] errStr = new String[100][100];
        String UsrID = "0";
        System.out.println("UsrName: " + UsrName);
        int countPat=0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aihealth","root","1440"); 
                if (con != null) {
                    Statement stmt0 = con.createStatement();
                    ResultSet rs0 = stmt0.executeQuery("select * from doctor_log where use_name='" + UsrName + "';");
                    if (rs0.next()) {
                        UsrID = rs0.getString(1);
                    }
                    System.out.println("UserID: " + UsrID);
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select count(did) from doc_pat where did=" + UsrID + ";");
                    if (rs.next()) {
                        countStr = rs.getString(1);
                    }
                    System.out.println("No. of patients: " + countStr);
                    countPat = Integer.parseInt(countStr);
                    Statement stmt2 = con.createStatement();
                    ResultSet rs2 = stmt2.executeQuery("select pid from doc_pat where did=" + UsrID + ";");
                    String[] patList = new String[countPat];
                    for (int i=0;i<countPat;i++) {
                        rs2.next();
                        patList[i] = rs2.getString(1);
                    }
                    String patDetails[][] = new String[countPat][5];
                    for(int k=0;k<countPat;k++) {
                        //System.out.println(patList[k]);
                        Statement stmt3 = con.createStatement();
                        ResultSet rs3 = stmt3.executeQuery("select * from patient where pid=" + patList[k] + ";");
                        rs3.next();
                        patDetails[k][0] = rs3.getString(2);
                        patDetails[k][1] = rs3.getString(3);
                        patDetails[k][2] = rs3.getString(4);
                        patDetails[k][3] = rs3.getString(5);
                        patDetails[k][4] = rs3.getString(6);
                    }
                    for(int k=0;k<countPat;k++) {
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
}