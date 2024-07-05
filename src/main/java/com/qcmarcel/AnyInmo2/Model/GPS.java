/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qcmarcel.AnyInmo2.Model;

import com.qcmarcel.AnyInmo2.Controller.Dataset;



/**
 *
 * @author pc
 */
public class GPS {
    private String[][] Locations_Strings;
    
    public String [][] getLocations(String Criteria){
        String [][] VInmo_Strings = new Dataset().getVInmo_Strings(Criteria, false);
        Locations_Strings = new String [VInmo_Strings.length][3];
        for(int rows = 0 ; rows < VInmo_Strings.length ; rows ++){
            Locations_Strings [rows][0] = VInmo_Strings[rows][0];
            Locations_Strings [rows][1] = VInmo_Strings[rows][3];
            Locations_Strings [rows][2] = VInmo_Strings[rows][2];
        }
        return Locations_Strings;        
    }
    
}
