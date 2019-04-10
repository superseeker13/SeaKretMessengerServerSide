<%@ page language="java" import="java.util.*,java.lang.*" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
<style>
#accounts {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 75%;
}

#accounts td, #accounts th {
  border: 1px solid #ddd;
  padding: 5px;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  margin-top: 6px;
  margin-bottom: 16px;
  border: none;
  cursor: pointer;
}

#accounts tr:nth-child(even){background-color: #f2f2f2;}

#accounts tr:hover {background-color: #ddd;}

/* Table Header Details */
#accounts th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
  <div style="text-align:">
    <h2>SEAKRET Messenger List of Accounts</h2>
  </div>
<form action="AdminLoginCheck.jsp">
<input type="submit" value="Admin Logout" onclick="form.action='AdminLoginPage.jsp';">
</form>
<table id="accounts">
  <tr>
    <th>Username</th>
    <th>Password</th>
  </tr>
<%-- JSP CODE --%>
<%
String fileName = "c:\\Accounts\\accounts.csv";
String line;
FileInputStream fis = new FileInputStream(fileName);
DataInputStream dis = new DataInputStream(fis);
%>
<%
while ((line = dis.readLine()) != null) {
    String strar[] = line.split(",");
%>
    <tr>
    <td><% out.print(strar[0]); %></td>
    <td><% out.print(strar[1]); %></td>
    </tr>
<%
} 
%>
</table>
</body>
</html>

       
