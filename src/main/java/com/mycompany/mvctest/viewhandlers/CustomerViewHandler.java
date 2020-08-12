/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mvctest.viewhandlers;

import controller.CustomerController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;

/**
 *
 * @author alvindiaz
 */
@WebServlet(name = "CustomerViewHandler", urlPatterns = {"/Customer"})
public class CustomerViewHandler extends HttpServlet {

    
    CustomerController customerController = new CustomerController();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
          Customer cust = new Customer();
          cust.setId(request.getParameter("custId"));
          cust.setName(request.getParameter("custName"));
          cust.setLastName(request.getParameter("custLastName"));
          cust.setAge(Integer.parseInt(request.getParameter("custAge")));
          cust.setEnable(Boolean.parseBoolean(request.getParameter("custEnable")));
          
          boolean result = customerController.addCustomer(cust);
          
          String resultText = "";
          
          if(result)
              resultText = "Customer saved successfully";
          else
              resultText = "Customer couldn't be saved we exceed the daily quota";
          
          request.setAttribute("transactionResultMessage", resultText);
          
          request.getRequestDispatcher("/WEB-INF/pages/customerForm.jsp").include(request, response);
          
          
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/customerForm.jsp").include(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
