/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbb.oh.controls;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            DAOGeneric<Produit> daoproduit;
            try {
                String mdp = "a";

                TreeMap<String, String> map = new TreeMap<String, String>();
                map.put("typeProduit", "1");
                daoproduit = new DAOGeneric<Produit>(new Produit());
                List<Produit> produit = daoproduit.findby(map);
                req.setAttribute("Annonce", produit);
            } catch (InstantiationException ex) {
                Logger.getLogger(AnnonceCTRL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AnnonceCTRL.class.getName()).log(Level.SEVERE, null, ex);
            }

            getServletContext().getRequestDispatcher("/WEB-INF/Annonce.jsp").forward(req, resp);

        } else {

            /**
             * Ici ma requete avec offres
             */
          
            DAOGeneric<Produit> daoproduit;
            try {

                TreeMap<String, String> map = new TreeMap<String, String>();
                map.put("typeProduit", "2");
                daoproduit = new DAOGeneric<Produit>(new Produit());
                List<Produit> produit = daoproduit.findby(map);
                req.setAttribute("Annonce", produit);
            } catch (InstantiationException ex) {
                Logger.getLogger(AnnonceCTRL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AnnonceCTRL.class.getName()).log(Level.SEVERE, null, ex);
            }

            getServletContext().getRequestDispatcher("/WEB-INF/Annonce.jsp").forward(req, resp);

        }

    }

}
