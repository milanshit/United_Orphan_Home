<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Sign in</title>
    <link rel="stylesheet" href="css/login-style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>

  <div class="container">
    <div class="cover">
      <div class="front">
        <img src="image/login/frontImg.jpg" alt="">
        <div class="text">
          <span class="text-1">Every new child is a <br> new adventure</span>
          <span class="text-2">Let's get connected</span>
        </div>
      </div>
      <div class="back">
        <img class="backImg" src="images/backImg.jpg" alt="">
        <div class="text">
          <span class="text-1">Complete miles of journey <br> with one step</span>
          <span class="text-2">Let's get started</span>
        </div>
      </div>
    </div>
    <div class="forms">
        <div class="form-content">
          <div class="login-form">
            <div class="title">Login</div>
          <form action=LoginPage method=post>
            
              <div class="input-box">
                <i class="fas fa-envelope"></i>
                <input type="text" placeholder="Enter your email" name="email" required>
              </div>
              <div class="input-box">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Enter your password" name="password" required>
              </div>
              <div class="text"></div>
              <div class="button input-box">
                <input type="submit" value="Sumbit">
              </div>
              <div class="text sign-up-text">Don't have an account? 
				 <c:if test="${sessionScope.role  == 'user'}">
       	  			<a href="<%=request.getContextPath()%>/UserRegisterForm" class="btn btn-primary" >Sign Up</a><br>	        
			     </c:if>
			    
			    <c:if test="${sessionScope.role  == 'orphanage'}">
       	  			<a href="<%=request.getContextPath()%>/OrphanageRegisterForm" class="btn btn-primary" >Sign Up</a><br>	        
			    </c:if>
			</div>
        </form>
      </div>
    </div>
    </div>
  </div>
</body>
</html>














