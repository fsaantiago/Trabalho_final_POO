package br.com.newchatproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Signin extends Usuario {

    public Signin(String email, String senha) {
        super(email, senha);
    }
    
    private final static String LOGIN_QUERY = "SELECT id_usuario, email, TRIM(senha) AS senha FROM usuario WHERE email = ?";

    public boolean statusLog(){
        boolean logado = false;

        try {
            Connection conn = ConexaoElephantSQL.connect();
            PreparedStatement pstmt = conn.prepareStatement (LOGIN_QUERY);
            pstmt.setString(1,getEmail());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String senhaBD = rs.getString("senha");
                int idUsuario = rs.getInt("id_usuario");
                if (senhaBD.equals(getSenha())) {
                  setId(idUsuario);
                  logado = true;
                }
            }

        } catch (SQLException e) {
            ConexaoElephantSQL.printSQLException(e);
        } finally {
            ConexaoElephantSQL.disconnect();
        }   

        return logado;

    }


}
