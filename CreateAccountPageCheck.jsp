<%@ page import="javaHandler.csvFileWriter" %>
<%@ page import="javaHandler.csvFileReader" %>

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
  </div>
  <div class="row">
    <div class="column">
    </div>
    <div class="column">
        <form action="CreateAccountPageCheck.jsp">
        <label for="Uname">Username</label>
        <input type="text" id="Uname" name="username" placeholder="JohnSmith">
        <label for="Pword">Password</label>
        <input type="password" id="Pword" name="password" placeholder="Enter Your Password...">
        <label for="CPword">Confirm Password</label>
        <input type="password" id="CPword" name="cpassword">
        <input type="submit" value="Submit">
        </form>
        <%-- JSP/Java interation --%>
        <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        
        // Check if any field is empty
        if((username == null || (username.equals(""))) || (password == null || (password.equals(""))) || (cpassword == null || (cpassword.equals("")))) {
        %>
        <p style="color:red;">Field(s) Missing account information!</p>
        <%
        }
        // Check to make sure the password matches the confirmed password field
        else if(!(password.equals(cpassword))) {
        %>
        <p style="color:red;">Password does not match!</p>
        <%
        }
        else if(csvFileReader.isUsernameTaken("accounts.csv", username)){
        %>
        <p style="color:red;">Username is already taken!</p>
        <%
        }
        // Check to make sure it falls within the minimum and maximum amount of characters
        else if(!((username.length() >= 5) && (username.length() <= 32))) {
        %>
        <p style="color:red;">Username must be a minimum of 5 characters and a maximum of 32 characters!</p>
        <%
        }
        // Everything Checks Out
        else {
            System.out.println(username + " " + password);
            String fileName = "accounts.csv";
            csvFileWriter.writeCsvFile(fileName, username, password);
            String redirect = "create_account_Response.jsp";
            response.sendRedirect(redirect);
        }
        
        %>
    </div>
  </div>
</div>

</body>
</html>
