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
    <h3>User Login</h3>
  </div>
  <div class="row">
    <div class="column">
    </div>
    <div class="column">
        <form action="FILLERHERE.jsp">
        <label for="Uname">Username</label>
        <input type="text" id="Uname" name="username" placeholder="Username">
        <label for="Pword">Password</label>
        <input type="password" id="Pword" name="password" placeholder="Password">
        <input type="submit" value="User Login" onclick="form.action='FILLERHERE.jsp';"> <input type="submit" value="Register An Account" onclick="form.action='CreateAccountPage.jsp';"> 
        </form>
    </div>
  </div>
</div>
</body>
</html>
