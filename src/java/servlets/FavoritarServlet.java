/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Filmes;

/**
 *
 * @author bielzinho
 */
@WebServlet(name = "FavoritarServlet", urlPatterns = {"/FavoritarServlet"})
public class FavoritarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        model.Usuarios usu = new model.Usuarios();
        HttpSession session = request.getSession();
        usu.setId((Integer) (session.getAttribute("userId")));
        String nomeusuario = String.valueOf(session.getAttribute("username"));
        java.util.List<model.Filmes> listaFilmes;
        listaFilmes = controller.FavoritosControle.listarFavoritos(usu);

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "  <meta charset=\"UTF-8\">\n"
                    + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "  <title> Lista de Favoritos</title>\n"
                    + "  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>\n"
                    + "  <link rel=\"stylesheet\" href=\"./ASSETS/Dashboard.css\">\n"
                    + "<link rel=\"stylesheet\" href=\"./ASSETS/listagem.css\">\n"
                     + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "  <nav>\n"
                    + "    <div class=\"sidebar-top\">\n"
                    + "      <img src=\"./ASSETS/logo.png\" class=\"logo\" alt=\"\">\n"
                    + "    </div>\n"
                    + "\n"
                    + "            <div class=\"btn-novo\">\n"
                    + "                <form action=\"ListaFilmesServlet\" id=\"buscarid\" method=\"post\">\n"
                    + "                    <div class=\"search\">\n"
                    + "                        <i class='bx bxs-right-arrow-circle'></i>\n"
                    + "                        <input type=\"number\" class=\"hide\" name=\"id\" placeholder=\"Pesquisar por id...\">\n"
                    + "                    </div>\n"
                    + "                    <div id=\"btn-search\">  <a href=\"#\" onclick=\"document.getElementById('buscarid').submit()\"><i class='bx bx-search'></i></a></div>\n"
                    + "                </form>\n"
                    + "            </div>\n"
                    + "\n"
                    + "    <div class=\"sidebar-links\">\n"
                    + "\n"
                    + "      <ul>\n"
                    + "        <li class=\"tooltip-element\" data-tooltip=\"0\">\n"
                    + "          <a href=\"ListaFilmesServlet\" data-active=\"5\">\n"
                    + "            <div class=\"icon\">\n"
                    + "              <i class='bx bx-home'></i>\n"
                    + "              <i class='bx bx-home'></i>\n"
                    + "            </div>\n"
                    + "            <span class=\"link hide\">Home | Consultar Filmes</span>\n"
                    + "          </a>\n"
                    + "        </li>\n"
                    + "        <li class=\"tooltip-element\" data-tooltip=\"0\">\n"
                    + "          <a href=\"AdicionarServlet\" data-active=\"5\">\n"
                    + "            <div class=\"icon\">\n"
                    + "              <i class='bx bx-plus'></i>\n"
                    + "              <i class='bx bx-plus'></i>\n"
                    + "            </div>\n"
                    + "            <span class=\"link hide\">Adicionar Filme</span>\n"
                    + "          </a>\n"
                    + "        </li>\n"
                    + "        <li class=\"tooltip-element\" data-tooltip=\"1\">\n"
                    + "          <a href=\"FavoritarServlet\" style=\"color: #e254ff;\" data-active=\"6\">\n"
                    + "            <div class=\"icon\">\n"
                    + "              <i class='bx bxs-star'></i>\n"
                    + "              <i class='bx bxs-star'></i>\n"
                    + "            </div>\n"
                    + "            <span class=\"link hide\">Lista de Favoritos</span>\n"
                    + "          </a>\n"
                    + "        </li>\n"
                    + "      </ul>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div class=\"sidebar-footer\">\n"
                    + "      <a href=\"#\" class=\"account tooltip-element\" data-tooltip=\"0\">\n"
                    + "        <i class='bx bx-user'></i>\n"
                    + "      </a>\n"
                    + "\n"
                    + "      <div class=\"admin-user tooltip-element\" data-tooltip=\"1\">\n"
                    + "        <div class=\"admin-profile hide\">\n"
                    + "          <img src=\"./ASSETS/logo.png\" alt=\"\">\n"
                    + "          <div class=\"admin-info\">\n"
                    + "            <h3>" + nomeusuario + "</h3>\n"
                    + "          </div>\n"
                    + "        </div>\n"
                    + "        <a href=\"index.html\" class=\"log-out\">\n"
                    + "          <i class='bx bx-log-out'></i>\n"
                    + "        </a>\n"
                    + "      </div>\n"
                    + "\n"
                    + "      <div class=\"tooltip\">\n"
                    + "        <span class=\"show\">DEV SCHOOL</span>\n"
                    + "        <span>Logout</span>\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "  </nav>\n"
                    + "\n"
                    + "  <main class=\"container\">\n"
                    + "    <div class=\"analise-titulo\">\n"
                    + "      <div>\n"
                    + "\n"
                    + "        <p>Seus Filmes Favoritos</p>\n"
                    + "\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "    <div class=\"gridView\">");
                       out.println("<table id='documentos'><thead><tr><th>ID</th><th>ESTÚDIO</th><th>NOME</th><th>NOTA</th><th>ANO LANÇAMENTO</th><th>ATOR PRINCIPAL</th><th>PAÍS DE ORIGEM</th><th>BILHETERIA</th><th>ORÇAMENTO</th><th>DIRETOR</th><th>AÇÕES</th></tr></thead><tbody>");

            for (Filmes f : listaFilmes) {
                String estudio = f.getEstudio();
                String nome = f.getNome();
                String nota = String.valueOf(f.getNota());
                String ano_lancamento = String.valueOf(f.getAno_lancamento());
                String ator_principal = f.getAtor_principal();
                String pais_lancamento = f.getPais_lancamento();
                String bilheteria = String.valueOf(f.getBilheteria());
                String orcamento = String.valueOf(f.getOrcamento());
                String diretor = f.getDiretor();
                if (estudio == null) {
                    estudio = "";
                }
                if (nome == null) {
                    nome = "";
                }
                if ("0.0".equals(nota)) {
                    nota = "";
                }
                if ("0".equals(ano_lancamento)) {
                    ano_lancamento = "";
                }
                if (ator_principal == null) {
                    ator_principal = "";
                }
                if (pais_lancamento == null) {
                    pais_lancamento = "";
                }
                if ("0.0".equals(bilheteria)) {
                    bilheteria = "";
                }
                if ("0.0".equals(orcamento)) {
                    orcamento = "";
                }
                if (diretor == null) {
                    diretor = "";
                }

                out.println("<tr><td>" + f.getId() + "</td><td>" + estudio + "</td><td>" + nome + "</td><td>" + nota + "</td><td>" + ano_lancamento + "</td><td>" + ator_principal + "</td><td>" + pais_lancamento + "</td><td>" + bilheteria + "</td><td>" + orcamento + "</td><td>" + diretor + " </td>");
                out.println("<td><div class='botoes'><form action='UnfavoritarServlet' method='post'><input id='idfavoritar' name='idfavoritar' type='hidden' value='" + f.getId() + "'/><input id='iduser' name='iduser' type='hidden' value='" + usu.getId() + "'/><button type='submit' class='btn-excluir'> <img class='img-excluir' src='./ASSETS/trash-svgrepo-com.svg'/></button></form></div></td> </tr>");
            }
            out.println("</tbody> </table>");
            out.println("</div>\n"
                    + "\n"
                    + "  </main>\n"
                    + "\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>");

