<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <link rel="stylesheet" href="Acceuil.css">
</head>
<body>
<div class="disconnect-link">
        <i ><img src="steering-wheel.png" width="40px" height="40px"></i>
		 <a href="login.jsp" >
		 <button id="disconnect-btn">Disconnect</button>
       </a>
        <i><img src="iot.png" width="40px" height="40px"></i>
 </div>
    <div class="container">
        <div class="menu">
            <button class="button" onclick="window.location.href='#'">Book a seat</button>
          <button class="button" onclick="window.location.href='http://127.0.0.1:1880/ui'">Dashboard</button>
            <button class="button" onclick="window.location.href='payer.jsp'">Pay online</button>
        </div>
    </div>
</body>
</html>
