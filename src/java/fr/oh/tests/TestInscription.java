/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oh.tests;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import fr.oh.daos.DAOGeneric;
import fr.oh.entities.CategorieClient;
import fr.oh.entities.Client;
import fr.oh.entities.Departement;
import fr.oh.entities.Pays;
import fr.oh.entities.Region;
import fr.oh.entities.Ville;

/**
 *
 * @author jrbebel
 */
public class TestInscription {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        CategorieClient categorieClient = new CategorieClient();
        categorieClient.setIdCategorieClient(1);

        String nomClient = "BEBEL";
        String prenomClient = "Jean-raynal";
        String telephoneClient = "06995524";
        String emailClient = "jeanra@gmaill.com";
        String adresseClient = "bananier";
        String pseudoClient = "jrbebel";
        String mdpClient = "jrbebel";
        String siretClient = "0211254555";

        DAOGeneric<Ville> daoVilles = new DAOGeneric<Ville>(new Ville());
        Ville villetrouve = daoVilles.findOne(2);
        Client client = new Client(categorieClient, villetrouve, nomClient, emailClient, adresseClient, pseudoClient, mdpClient);
        DAOGeneric<Client> daoPays = new DAOGeneric<Client>(new Client(categorieClient, villetrouve, nomClient, emailClient, adresseClient, pseudoClient, mdpClient));
        daoPays.insert(client);

    }

}
