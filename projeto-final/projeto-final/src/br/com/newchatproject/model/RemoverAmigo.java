package br.com.newchatproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoverAmigo {
  private final static String DELETE_SEGUIDOR_QUERY = "DELETE FROM amizade WHERE id_usuario_principal = ? AND id_usuario_amigo = ?";

  public void desfazerAmizade(int id_usuario_principal, int id_usuario_amigo) {
    try {
      Connection conn = ConexaoElephantSQL.connect();
      PreparedStatement pstmt = conn.prepareStatement(DELETE_SEGUIDOR_QUERY);
      pstmt.setInt(1, id_usuario_principal);
      pstmt.setInt(2, id_usuario_amigo);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      ConexaoElephantSQL.printSQLException(e);
    } finally {
      ConexaoElephantSQL.disconnect();
    }
  }
}
