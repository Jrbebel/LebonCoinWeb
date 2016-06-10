/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbb.oh.controls;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.Client;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ConnexionCTRL extends HttpServlet {

    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_SESSION_USER_ID = "idUtilisateur";
    public static final String VUE = "/index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();//je cree ma session
        session.setAttribute(ATT_SESSION_USER, null);

        getServletContext().getRequestDispatcher(VUE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            String mdp = req.getParameter("mdp"); // recupere le mot de passe
            String email = req.getParameter("email"); //recupere l'email 

            /**
             * On verifie si les deux chamsp sont rempli*
             */
            if (mdp.length() == 0 || email.length() == 0) {
                out.print("je suis pas de mdp");
                req.setAttribute("messageErreur", "Les champs doivent etre remplie");
                getServletContext().getRequestDispatcher(VUE).forward(req, resp);

            }

            Client clients = null;
            /**
             * On cree une session si il est bien connecté*
             */
            /* Mise en session d'une chaîne de caractères */

            TreeMap<String, String> map = new TreeMap<String, String>();
            map.put("emailClient", email);
            map.put("mdpClient", mdp);

            Client client = new Client();
            DAOGeneric<Client> daoClients = new DAOGeneric<Client>(client);
            clients = daoClients.findbyOne(map); // le resultat de la requete
            if (clients == null) { //si c'est null il  a pas trouve
                req.setAttribute("messageErreur", "Mot de passe ou login incorect");
                getServletContext().getRequestDispatcher(VUE).forward(req, resp);
            } else { //requete bonne 
                HttpSession session = req.getSession();//je cree ma session
                String user = "UserConnexion";

                session.setAttribute(ATT_SESSION_USER, clients.getNomClient() + " " + clients.getPrenomClient());
                session.setAttribute(ATT_SESSION_USER_ID, clients.getIdClient());
                        getServletContext().getRequestDispatcher(VUE).forward(req, resp);
            }

        } catch (InstantiationException ex) {

            req.setAttribute("messageErreur", "Erreur sql" + ex);
            getServletContext().getRequestDispatcher(VUE).forward(req, resp);

        } catch (IllegalAccessException ex) {
            req.setAttribute("messageErreur", "Erreur sql" + ex);
            getServletContext().getRequestDispatcher(VUE).forward(req, resp);
        }

    }

}
