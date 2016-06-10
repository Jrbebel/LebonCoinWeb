/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oh.tests;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.CategorieProduit;
import fr.oh.entities.SousCategorieProduit;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author jrbebel
 */
public class TestCategorieSousProduit {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        TreeMap<String, String> map = new TreeMap<String, String>();
        CategorieProduit catPro = new CategorieProduit();
        DAOGeneric<CategorieProduit> daocatpro = new DAOGeneric<CategorieProduit>(catPro);

        SousCategorieProduit sscat = new SousCategorieProduit();
        DAOGeneric<SousCategorieProduit> daosscat = new DAOGeneric<SousCategorieProduit>(sscat);

        List<CategorieProduit> categoriepro = daocatpro.findAll();

        for (CategorieProduit CategorieProduit : categoriepro) {

            System.out.println("------->" + CategorieProduit.getCategorieProduit() + "<--------");
            map.put("ID_CATEGORIE_PRODUIT", String.valueOf(CategorieProduit.getIdCategorieProduit()));
            List<SousCategorieProduit> sscategorie = daosscat.findby(map);

            for (SousCategorieProduit sousCategorieProduit : sscategorie) {

                System.out.println(sousCategorieProduit.getSousCategorieProduit());

            }

        }
    }
}
