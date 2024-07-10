/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;

/**
 *
 * @author bielzinho
 */
public class FavoritosControle {

    public static java.util.List<model.Filmes> listarFavoritos(model.Usuarios usu) throws SQLException {
        java.util.List<model.Filmes> retorno;
        retorno = model.dao.FavoritosDAO.listarFavoritos(usu);
        return retorno;
    }
    public static boolean favoritar(model.Favoritos favorito) throws ClassNotFoundException, SQLException{
        boolean favoritar = model.dao.FavoritosDAO.inserirFilme(favorito);
        return favoritar;
    }
        public static boolean deletar(model.Favoritos favorito) throws ClassNotFoundException, SQLException{
        boolean deletar = model.dao.FavoritosDAO.deletarFilme(favorito);
        return deletar;
    }
}