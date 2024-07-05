/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//<script src="http://maps.googleapis.com/maps/api/js"></script>

function initialize(){
    var 
            lat = document.getElementById("lat"),
            lon = document.getElementById("lon");
    var mapProp ={
        center:new google.maps.LatLng(lat,lon),
        zoom:5,
        mapTypeId:google.maps.MapTypeId.ROADMAP
    };
    var map= new google.maps.Map(document.getElementById("googleMap"),mapProp);
    
}
google.maps.event.addDomListener(window, 'load', initialize);