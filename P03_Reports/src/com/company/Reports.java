package com.company;
import java.sql.*;

public class Reports {

    /**
     *
     * @param conn
     * @throws SQLException
     */
    public Reports(Connection conn) throws SQLException{
        System.out.println("Class/Student Detail:");
        classStudentDetail(conn);

        System.out.println("");
        System.out.println("Instructor Detail:");
        InstructorDetail(conn);

        System.out.println("");
        System.out.println("Student Detail:");
        StudentDetail(conn);
    }

    /**
     *
     * @param var
     * @throws SQLException
     */
    private void classStudentDetail(Connection var) throws SQLException
    {
        Statement stmt = var.createStatement ();
        ResultSet rset = stmt.executeQuery(("Select Student.First, Student.Last, Enroll.Class_Name from Student inner join Enroll on Student.SID = Enroll.SID where Student.SID = Enroll.SID  ORDER BY class_name, Last"));


        while(rset.next())
        {
            System.out.println("Class: " + rset.getString("Class_Name") + "      First: " + rset.getString("First") + "  Last: " + rset.getString("Last"));

        }
    }

    /**
     *
     * @param var
     * @throws SQLException
     */
    private void InstructorDetail(Connection var) throws SQLException
    {
        Statement stmt = var.createStatement ();
        ResultSet rset = stmt.executeQuery ("select * from Class inner join Instructor on Class.TID = Instructor.TID");

        while(rset.next())
        {
            System.out.println("Name: " + rset.getString("Fname") + "     " + rset.getString("Lname") + "     " +
                    "Class: " + rset.getString("Name") + "      Count: " + rset.getString("classCount"));
        }
    }


    /**
     *
     * @param var
     * @throws SQLException
     */
    private void StudentDetail(Connection var) throws SQLException
    {
        Statement stmt = var.createStatement ();
        ResultSet rset = stmt.executeQuery ("select * from Student inner join Enroll on Student.SID = Enroll.SID");

        while(rset.next())
        {
            System.out.println("Name: " + rset.getString("First") + "    " + rset.getString("Last") + "     Class: " + rset.getString("Class_Name") + "      Experience Level: " + rset.getString("Exp_Level"));
        }
    }

}
