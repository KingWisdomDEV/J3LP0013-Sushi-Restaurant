package controller;

import dao.IMenu;
import dao.ISocialNetwork;
import dao.impl.MenuDAO;
import dao.impl.SocialNetworkDAO;
import entity.Menu;
import entity.SocialNetwork;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
@WebServlet(name = "ServletMenu", urlPatterns = {"/menu"})
public class ServletMenu extends HttpServlet {

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
        try {
            IMenu db = new MenuDAO();
            List<Menu> list = db.getAll();
            ISocialNetwork dbSocial = new SocialNetworkDAO();
            List<SocialNetwork> listSocial = dbSocial.getAll();
            
            // PAGING START
            int size = list.size();
            String spage = request.getParameter("page");
            int page = (spage != null && !spage.equals("")) ? Integer.parseInt(spage) : 1;
            int perpage = 2;
            int totalPage = (size / perpage) + ((size % perpage == 0 && (page) != 0) ? 0 : 1);
            if ((page > totalPage && totalPage != 0) || page < 0) {
                response.sendRedirect("../sushi-king.com/menu");
            } else {
                int start = page * perpage - perpage;
                int end = ((start + perpage) < list.size()) ? (start + perpage) : list.size();
                
                // PAGING END
                List<Menu> data = db.getAllByPage(list, start, end);
                request.setAttribute("page", page);
                request.setAttribute("size", size);
                request.setAttribute("perpage", perpage);
            
                request.setAttribute("listObj", data);
                request.setAttribute("listSocialObj", listSocial);
                request.getRequestDispatcher("view/menu.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("view/error.jsp").forward(request, response);
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
        processRequest(request, response);
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
