/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.oh.tests;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.Pays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author formation
 */
public class TestReflexivite {
    
    public static void main(String[] args) {
        try {
           Pays pays = new Pays("Italie", "40", "37");
           
            DAOGeneric<Pays> daoPays = new DAOGeneric<Pays>(new Pays());
              System.out.println(daoPays.insert(pays));
//            List<Pays> lPays = daoPays.findAll();
//            System.out.println(lPays.get(0).getNomPays());
            
//           Pays nPays = daoPays.findOne(1);
//           System.out.println(nPays.getNomPays());
            
            
        } catch (InstantiationException ex) {
            Logger.getLogger(TestReflexivite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TestReflexivite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}