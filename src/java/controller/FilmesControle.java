/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;

/**
 *
 * @author alunos
 */
public class FilmesControle {
    public static java.util.List<model.Filmes> listarFilmes(){
        java.util.List<model.Filmes>retorno;
        retorno = model.dao.FilmesDAO.listarFilmes();
        return retorno;
    }
    public static model.Filmes obterPorID(int id) throws SQLException, ClassNotFoundException{
        model.Filmes f;
        f = model.dao.FilmesDAO.obterPorID(id);
        return f;
    }
    public static boolean inserirFilme(model.Filmes filme) throws ClassNotFoundException{
        boolean retorno = model.dao.FilmesDAO.inserirFilme(filme);
        return retorno;
    }
    public static boolean atualizarFilme(model.Filmes filme) throws ClassNotFoundException{
        boolean retorno = model.dao.FilmesDAO.atualizarFilme(filme);
        return retorno;
    }
    public static boolean excluirFilme(model.Filmes filme) throws ClassNotFoundException{
        boolean retorno = model.dao.FilmesDAO.excluirFilme(filme);
        return retorno;
    }
}
