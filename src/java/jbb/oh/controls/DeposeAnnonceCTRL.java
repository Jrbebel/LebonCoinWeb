/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbb.oh.controls;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.CategorieProduit;
import fr.oh.entities.Client;
import fr.oh.entities.Produit;
import fr.oh.entities.SousCategorieProduit;
import fr.oh.entities.TypeProduit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author formation
 */
public class DeposeAnnonceCTRL extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TreeMap<String, String> map = new TreeMap<String, String>();
        CategorieProduit catPro = new CategorieProduit();
        DAOGeneric<CategorieProduit> daocatpro = null;
        try {
            daocatpro = new DAOGeneric<CategorieProduit>(catPro);
        } catch (InstantiationException ex) {
            Logger.getLogger(DeposeAnnonceCTRL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DeposeAnnonceCTRL.class.getName()).log(Level.SEVERE, null, ex);
        }

        SousCategorieProduit sscat = new SousCategorieProduit();
        DAOGeneric<SousCategorieProduit> daosscat = null;
        try {
            daosscat = new DAOGeneric<SousCategorieProduit>(sscat);
        } catch (InstantiationException ex) {
            Logger.getLogger(DeposeAnnonceCTRL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DeposeAnnonceCTRL.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<CategorieProduit> categoriepro = daocatpro.findAll();
        StringBuilder categorie = new StringBuilder();
        for (CategorieProduit CategorieProduit : categoriepro) {

//            System.out.println("------->" + CategorieProduit.getCategorieProduit() + "<--------");
            categorie.append(" <optgroup label='" + CategorieProduit.getCategorieProduit() + "'> \n");
            map.put("ID_CATEGORIE_PRODUIT", String.valueOf(CategorieProduit.getIdCategorieProduit()));
            List<SousCategorieProduit> sscategorie = daosscat.findby(map);

            for (SousCategorieProduit sousCategorieProduit : sscategorie) {

//                System.out.println(sousCategorieProduit.getSousCategorieProduit());
                categorie.append("<option value='" + sousCategorieProduit.getIdSousCategorieProduit() + "'>" + sousCategorieProduit.getSousCategorieProduit() + "</option> \n");

            }

            categorie.append("</optgroup> \n");

        }
        req.setAttribute("Categorie", categorie.toString());

        getServletContext().getRequestDispatcher("/WEB-INF/DeposeAnnonce.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            HttpSession session = req.getSession();
            PrintWriter out = resp.getWriter();

            DAOGeneric<Client> daoClient = new DAOGeneric<Client>(new Client());

            Client client = daoClient.findOne(Integer.valueOf(session.getAttribute("idUtilisateur").toString()));

            SousCategorieProduit sousCategorieProduit = new SousCategorieProduit();

            String designationProduit = req.getParameter("titre");
            float prix = Integer.valueOf(req.getParameter("prix"));
            Date dateMiseEnVenteProduit = new Date("2012/21/21");
            String descriptionProduit = req.getParameter("descriptif");

//            TRAITEMENT FACILE POUR LA GESTION DES CHAMPS VIDE
          
            
            
            DAOGeneric<SousCategorieProduit> daoss = new DAOGeneric<SousCategorieProduit>(new SousCategorieProduit());
            SousCategorieProduit categorie = daoss.findOne(Integer.valueOf(req.getParameter("categorie")));

            DAOGeneric<TypeProduit> daoTypeprod;                                                                                               rod = new DAOGeneric<TypeProduit>(new TypeProduit());
            TypeProduit prod;
            prod = daoTypeprod.findOne(Integer.valueOf(req.getParameter("type").toString()));

            Produit annonce = new Produit(client, prod, categorie, designationProduit, prix, dateMiseEnVenteProduit, descriptionProduit);
            DAOGeneric<Produit> daoProduit = new DAOGeneric<Produit>(new Produit());
            daoProduit.insert(annonce);

            req.setAttribute("messageErreur", "Votre annonce a bien été saisi");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        } catch (InstantiationException ex) {
            Logger.getLogger(DeposeAnnonceCTRL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DeposeAnnonceCTRL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
