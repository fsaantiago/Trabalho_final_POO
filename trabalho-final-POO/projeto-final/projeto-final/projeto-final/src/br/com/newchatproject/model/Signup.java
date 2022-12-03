package br.com.newchatproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Signup extends Usuario {

    public Signup(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    

    public boolean verificaSenha(String confirmaSenha) {
        if (getSenha().equals(confirmaSenha)) {
            return true;
        } else {
            return false;
        }
    }// metodo para válidar senha

    public boolean verificaEmail(){
        boolean statusEmail = false; 

        try {

            Connection conn = ConexaoElephantSQL.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT email FROM usuario WHERE email = ?");
            pstmt.setString(1, getEmail());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                statusEmail = true;
            }
            
        } catch (SQLException e) {
            ConexaoElephantSQL.printSQLException(e);
        } finally {
            ConexaoElephantSQL.disconnect();
        }

        return statusEmail;
    }// metodo para verificar existencia de e-mail em uso

    public void insereUsuario() throws SQLException {
        try {
            Connection conn = ConexaoElephantSQL.connect();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)");
            pstmt.setString(1, getNome());
            pstmt.setString(2, getEmail());
            pstmt.setString(3, getSenha());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            ConexaoElephantSQL.printSQLException(e);
        } finally{
            ConexaoElephantSQL.disconnect();
        }
    }
}
