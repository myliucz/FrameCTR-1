<%--
  Created by IntelliJ IDEA.
  User: myliucz
  Date: 2018/4/25
  Time: 下午10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="<%=request.getContextPath()%>/decide.do" method="post">
        name:<input type="text" name="name"/>
        <br>
        password: <input type="text" name="password"/>
      <input type="submit"/>
    </form>
  </body>
</html>
