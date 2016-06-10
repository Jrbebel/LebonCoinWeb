/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oh.tests;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.Client;
import fr.oh.entities.Ville;
import java.util.TreeMap;

/**
 *
 * @author jrbebel
 */
public class TestConnexion {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        String mdp = "a";
        String user = "b";
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("pseudoClient", user);
        map.put("mdpClient", mdp);

        Client client = new Client();
        DAOGeneric<Client> daoClients = new DAOGeneric<Client>(client);
        Client clients = daoClients.findbyOne(map);
        System.out.println("Nom : " + clients.getNomClient());
    }

}
