/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oh.tests;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.CategorieClient;
import fr.oh.entities.Client;
import fr.oh.entities.SousCategorieProduit;
import java.util.List;

/**
 *
 * @author jrbebel
 */
public class TestCategorie {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        SousCategorieProduit sscat = new SousCategorieProduit();
        DAOGeneric<SousCategorieProduit> daosscat = new DAOGeneric<SousCategorieProduit>(sscat);
        List <SousCategorieProduit> sscategorie =  daosscat.findAll();
        for (SousCategorieProduit sousCategorieProduit : sscategorie) {
            System.out.println(sousCategorieProduit.getSousCategorieProduit());
        }

    }

}
