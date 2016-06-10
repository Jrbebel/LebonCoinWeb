/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oh.tests;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.Pays;
import java.util.List;

/**
 *
 * @author jrbebel
 */
public class TestPays {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Pays pays = new Pays();
        DAOGeneric<Pays> daoPays = new DAOGeneric<Pays>(new Pays());
        List<Pays> Pays = daoPays.findAll();

        for (Pays Pay : Pays) {
            System.out.println(Pay.getNomPays());
        }

    }
}
