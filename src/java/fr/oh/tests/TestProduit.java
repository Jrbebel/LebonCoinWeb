/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oh.tests;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.Produit;
import java.util.List;

/**
 *
 * @author jrbebel
 */
public class TestProduit {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        DAOGeneric<Produit> daoPays = new DAOGeneric<Produit>(new Produit());
        List<Produit> Produit = daoPays.findAll();

        for (Produit produit : Produit) {
            
            System.out.println(produit.getDescriptionProduit());
            
        }

    }
}