//            for (Filmes f : listaFilmes) {
//                String estudio = f.getEstudio();
//                String nome = f.getNome();
//                String nota = String.valueOf(f.getNota());
//                String ano_lancamento = String.valueOf(f.getAno_lancamento());
//                String ator_principal = f.getAtor_principal();
//                String pais_lancamento = f.getPais_lancamento();
//                String bilheteria = String.valueOf(f.getBilheteria());
//                String orcamento = String.valueOf(f.getOrcamento());
//                String diretor = f.getDiretor();
//                if (estudio == null) {
//                    estudio = "";
//                }
//                if (nome == null) {
//                    nome = "";
//                }
//                if ("0.0".equals(nota)) {
//                    nota = "";
//                }
//                if ("0".equals(ano_lancamento)) {
//                    ano_lancamento = "";
//                }
//                if (ator_principal == null) {
//                    ator_principal = "";
//                }
//                if (pais_lancamento == null) {
//                    pais_lancamento = "";
//                }
//                if ("0.0".equals(bilheteria)) {
//                    bilheteria = "";
//                }
//                if ("0.0".equals(orcamento)) {
//                    orcamento = "";
//                }
//                if (diretor == null) {
//                    diretor = "";
//                }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(FavoritarServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idfavoritar = Integer.parseInt(request.getParameter("idfavoritar"));
        int iduser = Integer.parseInt(request.getParameter("iduser"));
        model.Favoritos fav = new model.Favoritos();
        fav.setFilmeid(idfavoritar);
        fav.setUserid(iduser);
        try {
            controller.FavoritosControle.favoritar(fav);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FavoritarServlet.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(FavoritarServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("FavoritarServlet");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
