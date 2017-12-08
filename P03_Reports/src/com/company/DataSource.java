package com.company;
import java.sql.*;

public class DataSource {

    /**
     *
     * @throws SQLException
     */
    public DataSource() throws SQLException {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String user, pass, query;
        user = "DTURNER36";
        pass = "Turner12";
        query = "select empLastName, empFirstName from employee order by empLastName, empLastName";
        try {

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2",  user, pass);

            Reports report = new Reports(conn);
            conn.close();
        }
        catch (SQLException e){System.out.println ("Could not load the db" + e);
        }
    }


}
