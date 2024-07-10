
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.SQLException;

/**
 *
 * @author bielzinho
 */
public class UsuariosDAO {

    public static final String LOGIN = "SELECT * from usuarios where nome = ? and senha = MD5(?)";
    public static final String CADASTRO = "INSERT INTO usuarios (nome, senha) VALUES (?,MD5(?))";
    public static final String CONTAGEM = "SELECT * from usuarios";

    public static model.Usuarios login(model.Usuarios usu) throws SQLException, ClassNotFoundException {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        java.sql.ResultSet rs = null;

        con = util.ConexaoBanco.getConexao();
        pstmt = con.prepareStatement(LOGIN);
        pstmt.setString(1, usu.getNome());
        pstmt.setString(2, usu.getSenha());

        rs = pstmt.executeQuery();
        model.Usuarios usuario = new model.Usuarios();
        if (rs.next()) {
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
        }
        return usuario;
    }

    public static boolean cadastro(model.Usuarios usu) throws SQLException, ClassNotFoundException {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        boolean retorno = false;

        con = util.ConexaoBanco.getConexao();
        pstmt = con.prepareStatement(CADASTRO);
        pstmt.setString(1, usu.getNome());
        pstmt.setString(2, usu.getSenha());
        pstmt.execute();
        util.ConexaoBanco.fechaConexao(con, pstmt);
        return retorno;
    }

    public static int contagem() {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        java.sql.ResultSet rs = null;
        int numero = 0;
        try {
            con = util.ConexaoBanco.getConexao();
            pstmt = con.prepareStatement(CONTAGEM);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                numero++;
            }
        } catch (ClassNotFoundException | SQLException err) {
            throw new RuntimeException(err);
        }
        return numero;
    }
}
