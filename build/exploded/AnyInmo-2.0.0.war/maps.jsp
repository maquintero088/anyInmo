

<%-- 
    Document   : maps
    Created on : 13/07/2015, 05:51:01 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>maps</title>
        <script src="http://maps.googleapis.com/maps/api/js"></script>
        <script type="text/javascript">
            var Location = new google.maps.LatLng(<%= request.getParameter("lat")%>,<%= request.getParameter("lon")%>);
            function initialize(){
                var mapProp ={
                    center:Location,
                    zoom:18,
                    mapTypeId:google.maps.MapTypeId.HYBRID
                };
                var map= new google.maps.Map(document.getElementById("googleMap"),mapProp); 
                var marker=new google.maps.Marker({
                    position:Location,
                });                
                marker.setMap(map);
            }
            google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </head>
    <body>
        <div id="googleMap" style="width:100%;height:380px;"></div>
    </body>
</html>
