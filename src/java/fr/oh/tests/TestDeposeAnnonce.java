/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oh.tests;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.Client;
import fr.oh.entities.Pays;
import fr.oh.entities.Produit;
import fr.oh.entities.SousCategorieProduit;
import java.util.Date;

/**
 *
 * @author jrbebel
 */
public class TestDeposeAnnonce {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Client clientByiIdClient = new Client();
        DAOGeneric<Client> daoClient = new DAOGeneric<Client>(clientByiIdClient);
        Client client = daoClient.findOne(10);
        SousCategorieProduit sousCategorieProduit = new SousCategorieProduit();
        sousCategorieProduit.setIdSousCategorieProduit(1);
        String designationProduit = "Voiture lrg malaee";
        float prix = 1220;
        Date dateMiseEnVenteProduit = new Date("12/12/2015");
        String descriptionProduit = "je suis un produit";
        Produit annonce = new Produit(client, sousCategorieProduit, designationProduit, prix, dateMiseEnVenteProduit, descriptionProduit);
        DAOGeneric<Produit> daoProduit = new DAOGeneric<Produit>(new Produit());
        daoProduit.insert(annonce);
    }
}
