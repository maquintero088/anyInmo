/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author pc
 */
public class GPS {
    private String Locations_String = "";
    
    public String getLocations(String Criteria){
        String [][] Locations_Strings = new Model.GPS().getLocations(Criteria);
        for (String[] Locations_String1 : Locations_Strings) {
            System.out.println("lat: "+Locations_String1[1]+" lon: "+Locations_String1[2]);
            Locations_String += "\n"
                    + "     var Location_" + Locations_String1[0]+ " = new google.maps.LatLng(" + Locations_String1[1] + "," + Locations_String1[2] + ");" 
                    + "\n";
        }
        return Locations_String;        
    }
    
    public String getMarkets(String Criteria){
        String [][] Locations_Strings = new Model.GPS().getLocations(Criteria);
        for (String[] Locations_String1 : Locations_Strings) {
            System.out.println("lat: "+Locations_String1[1]+" lon: "+Locations_String1[2]);
            Locations_String += "\n"
                    + "     var marker_" + Locations_String1[0] + "=new google.maps.Marker({\n" 
                    + "                 position:Location_" + Locations_String1[0] + ",\n" 
                    + "     });\n" 
                    + "     marker_" + Locations_String1[0] + ".setMap(map);\n" 
                    + "\n";
        }
        return Locations_String;        
    }
}
