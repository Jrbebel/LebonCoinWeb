/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oh.tests;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.Produit;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author jrbebel
 */
public class RechercherProduit {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        DAOGeneric<Produit> daoProduit = new DAOGeneric<Produit>(new Produit());
        String mot = "voiture";
        System.out.println(daoProduit.RechercheProduit(mot));

    }

}
