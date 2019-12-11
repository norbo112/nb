package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kereskedelem.aru.Cikk;
import model.ArukeresoModel;
import model.SajatModel;
import view.ArukeresoView;
import view.SajatViewModel;

public class ArukeresoControllerServlet extends HttpServlet {

    private ArukeresoModel model;
    private ArukeresoView view;
    
    private String htmlSablon;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
        model = new SajatModel();
        view = new SajatViewModel();
        
        try {
            htmlSablon = new String(Files.readAllBytes(Paths.get(getServletContext().getRealPath("progj18template.html"))), "UTF-8");
        } catch (IOException ex) {
            Logger.getLogger(ArukeresoControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
        //a paraméterek kódolásását állítja be
        // az alapértelmezés nem UTF-8 és ez pl. az ÜVEG esetében hibás működést eredményezne
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<Cikk> cikkek = model.kereses(request.getParameterMap());
            
            Map<String, Object> viewPararameterek = new HashMap<>();
            viewPararameterek.put("parameterek", request.getParameterMap());
            viewPararameterek.put("htmlSablon", htmlSablon);
            viewPararameterek.put("cikkek", cikkek);
            viewPararameterek.put("megysegek", model.mennyisegiEgysegek());
            Object htmlView = view.createView(viewPararameterek);
            
            out.append(htmlView.toString());
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
