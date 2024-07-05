<%-- 
    Document   : principal
    Created on : 11/07/2015, 12:28:44 PM
    Author     : pc
--%>

<%@page import="com.qcmarcel.AnyInmo2.View.FeedView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AnyInmo - Home</title>
        <meta http-equiv="X-UA-Compatible" content="IE=11" />
        <link href="images/favicon.png" type="image/x-icon" rel="shortcut icon" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <%@include file="template/smartadmin/template.jspf" %>
    </head>
    <body>
        <header>
            <table>
                <tr>
                    <td>
                        <img src="images/favicon.png" height="100px" alt="logo">
                    </td>
                    <td class="right">
                        <img src="images/pekcell.png" height="80px" alt="logop">
                    </td>
                </tr>
            </table>  
</header>
<nav>
  <table>
    <tbody>
      <tr>
          <td class="tdnav">
        <a href="search.jsp" title="nav1">Search</a>
        </td>
        <td class="tdnav">
        <a href="GPS.jsp" title="nav1">GPS</a>
        </td>
        <td class="tdnav">
        <a href="session.jsp" title="nav1">Profile</a>
        </td>
      </tr>
    </tbody>
  </table>
    
</nav>
<section>
    <%= new FeedView().getFeed(request.getParameter("Criteria"),true)%> 
</section>
<footer>
Márcel Armando Quintero Carrillo
<br/>
Todos los derechos reservados - <%= new FeedView().getStampDate() %>
</footer>
 <%@include file="template/smartadmin/scripts.jspf" %>
    </body>
</html>
