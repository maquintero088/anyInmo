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
public class Feed {
    private String[][] Matrix_Feed;
    
    public String [][] getDataFeed(String Criteria,boolean pages){   
        Matrix_Feed = new Dataset().getVInmo_Strings(Criteria,pages);        
        return Matrix_Feed;        
    }
    
}
