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
public class FavoritosDAO {
    public static final String SELECIONAR = "SELECT * FROM filmes inner join favoritos on favoritos.filmeid=filmes.id WHERE favoritos.userid = ?";
    public static final String INSERIR = "INSERT INTO favoritos (filmeid, userid) values (?,?)";
    public static final String DELETAR = "DELETE FROM FAVORITOS WHERE filmeid = ? and userid = ?";
    public static boolean inserirFilme(model.Favoritos favorito) throws ClassNotFoundException, SQLException {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        boolean retorno = false;
            con = util.ConexaoBanco.getConexao();
            pstmt = con.prepareStatement(INSERIR);
            pstmt.setInt(1, favorito.getFilmeid());
            pstmt.setInt(2, favorito.getUserid());
            pstmt.execute();
            util.ConexaoBanco.fechaConexao(con, pstmt);
        return retorno;
    }
    
        public static boolean deletarFilme(model.Favoritos favorito) throws ClassNotFoundException, SQLException {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        boolean retorno = false;
            con = util.ConexaoBanco.getConexao();
            pstmt = con.prepareStatement(DELETAR);
            pstmt.setInt(1, favorito.getFilmeid());
            pstmt.setInt(2, favorito.getUserid());
            pstmt.execute();
            util.ConexaoBanco.fechaConexao(con, pstmt);
        return retorno;
    }
    
        public static java.util.List<model.Filmes> listarFavoritos(model.Usuarios usu) throws SQLException {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        java.sql.ResultSet rs = null;
        java.util.List<model.Filmes> retorno = new java.util.ArrayList<>();

        try {
            con = util.ConexaoBanco.getConexao();
            pstmt = con.prepareStatement(SELECIONAR);
            pstmt.setInt(1, usu.getId());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                model.Filmes filme = new model.Filmes();
                filme.setId(rs.getInt("id"));
                filme.setNome(rs.getString("nome"));
                filme.setAno_lancamento(rs.getInt("ano_lancamento"));
                filme.setBilheteria(rs.getInt("bilheteria"));
                filme.setNota(rs.getDouble("nota"));
                filme.setEstudio(rs.getString("estudio"));
                filme.setAtor_principal(rs.getString("ator_principal"));
                filme.setPais_lancamento(rs.getString("pais_origem"));
                filme.setOrcamento(rs.getDouble("orcamento"));
                filme.setDiretor(rs.getString("diretor"));
                retorno.add(filme);
            }
        } catch (ClassNotFoundException | SQLException err) {
            throw new RuntimeException(err);
        }
        return retorno;
    }
    
}
