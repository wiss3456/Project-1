<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="login.css">
    <title>School drivers</title>
	
</head>

<body>
   
 

    <div class="container" id="container">
        <div class="form-container sign-up">
            <form action="Servlet1">
                <h1>Create Account</h1>
                
                <span>Use your email for registeration</span>
                <input type="text" placeholder="First Name" name="First Name" required>
				 <input type="text" placeholder="Last Name" name="Last Name" required>
				  <input type="number" placeholder="Age"  name="Age" required>
				   <input type="text" placeholder="Adress" name="Adress" required>
				    <input type="text" placeholder="Number" name="Number" required>
                <input type="email" placeholder="Email"  name="Email" required>
				 <input type="text" placeholder="Login" name="Login" required>
                <input type="password" placeholder="Password" name="Password" required>
				               
                <button name="op" value="insc">Sign Up</button>
            </form>
        </div>
        <div class="form-container sign-in">
            <form action="Servlet1" >
                <h1>Sign In</h1>
                
                <span>Use your Login && password</span>
                <input type="text" placeholder="Login" name="login">
                <input type="password" placeholder="Password" name="password">
                <button name="op" value="auth">Sign In</button>
                
                <%if(request.getAttribute("msg")!=null){%>
                	 <%= request.getAttribute("msg").toString()%>
            <%}%>
            
            </form>
        </div>
		<div class="ana">
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Welcome !!</h1>
                    <p>Enter your personal details to use all of site features</p>
                    <button class="hidden" id="login">Sign In</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Hello, Future driver !</h1>
                    <p>Register with your personal details to use all of site features</p>
                    <button class="hidden" id="register">Sign Up</button>
                    
                </div>
            </div>
			</div>
        </div>
    </div>

    <script >
	const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
});
</script>
</body>

</html>

