/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.SQLException;

/**
 *
 * @author alunos
 */
public class FilmesDAO {

    public static final String SELECIONAR = "SELECT * FROM filmes";
    public static final String SELECIONAR_POR_ID = "SELECT * FROM filmes WHERE ID = ?";
    public static final String INSERIR = "INSERT INTO filmes (estudio, nome, nota, ano_lancamento, ator_principal, pais_origem, bilheteria, orcamento,diretor) VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String ATUALIZAR = "UPDATE filmes SET estudio = ?, nome = ?, nota = ?, ano_lancamento = ?, ator_principal = ?, pais_origem = ?, bilheteria = ?, orcamento = ?,diretor = ? WHERE ID = ?";
    public static final String EXCLUIR = "DELETE FROM filmes WHERE ID = ?";

    public static java.util.List<model.Filmes> listarFilmes() {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        java.sql.ResultSet rs = null;
        java.util.List<model.Filmes> retorno = new java.util.ArrayList<>();

        try {
            con = util.ConexaoBanco.getConexao();
            pstmt = con.prepareStatement(SELECIONAR);
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

    public static model.Filmes obterPorID(int id) throws SQLException, ClassNotFoundException {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        java.sql.ResultSet rs = null;

        con = util.ConexaoBanco.getConexao();
        pstmt = con.prepareStatement(SELECIONAR_POR_ID);
        pstmt.setInt(1, id);

        rs = pstmt.executeQuery();
        model.Filmes filme = new model.Filmes();
        if (rs.next()) {
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
        }
        return filme;
    }

    public static boolean inserirFilme(model.Filmes filme) throws ClassNotFoundException {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        boolean retorno = false;
        try {
            con = util.ConexaoBanco.getConexao();
            pstmt = con.prepareStatement(INSERIR);
            pstmt.setString(1, filme.getEstudio());
            pstmt.setString(2, filme.getNome());
            pstmt.setDouble(3, filme.getNota());
            pstmt.setInt(4, filme.getAno_lancamento());
            pstmt.setString(5, filme.getAtor_principal());
            pstmt.setString(6, filme.getPais_lancamento());
            pstmt.setDouble(7, filme.getBilheteria());
            pstmt.setDouble(8, filme.getOrcamento());
            pstmt.setString(9, filme.getDiretor());
            pstmt.execute();
            util.ConexaoBanco.fechaConexao(con, pstmt);
        } catch (java.sql.SQLException err) {
            throw new RuntimeException(err);
        }
        return retorno;
    }
        public static boolean atualizarFilme(model.Filmes filme) throws ClassNotFoundException {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        boolean retorno = false;
        try {
            con = util.ConexaoBanco.getConexao();
            pstmt = con.prepareStatement(ATUALIZAR);
            pstmt.setString(1, filme.getEstudio());
            pstmt.setString(2, filme.getNome());
            pstmt.setDouble(3, filme.getNota());
            pstmt.setInt(4, filme.getAno_lancamento());
            pstmt.setString(5, filme.getAtor_principal());
            pstmt.setString(6, filme.getPais_lancamento());
            pstmt.setDouble(7, filme.getBilheteria());
            pstmt.setDouble(8, filme.getOrcamento());
            pstmt.setString(9, filme.getDiretor());
            pstmt.setInt(10, filme.getId());
            pstmt.execute();
            util.ConexaoBanco.fechaConexao(con, pstmt);
        } catch (java.sql.SQLException err) {
            throw new RuntimeException(err);
        }
        return retorno;
    }
        public static boolean excluirFilme(model.Filmes filme) throws ClassNotFoundException{
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        boolean retorno = false;
        try{
            con = util.ConexaoBanco.getConexao();
            pstmt= con.prepareStatement(EXCLUIR);
            pstmt.setInt(1, filme.getId());
            pstmt.execute();
            util.ConexaoBanco.fechaConexao(con, pstmt);
        } catch (java.sql.SQLException err){
            throw new RuntimeException(err);
        }
        return retorno;
    }

}
