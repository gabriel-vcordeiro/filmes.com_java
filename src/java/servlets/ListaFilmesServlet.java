package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
 * @author alunos
 */
@WebServlet(urlPatterns = {"/ListaFilmesServlet"})
public class ListaFilmesServlet extends HttpServlet {

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
        java.util.List<model.Filmes> listaFilmes;
        listaFilmes = controller.FilmesControle.listarFilmes();
        response.setContentType("text/html;charset=UTF-8");
        model.Usuarios usu = new model.Usuarios();
        HttpSession session = request.getSession();
        int numUsuarios = model.dao.UsuariosDAO.contagem();
        usu.setId((Integer) (session.getAttribute("userId")));
        String nomeUsuario = String.valueOf(session.getAttribute("username"));
        java.util.List<model.Filmes> listafav;
        listafav = controller.FavoritosControle.listarFavoritos(usu);
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "  <meta charset=\"UTF-8\">\n"
                    + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "  <title> Lista de Filmes</title>\n"
                    + "  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>\n"
                    + "  <link rel=\"stylesheet\" href=\"./ASSETS/Dashboard.css\">\n"
                    + "        <link rel='stylesheet' href='./ASSETS/listagem.css'/>\n"
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
                    + "          <a href=\"ListaFilmesServlet\" style=\"color: #e254ff;\" data-active=\"5\">\n"
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
                    + "          <a href=\"FavoritarServlet\" data-active=\"6\">\n"
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
                    + "            <h3>" + nomeUsuario + "</h3>\n"
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
                    + "    <h1>Bem vindo " + nomeUsuario + "</h1>\n"
                    + "    <div class=\"analise-titulo\">\n"
                    + "      <div>\n"
                    + "\n"
                    + "        <p>Suas Principais Estatísticas</p>\n"
                    + "\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "    <div class=\"analise-grafico\">\n"
                    + "      <ul>\n"
                    + "        <li>\n"
                    + "          <h3>Total de Filmes</h3>\n"
                    + "          <span>" + listaFilmes.size() + "</span>\n"
                    + "        </li>\n"
                    + "        <li>\n"
                    + "          <h3>Total de Favoritos</h3>\n"
                    + "          <span>" + listafav.size() + "</span>\n"
                    + "        </li>\n"
                    + "        <li>\n"
                    + "          <h3>Total de Contribuintes</h3>\n"
                    + "          <span>" + numUsuarios + " usuários</span>\n"
                    + "        </li>\n"
                    + "      </ul>\n"
                    + "    </div>\n"
                    + "    <div class=\"analise-titulo\">\n"
                    + "      <div>\n"
                    + "\n"
                    + "        <p>Consultar Filmes (Todos)</p>\n"
                    + "\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "    <div class=\"gridView\">"
                    + "    <table id='documentos'><thead><tr><th>ID</th><th>ESTÚDIO</th><th>NOME</th><th>NOTA</th><th>ANO LANÇAMENTO</th><th>ATOR PRINCIPAL</th><th>PAÍS DE ORIGEM</th><th>BILHETERIA</th><th>ORÇAMENTO</th><th>DIRETOR</th><th>AÇÕES</th></tr></thead><tbody>");
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
                out.println("<td><div class='botoes'><form action='ExcluirServlet' method='post'><input id='idexclusao' name='idexclusao' type='hidden' value='" + f.getId() + "'/><button type='submit' class='btn-excluir'> <img class='img-excluir' src='./ASSETS/trash-svgrepo-com.svg'/></button></form><form action='AlterarServlet' method='get'><input id='ialterar' name='idalterar' type='hidden' value='" + f.getId() + "'/><button type='submit' class='btn-alterar'> <img class='img-alterar' src='./ASSETS/edit-1479-svgrepo-com.svg'/></button></form><form action='FavoritarServlet' method='post'><input id='idfavoritar' name='idfavoritar' type='hidden' value='" + f.getId() + "'/><input id='iduser' name='iduser' type='hidden' value='" + usu.getId() + "'/><button type='submit' class='btn-excluir'> <img class='img-estrela' src='./ASSETS/estrela.png'/></button></form></div></td> </tr>");
            }
            out.println("</tbody> </table>"
                    + "</div>\n"
                    + "\n"
                    + "  </main>\n"
                    + "\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>"
            );
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
            Logger.getLogger(ListaFilmesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            HttpSession session = request.getSession();
            model.Usuarios usu = new model.Usuarios();
            java.util.List<model.Filmes> listaFilmes;
            listaFilmes = controller.FilmesControle.listarFilmes();
            response.setContentType("text/html;charset=UTF-8");
            usu.setId((Integer) (session.getAttribute("userId")));
            int totalusuarios = model.dao.UsuariosDAO.contagem();
            String nomeUsuario = String.valueOf(session.getAttribute("username"));
            java.util.List<model.Filmes> listafav;
            listafav = controller.FavoritosControle.listarFavoritos(usu);
            model.Filmes f = new model.Filmes();
            String Id = request.getParameter("id");
            if ("".equals(Id)) {
                Id = "0";
            }
            int id = Integer.parseInt(Id);

            try {
                f = controller.FilmesControle.obterPorID(id);
            } catch (SQLException ex) {
                Logger.getLogger(ListaFilmesServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListaFilmesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            response.setContentType("text/html;charset=UTF-8");

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + "\n"
                        + "<head>\n"
                        + "  <meta charset=\"UTF-8\">\n"
                        + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                        + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "  <title> Listagem por ID</title>\n"
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
                        + "            </div>"
                        + "\n"
                        + "    <div class=\"sidebar-links\">\n"
                        + "\n"
                        + "      <ul>\n"
                        + "        <li class=\"tooltip-element\" data-tooltip=\"0\">\n"
                        + "          <a href=\"ListaFilmesServlet\" style=\"color: #e254ff;\" data-active=\"5\">\n"
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
                        + "          <a href=\"FavoritarServlet\" data-active=\"6\">\n"
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
                        + "            <h3>" + nomeUsuario + "</h3>\n"
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
                        + "    <h1>Bem vindo " + nomeUsuario + "</h1>\n"
                        + "    <div class=\"analise-titulo\">\n"
                        + "      <div>\n"
                        + "\n"
                        + "        <p>Suas Principais Estatísticas</p>\n"
                        + "\n"
                        + "      </div>\n"
                        + "    </div>\n"
                        + "    <div class=\"analise-grafico\">\n"
                        + "      <ul>\n"
                        + "        <li>\n"
                        + "          <h3>Total de Filmes</h3>\n"
                        + "          <span>" + listaFilmes.size() + "</span>\n"
                        + "        </li>\n"
                        + "        <li>\n"
                        + "          <h3>Total de Favoritos</h3>\n"
                        + "          <span>" + listafav.size() + "</span>\n"
                        + "        </li>\n"
                        + "        <li>\n"
                        + "          <h3>Total de Contribuintes</h3>\n"
                        + "          <span>" +  totalusuarios + " usuários</span>\n"
                        + "        </li>\n"
                        + "      </ul>\n"
                        + "    </div>\n"
                        + "    <div class=\"analise-titulo\">\n"
                        + "      <div>\n"
                        + "\n"
                        + "        <p>Consultar Filme por id " + id + "</p>\n"
                        + "\n"
                        + "      </div>\n"
                        + "    </div>\n"
                        + "    <div class=\"gridView\">\n");
                out.println("<table id='documentos'><thead><tr><th>ID</th><th>ESTÚDIO</th><th>NOME</th><th>NOTA</th><th>ANO LANÇAMENTO</th><th>ATOR PRINCIPAL</th><th>PAÍS DE ORIGEM</th><th>BILHETERIA</th><th>ORÇAMENTO</th><th>DIRETOR</th><th>AÇÕES</th></tr></thead><tbody>");
                out.println("<tr><td>" + f.getId() + "</td><td>" + estudio + "</td><td>" + nome + "</td><td>" + nota + "</td><td>" + ano_lancamento + "</td><td>" + ator_principal + "</td><td>" + pais_lancamento + "</td><td>" + bilheteria + "</td><td>" + orcamento + "</td><td>" + diretor + " </td>");
                out.println("<td><div class='botoes'><form action='ExcluirServlet' method='post'><input id='idexclusao' name='idexclusao' type='hidden' value='" + f.getId() + "'/><button type='submit' class='btn-excluir'> <img class='img-excluir' src='./ASSETS/trash-svgrepo-com.svg'/></button></form><form action='AlterarServlet' method='get'><input id='ialterar' name='idalterar' type='hidden' value='" + f.getId() + "'/><button type='submit' class='btn-alterar'> <img class='img-alterar' src='./ASSETS/edit-1479-svgrepo-com.svg'/></button></form><form action='FavoritarServlet' method='post'><input id='idfavoritar' name='idfavoritar' type='hidden' value='" + f.getId() + "'/><input id='iduser' name='iduser' type='hidden' value='" + usu.getId() + "'/><button type='submit' class='btn-excluir'> <img class='img-estrela' src='./ASSETS/estrela.png'/></button></form></div></td> </tr>");
                out.println("</tbody> </table>");
                out.println("\n"
                        + "</div>  </main>\n"
                        + "\n"
                        + "\n"
                        + "</body>\n"
                        + "\n"
                        + "</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListaFilmesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
