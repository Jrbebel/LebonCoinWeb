/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbb.oh.controls;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.CategorieClient;
import fr.oh.entities.Client;
import fr.oh.entities.Pays;
import fr.oh.entities.Ville;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class InscriptionCTRL extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pays pays = new Pays();
        DAOGeneric<Pays> daoPays;
        try {
            daoPays = new DAOGeneric<Pays>(new Pays());
            List<Pays> Pays = daoPays.findAll();
            req.setAttribute("Pays", Pays);
        } catch (InstantiationException ex) {
            Logger.getLogger(InscriptionCTRL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InscriptionCTRL.class.getName()).log(Level.SEVERE, null, ex);
        }

//        for (Pays Pay : Pays) {
//            System.out.println(Pay.getNomPays());
//        }
        getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            /**
             * On recupere les name dans les inputs
             */
            CategorieClient categorieClient = new CategorieClient();
            categorieClient.setIdCategorieClient(1);
            String nomClient = req.getParameter("nom");
            String prenomClient = req.getParameter("prenom");
            String telephoneClient = req.getParameter("telephone");
            String emailClient = req.getParameter("email");
            String adresseClient = req.getParameter("adresse");
            String pseudoClient = req.getParameter("pseudo");
            String mdpClient = req.getParameter("pwd");
            String siretClient = req.getParameter("email");
            PrintWriter out = resp.getWriter();
            //  out.print("prenom du client" + prenomClient);
            DAOGeneric<Ville> daoVilles = null;
            try {
                daoVilles = new DAOGeneric<Ville>(new Ville());
            } catch (InstantiationException ex) {

                req.setAttribute("messageErreur", "sql: " + ex);
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

            } catch (IllegalAccessException ex) {

                req.setAttribute("messageErreur", "sql: " + ex);
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            Ville villetrouve = daoVilles.findOne(2);
            Client client = new Client(categorieClient, villetrouve, nomClient, prenomClient, telephoneClient, emailClient, adresseClient, null, null, pseudoClient, mdpClient, Short.MIN_VALUE, siretClient, null, null);
            DAOGeneric<Client> daoPays = new DAOGeneric<Client>(new Client());
            daoPays.insert(client);
            req.setAttribute("messageErreur", "Vous êtes bien enregister, Veuillez vous reconnectez");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (InstantiationException ex) {
            Logger.getLogger(InscriptionCTRL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InscriptionCTRL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
