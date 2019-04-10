<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

/* Style inputs */
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=password], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

/* Style the container/account creation section */
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 10px;
}

/* Create two columns that float next to eachother */
.column {
  float: center;
  width: 50%;
  margin-top: 6px;
  padding: 20px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}


</style>
</head>
<body>

<div class="container">
  <div style="text-align:">
    <h2>Create a SEAKRET Messenger Account</h2>
    <h3>Administrator Login</h3>
  </div>
  <div class="row">
    <div class="column">
    </div>
    <div class="column">
        <form action="AccountLoginCheck.jsp">
        <label for="Uname">Username</label>
        <input type="text" id="Uname" name="username" placeholder="Admin Username">
        <label for="Pword">Password</label>
        <input type="password" id="Pword" name="password" placeholder="Admin Password">
        <input type="submit" value="Admin Login" onclick="form.action='AdminLoginCheck.jsp';"> <input type="submit" value="Register An Account" onclick="form.action='CreateAccountPage.jsp';"> 
        </form>
        <%-- JSP/Java interation --%>
        <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        %>
        <%
        // Check to see if the username and password fields are populated
        if((username == null || (username.equals(""))) || (password == null || (password.equals(""))))
        {
        %>
        <p style="color:red;">Field(s) Missing Administrator Account Information!</p>
        <%
        }
        // BASIC ADMINISTRATOR USERNAME AND PASSWORD SET HERE
        // Check to see if the username and password is correct
        else if(!(username.equals("Admin") && password.equals("abcd")))
        {
        %>
        <p style="color:red;">Username/Password Is Invalid!</p>
        <%
        }
        // Everything checks out go to account page
        else {
        String redirect = "AccountList.jsp";
        response.sendRedirect(redirect);
        }
        %>
    </div>
  </div>
</div>

</body>
</html>
