/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbb.oh.controls;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author formation
 */
public class AnnonceCTRL extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String type = "annonces";

        if (req.getParameter("titre").equals(type)) {
            /**
             * Ici ma requete pour les demandes
             */

            req.setAttribute("type", type);
            getServletContext().getRequestDispatcher("/WEB-INF/Annonce.jsp").forward(req, resp);

        } else {

            /**
             * Ici ma requete avec offres
             */
            getServletContext().getRequestDispatcher("/WEB-INF/Annonce.jsp").forward(req, resp);

        }

    }

}
