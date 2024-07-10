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
public class UsuariosControle {
    public static model.Usuarios login(model.Usuarios usu) throws SQLException, ClassNotFoundException{
        model.Usuarios usuario = model.dao.UsuariosDAO.login(usu);
        return usuario;
    }
    public static boolean cadastro(model.Usuarios  usu) throws SQLException, ClassNotFoundException{
        boolean retorno = model.dao.UsuariosDAO.cadastro(usu);
        return retorno;
    }
    
}
