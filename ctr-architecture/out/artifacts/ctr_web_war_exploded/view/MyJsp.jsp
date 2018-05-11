<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="services.vo.MessVo" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  

  </head>
  
  <body>
     <% 
 
    MessVo mess=(MessVo)request.getAttribute("messa");

     %>
     <table border="2" width="80%">
     <tr>
     <td><%=mess.getAaa()%></td>
     <td><%=mess.getBbb()%></td></tr>
     <tr>
     <td><%=mess.getCcc()%></td>
     <td><%=mess.getDdd()%></td>
     </tr>
      </table> 
  </body>
</html>
