<%-- 
    Document   : chamcong
    Created on : Aug 18, 2022, 11:42:55 AM
    Author     : NamDoan
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cham Cong</title>
        <style>
            *{
               margin: 0px;
               font-size: 16px;
            }
            
            
        </style>
    </head>
    
    <body>
       <jsp:useBean id="dt" class="datesos.DateEtOEt"/>
       <h1 style="font-size: 32px">Check Working August</h1>
       
       <div id="wapper">
        <table border="1px" >
            <tr>
                <td>STT</td>
                <td>Ho va Ten</td>
                <c:forEach items="${requestScope.dates}" var="d">
                    <td><fmt:formatDate pattern = "dd" 
                                    value = "${d}" /></td>
                </c:forEach>
                <td>Working days</td>
                <td>Working hours</td>
            </tr>
        </table> 
       </div>
    </body>
</html>
