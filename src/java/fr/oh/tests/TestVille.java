/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oh.tests;

import fr.oh.daos.DAOGeneric;
import fr.oh.entities.Ville;

/**
 *
 * @author jrbebel
 */
public class TestVille {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        
        DAOGeneric<Ville> daoVilles = new DAOGeneric<Ville>(new Ville());
        Ville villetrouve = daoVilles.findOne(2);
        System.out.println("Ville" + villetrouve);
    }

}
