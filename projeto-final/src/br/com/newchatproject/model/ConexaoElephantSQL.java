package br.com.newchatproject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoElephantSQL {
    
  private final static String url = "jdbc:postgresql://babar.db.elephantsql.com/cgjidhgv";
  private final static String user = "cgjidhgv";
  private final static String password = "u1aLathVuJK1bC9OexWPrij3AyLRC6zH";
  private static Connection conn = null;
  
  public static Connection connect() {
    try {
      conn = DriverManager.getConnection(url, user, password);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      return conn;
  }//fim da classe Conexao

  public static void disconnect() {
    try {
        conn.close();
      } catch (SQLException e) {
        printSQLException(e);
      }
  }// fim do metodo desconnect()

  public static void printSQLException(SQLException ex) {

        for (Throwable e : ex) {

            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}
