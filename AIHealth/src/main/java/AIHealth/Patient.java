package AIHealth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Patient extends Person{
    
    String pid;
    String MedData[][] = new String[23][2];
    
    Patient(String un) {
        super(un);
        getPID();
        //System.out.println("PID: " + pid);
    }
    
    void getPID(){
        try {
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aihealth","root","1440"); 
            if (con != null) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from patient_log where use_name='" + usrName + "';");
                if (rs.next()) {
                    pid = rs.getString(1);
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
                ResultSet rs = stmt.executeQuery("select * from patient where pid=" + pid + ";");
                if (rs.next()) {
                    lname = rs.getString(2);
                    fname = rs.getString(3);
                    age = rs.getString(4);
                    ph_no = rs.getString(5);
                    address = rs.getString(6);
                }
            }
            else
                System.out.println("Connection Error");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    String[][] getMedData() {
        Connection con;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aihealth","root","1440"); 
                if (con != null) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from med_data where pid=" + pid + ";");
                    if(rs.next()) {
                        for(int i=0;i<23;i++){
                            MedData[i][1] = rs.getString(i+2);
                        }
                    }
                    Statement stmt1 = con.createStatement();
                    ResultSet rs1 = stmt1.executeQuery("desc med_data");
                    rs1.next();
                    for(int k=00;k<23;k++){
                        rs1.next();
                        MedData[k][0] = rs1.getString(1);
                    }
                }
                else
                    System.out.println("Connection Error");
            }
            catch(Exception e) {
                System.out.println(e);
            }
            /*for(int i=0;i<23;i++){
                for(int k=0;k<2;k++){
                    System.out.print(MedData[i][k]);
                    System.out.print(" ");
                }
                System.out.println("");
            }*/
            return MedData;
    }
    
    void displayData(){
        System.out.println("PID: " + pid);
        System.out.println("Name: " + fname + " " + lname);
        System.out.println("Age: " + age + "\nAddress: " + address);
        System.out.println("Phone Number: " + ph_no + "\n");
    }
    
}
