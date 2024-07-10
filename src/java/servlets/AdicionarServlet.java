package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bielzinho
 */
public class AdicionarServlet extends HttpServlet {

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
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nomeUsuario = String.valueOf(session.getAttribute("username"));
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "  <meta charset=\"UTF-8\">\n"
                    + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "  <title> Adicionar Filme</title>\n"
                    + "  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>\n"
                    + "  <link rel=\"stylesheet\" href=\"./ASSETS/Dashboard.css\">\n"
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
                    + "          <a href=\"ListaFilmesServlet\" data-active=\"5\">\n"
                    + "            <div class=\"icon\">\n"
                    + "              <i class='bx bx-home'></i>\n"
                    + "              <i class='bx bx-home'></i>\n"
                    + "            </div>\n"
                    + "            <span class=\"link hide\">Home | Consultar Filmes</span>\n"
                    + "          </a>\n"
                    + "        </li>\n"
                    + "        <li class=\"tooltip-element\" data-tooltip=\"0\">\n"
                    + "          <a href=\"AdicionarServlet\" style=\"color:#e254ff\" data-active=\"5\">\n"
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
                    + "        <a href=\"/index.html\" class=\"log-out\">\n"
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
                    + "        <p>Adicione Novos Filmes ao Catálogo</p>\n"
                    + "\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "    <div class=\"escolha-cadastro\" id=\"escolha-cadastro\">\n"
                    + "        <form action=\"AdicionarServlet\" style=\"display:contents;\" method=\"post\">\n"
                    + "      <div class=\"col-m\">\n"
                    + "        <label for=\"nome\">Nome</label>\n"
                    + "        <input type=\"text\" id=\"nome\" name=\"nome\">\n"
                    + "      </div>\n"
                    + "\n"
                    + "      <div class=\"col-m\">\n"
                    + "        <label for=\"estudio\">Estúdio</label>\n"
                    + "        <input type=\"text\" id=\"estudio\" name=\"estudio\">\n"
                    + "      </div>\n"
                    + "\n"
                    + "      <div class=\"col-m\">\n"
                    + "        <label for=\"nota\">Nota</label>\n"
                    + "        <input type=\"number\" id=\"nota\" name=\"nota\">\n"
                    + "      </div>\n"
                    + "\n"
                    + "      <div class=\"col-m\">\n"
                    + "        <label for=\"ano_lancamento\">Ano de Lançamento</label>\n"
                    + "        <input type=\"number\" id=\"ano_lancamento\" name=\"ano_lancamento\">\n"
                    + "      </div>\n"
                    + "\n"
                    + "\n"
                    + "      <div class=\"col-m\">\n"
                    + "        <label for=\"ator_principal\">Ator Principal</label>\n"
                    + "        <input type=\"text\" id=\"ator_principal\" name=\"ator_principal\">\n"
                    + "      </div>\n"
                    + "\n"
                    + "      <div class=\"col-m\">\n"
                    + "        <label for=\"pais_lancamento\">País de Lançamento</label>\n"
                    + "        <input type=\"text\" id=\"pais_lancamento\" name=\"pais_lancamento\">\n"
                    + "      </div>\n"
                    + "\n"
                    + "      <div class=\"col-m\">\n"
                    + "        <label for=\"bilheteria\">Bilheteria</label>\n"
                    + "        <input type=\"number\" id=\"bilheteria\" name=\"bilheteria\">\n"
                    + "      </div>\n"
                    + "\n"
                    + "      \n"
                    + "      <div class=\"col-m\">\n"
                    + "        <label for=\"bilheteria\">Orçamento</label>\n"
                    + "        <input type=\"number\" id=\"orcamento\" name=\"orcamento\">\n"
                    + "      </div>\n"
                    + "      \n"
                    + "      <div class=\"col-m\">\n"
                    + "        <label for=\"diretor\">Diretor</label>\n"
                    + "        <input type=\"text\" id=\"diretor\" name=\"diretor\">\n"
                    + "      </div>\n"
                    + "      \n"
                    + "      <input type='submit' style=\"width: 30%;\" class=\"botao\" value='Adicionar'>\n"
                    + "      </form>\n"
                    + "    </div>\n"
                    + "\n"
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
        processRequest(request, response);
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
        String Ano_Lancamento = (request.getParameter("ano_lancamento"));
        if ("".equals(Ano_Lancamento)) {
            Ano_Lancamento = "0";
        }
        String Bilheteria = (request.getParameter("bilheteria"));
        if ("".equals(Bilheteria)) {
            Bilheteria = "0";
        }
        String Nota = (request.getParameter("nota"));
        if ("".equals(Nota)) {
            Nota = "0";
        }
        String Orcamento = (request.getParameter("orcamento"));
        if ("".equals(Orcamento)) {
            Orcamento = "0";
        }
        String nome = (request.getParameter("nome"));
        int Ano_lancamento = (Integer.parseInt(Ano_Lancamento));
        double bilheteria = (Double.parseDouble(Bilheteria));
        String diretor = (request.getParameter("diretor"));
        double nota = (Double.parseDouble(Nota));
        double orcamento = (Double.parseDouble(Orcamento));
        String ator_principal = (request.getParameter("ator_principal"));
        String pais_lancamento = (request.getParameter("pais_lancamento"));
        model.Filmes f = new model.Filmes();
        f.setNome(nome);
        f.setAtor_principal(ator_principal);
        f.setAno_lancamento(Ano_lancamento);
        f.setBilheteria(bilheteria);
        f.setDiretor(diretor);
        f.setEstudio(request.getParameter("estudio"));
        f.setNota(nota);
        f.setOrcamento(orcamento);
        f.setPais_lancamento(pais_lancamento);
        if (f.getNota() > 10 || f.getNota() < 0) {
            f.setNota(0);
        }
        if (f.getBilheteria() < 0) {
            f.setBilheteria(0);
        }
        if (f.getOrcamento() < 0) {
            f.setOrcamento(0);
        }
        if (f.getAno_lancamento() > 2024 || f.getAno_lancamento() < 1800) {
            f.setAno_lancamento(0);
        }

        try {
            controller.FilmesControle.inserirFilme(f);
            response.sendRedirect("ListaFilmesServlet");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdicionarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
