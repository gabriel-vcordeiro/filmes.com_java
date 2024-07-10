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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bielzinho
 */
public class LoginServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        model.Usuarios usuario = new model.Usuarios();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        try {
            usuario = controller.UsuariosControle.login(usuario);
            if (usuario.getId() > 0) {
                try (PrintWriter out = response.getWriter()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", usuario.getId());
                    session.setAttribute("username", usuario.getNome());
                    response.sendRedirect("ListaFilmesServlet");
                }
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>\n"
                            + "<html lang=\"en\">\n"
                            + "\n"
                            + "    <head>\n"
                            + "\n"
                            + "        <meta charset=\"UTF-8\">\n"
                            + "        <title>Filmes.com</title>\n"
                            + "        <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n"
                            + "        <link rel='stylesheet' href='./ASSETS/root.css'/>\n"
                            + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                            + "\n"
                            + "    </head>\n"
                            + "\n"
                            + "    <body class=\"align\">\n"
                            + "        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n"
                            + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js\"> </script>\n"
                            + "        <script>\n"
                            + "            \n"
                            + "            $(document).ready(function () {\n"
                            + "                // Função para validar a senha\n"
                            + "                $(\"#login\").prop(\"disabled\", true);\n"
                            + "                $(\"#login\").css(\"opacity\", 0.5);// Bloqueia o botão de cadastro\n"
                            + "\n"
                            + "                function validarSenha() {\n"
                            + "                    var senha = $(\"#senha\").val();\n"
                            + "                    var nome = $(\"#nome\").val();\n"
                            + "\n"
                            + "                    if (senha == \"\" || nome == \"\") {\n"
                            + "                        $(\"#login\").prop(\"disabled\", true);\n"
                            + "                        $(\"#login\").css(\"opacity\", 0.5);// Bloqueia o botão de cadastro\n"
                            + "                    } else {\n"
                            + "                        $(\"#login\").prop(\"disabled\", false);\n"
                            + "                        $(\"#login\").css(\"opacity\", 1.0);\n"
                            + "                        // Habilita o botão de cadastro\n"
                            + "                    }\n"
                            + "                }\n"
                            + "\n"
                            + "                // Chama a função quando o campo de senha ou confirmação de senha for alterado\n"
                            + "                $(\"#senha, #nome\").on(\"input\", validarSenha);\n"
                            + "            });\n"
                            + "        </script>\n"
                            + "        <div class=\"grid align__item\">\n"
                            + "\n"
                            + "            <div class=\"register\">\n"
                            + "\n"
                            + "                <div class=\"logo\">\n"
                            + "\n"
                            + "                    <img class=\"imagem_logo \" src=\"./ASSETS/logo.png\">\n"
                            + "                </div>"
                            + "\n"
                            + "                <span class=\"senha_errado\">Nome ou senha errados!</span>\n"
                            + "\n"
                            + "                <form action=\"LoginServlet\" method=\"post\">\n"
                            + "\n"
                            + "                    <div class=\"form__field\">\n"
                            + "                        <input type=\"text\" name=\"nome\" id=\"nome\" placeholder=\"Nome\">\n"
                            + "                    </div>\n"
                            + "\n"
                            + "                    <div class=\"form__field\">\n"
                            + "                        <input type=\"password\" name=\"senha\" id=\"senha\" placeholder=\"*********\">\n"
                            + "                    </div>\n"
                            + "\n"
                            + "                    <div class=\"form__field\">\n"
                            + "                        <input id =\"login\" type=\"submit\" value=\"Logar\">\n"
                            + "                    </div>\n"
                            + "\n"
                            + "                </form>\n"
                            + "\n"
                            + "                <p>Quer se cadastrar? <a href=\"CadastroServlet\">Cadastre-se</a></p>\n"
                            + "\n"
                            + "            </div>\n"
                            + "\n"
                            + "        </div>\n"
                            + "\n"
                            + "    </body>\n"
                            + "\n"
                            + "</html>");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
