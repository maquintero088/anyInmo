/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qcmarcel.AnyInmo2.View;


import com.qcmarcel.AnyInmo2.Controller.Dataset;
import com.qcmarcel.AnyInmo2.Model.Feed;
import java.util.Date;

/**
 *
 * @author pc
 */
public class FeedView {
    private String String_Feed="";
    private String Back;
    private String Next;
    
    public String getStampDate(){
        return String.valueOf(new Date());
    }
    
    public String getFeed(String Criteria,boolean pages){
        String[][] feed_Strings = new Feed().getDataFeed(Criteria,pages);
        if(feed_Strings.length<=0){
            return "No hay Inmuebles disponibles";
        }
        Back = getBackString(feed_Strings[0][1]);
        for (int rows = 0; rows<feed_Strings.length;rows++) {
            System.out.println("lat: "+feed_Strings[rows][3]+" lon: "+feed_Strings[rows][2]);
            String_Feed += "<article>"+
                    "<form name=\"Feed_form\" action=\"\" method=\"post\"/>"
                    + "<input name=\"ID\" type=\"hidden\" value=\"" + feed_Strings[rows][0] + "\" />" 
                    + "<table>" + "<tr><td class=\"head\"><h3>" + feed_Strings[rows][7]+" - "+feed_Strings[rows][1] + "</h3></td></tr>" + "<tr><td>" 
                    +       "<table>" 
                    +       "<tr>" + "<td>"
                    +                   "<object data=\"maps.jsp?lat="+feed_Strings[rows][3]+"&lon="+feed_Strings[rows][2]+"\" width=\"90%\" height=\"300\"></object> "
                    +               "</td>" + "<td> </td>" +  "</tr>"   
                    +       "<tr>" + "<td>"
                    +           "<table class=\"content\">" 
                    +           "<tr>" + "<td> Class:  " + feed_Strings[rows][5] + "  </td>" 
                    +           "<td> Agreement:  " + feed_Strings[rows][6] + "  </td>" + "</tr>"
                    +           "<tr>" + "<td> Boss:    " + feed_Strings[rows][8] + " </td>"  
                    +           "<td> State:  " + feed_Strings[rows][10] + " </td>" + "<td>  </td>" +  "</tr>"
                    +           "</table>"
                    +       "</td>" + "<td> </td>" +  "</tr>"
                    +       "</table>" 
                    + "</td></tr>" + "<tr><td class=\"foot\"><h2>" + feed_Strings[rows][9] + "</h2></td></tr>" + "</table>" + 
                    "</form>" + "</article>";
            if(/*feed_Strings[rows+1][0]==null||*/(rows+1)==feed_Strings.length){
                Next = getNextString(feed_Strings[rows][1]);
                String_Feed +=""
                        + "<article>"                        
                        + "<table>"
                        + "<tr><td>"
                        + Back
                        + "</td><td>"
                        + Next
                        + "</td></tr>"
                        + "</table>"                         
                        + "</article>";
            }
        }
        return String_Feed;        
    }

    private String getBackString(String feed_String) {
        String Back_String = "";
        if(!new Dataset().valores("V_Inmo", "max(History)", "max(History)")[0].equals(feed_String)){
            Back_String = ""
                    + "<form name=\"Feed_form\" action=\"principal.jsp\" method=\"post\"/>"
                    + "     <input name=\"Criteria\" type=\"hidden\" value=\" where History > '" + feed_String + "'\" />"
                    + "     <input name=\"Next\" type=\"submit\" value=\"Back\"/>"
                    + "</form>" ;
        }        
        return Back_String;        
    }
    private String getNextString(String feed_String) {
        String Next_String = "";
        if(!new Dataset().valores("V_Inmo", "min(History)", "min(History)")[0].equals(feed_String)){
            Next_String = ""
                    + "<form name=\"Feed_form\" action=\"principal.jsp\" method=\"post\"/>"
                    + "     <input name=\"Criteria\" type=\"hidden\" value=\" where History <= '" + feed_String + "'\" />"
                    + "     <input name=\"Next\" type=\"submit\" value=\"Next\"/>"
                    + "</form>" ;
        }
        return Next_String;        
    }
}

//width=\"400\" height=\"300\"
