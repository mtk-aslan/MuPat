/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermupat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Muttaki, Patrik & Patrick
 */
/**
 * Dies ist unsere MySQL Klasse, welche uns später hilft, den Zugang zur
 * Datenbank zu gewähren.
 *
 */
public class MySQL {

    private Connection c;

    /**
     * In den folgenden Zeilen bereitet diese Klasse schonmal den Code vor, um
     * später in der "Server" Klasse eine Verbindung zur Datenbank aufzubauen.
     *
     */
    public MySQL(String db, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.gjt.mm.mysql.Driver");
        this.c = DriverManager.getConnection("jdbc:mysql://141.2.89.26:3306/" + db, user, password);
        //this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);

    }

    private PreparedStatement prepare(String sql, Object... p) throws SQLException {
        PreparedStatement s = this.c.prepareStatement(sql);
        for (int i = 0; i < p.length; i++) {
            s.setObject(i + 1, p[i]);
        }
        return s;
    }

    public ResultSet executeQuery(String sql, Object... p) throws SQLException {
        return prepare(sql, p).executeQuery();

    }

    public void execute(String sql, Object... p) throws SQLException {
        prepare(sql, p).execute();
    }

}
