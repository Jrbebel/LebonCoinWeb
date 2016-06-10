/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.oh.entities;

import java.lang.reflect.Field;

/**
 *
 * @author formation
 */
abstract class AbstractEntity {
    
    public String getTriggerScope(){
        
        return null;
    }
    
    /**
     * 
     * @return Field[] 
     */
    public Field[] getAttributes(){
        return getClass().getDeclaredFields();
    }
    
    /**
     * 
     * @return String EntityName
     */
    public String getEntityName(){
        return getClass().getName();
    }
    
    /**
     * 
     * @return int nombre d'attributs du DTO
     */
    public int getNbAttributes(){       
       return getClass().getDeclaredFields().length;
    }
}
