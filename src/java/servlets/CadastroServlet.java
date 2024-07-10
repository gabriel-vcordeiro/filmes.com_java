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

/**
 *
 * @author bielzinho
 */
@WebServlet(name = "CadastroServlet", urlPatterns = {"/CadastroServlet"})
public class CadastroServlet extends HttpServlet {

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
            out.println("<title>Cadastro</title>");
            out.println("\n"
                    + "    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n"
                    + "    <script>\n"
                    + "        $(document).ready(function() {\n"
                    + "                 $(\"#cadastro\").prop(\"disabled\", true);"
                    + "$(\"#cadastro\").css(\"opacity\", 0.5); // Define a opacidade do botão\n"
                    + "            // Função para validar a senha\n"
                    + "            function validarSenha() {\n"
                    + "                var senha = $(\"#senha\").val();\n"
                    + "                var confirmaSenha = $(\"#conf_senha\").val();\n"
                    + "                 var nome=$ (\"#nome\").val();\n"
                    + "\n"
                    + "                if (senha !== confirmaSenha || nome===\"\") {\n"
                    + "$(\"#cadastro\").prop(\"disabled\", true); // Bloqueia o botão de cadastro\n"
                    + "$(\"#cadastro\").css(\"opacity\", 0.5); // Define a opacidade do botão\n"
                    + ""
                    + "                } else {\n"
                    + "                    $(\"#cadastro\").prop(\"disabled\", false); // Habilita o botão de cadastro\n"
                    + "$(\"#cadastro\").css(\"opacity\", 1.0); // Define a opacidade do botão\n"
                    + "                }\n"
                    + "            }\n"
                    + "\n"
                    + "            // Chama a função quando o campo de senha ou confirmação de senha for alterado\n"
                    + "            $(\"#senha, #conf_senha, #nome\").on(\"input\", validarSenha);\n"
                    + "        });\n"
                    + "    </script>");
            out.println("<title>Servlet CadastroServlet</title>");
            out.println("<link rel='stylesheet' href='./ASSETS/root.css'/>");

            out.println("</head>");
            out.println("<body style=\"overflow-y:hidden\">");
            out.println("  <div class=\"grid align__item\">\n"
                    + "\n"
                    + "    <div class=\"register\">\n"
                    + "\n"
                    + "                <div class=\"logo\">\n"
                    + "\n"
                    + "                    <img class=\"imagem_logo \" src=\"./ASSETS/logo.png\">\n"
                    + "                </div>"
                    + "      <span>Faça seu Cadastro!</span>\n"
                    + "\n"
                    + "        <form action=\"CadastroServlet\" method=\"post\">\n"
                    + "\n"
                    + "        <div class=\"form__field\">\n"
                    + "          <input type=\"text\" name=\"nome\" id=\"nome\" placeholder=\"Nome\">\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <div class=\"form__field\">\n"
                    + "          <input type=\"password\" name=\"senha\" id=\"senha\" placeholder=\"••••••••••••\">\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <div class=\"form__field\">\n"
                    + "          <input type=\"password\" name=\"conf_senha\" id=\"conf_senha\" placeholder=\"••••••••••••\">\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <div class=\"form__field\">\n"
                    + "          <input id=\"cadastro\" type=\"submit\" value=\"Cadastrar\">\n"
                    + "        </div>\n"
                    + "\n"
                    + "      </form>\n"
                    + "\n"
                    + "      <p>Já possui uma conta? <a href=\"index.html\">Log-in</a></p>\n"
                    + "\n"
                    + "    </div>\n"
                    + "\n"
                    + "  </div>");
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
            controller.UsuariosControle.cadastro(usuario);
            response.sendRedirect("index.html");
            return;
        } catch (SQLException ex) {
            Logger.getLogger(CadastroServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("CadastroServlet");
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
