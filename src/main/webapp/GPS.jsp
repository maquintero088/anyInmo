<%-- 
    Document   : search
    Created on : 15/07/2015, 11:13:44 AM
    Author     : pc
--%>

<%@page import="com.qcmarcel.AnyInmo2.View.GPSView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AnyInmo - GPS</title>
        <meta http-equiv="X-UA-Compatible" content="IE=11" />
        <link href="images/icono_anyinmo.png" type="image/x-icon" rel="shortcut icon" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="http://maps.googleapis.com/maps/api/js"></script>
       <script type="text/javascript">
            var Location = new google.maps.LatLng(22.5403217,-17.1757873);
            <%=new GPSView().getLocations(request.getParameter("Criteria"))%>
            function initialize(){
                var mapProp ={
                    center:Location,
                    zoom:10,
                    mapTypeId:google.maps.MapTypeId.HYBRID
                };
                var map= new google.maps.Map(document.getElementById("googleMap"),mapProp);
                <%=new GPSView().getMarkets(request.getParameter("Criteria"))%>
            }
            google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </head>
    <body>
        <div id="googleMap" style="width:400px;height:350px;"></div>
    </body>
</html>

                <!--var marker=new google.maps.Marker({
                    position:Location,
                });                
                marker.setMap(map);-->