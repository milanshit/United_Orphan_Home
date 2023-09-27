<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/usersRegister-style.css">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

   <title>Responsive Register Form </title>
   <style>
   	.logo {
	   position: fixed;
	   margin-top: 15px;
	   margin-left: 20px;
	   width: 60px;
	   height: 60px;
	   clip-path: circle();
	}
   </style>
</head>
<body>
	<img src="image/logo.jpeg" class="logo">
    <div class="container">
        <header>User Sign Up Form</header>

        <form action=UserRegister method="POST">
            <div class="form Sfirst">
                <div class="details personal">
                    <span class="title">Personal Details</span>

                    <div class="fields">
                        <div class="input-field">
                            <label>Full Name</label>
                            <input type="text" placeholder="Enter your name" name="name" required>
                        </div>

                        <div class="input-field">
                            <label>Email</label>
                            <input type="email" placeholder="Enter your email" name="email" required>
                        </div>

                        <div class="input-field">
                            <label>Mobile Number</label>
                            <input type="number" placeholder="Enter mobile number" name="phone_number" required>
                        </div>
						
						<div class="input-field">
                            <label>Gender</label>
                            <select name="gender" required>
                                <option disabled selected value="0">Select gender</option>
                                <option value="1">Male</option>
                                <option value="2">Female</option>
                                <option value="3">Others</option>
                            </select>
                        </div>

                        <div class="input-field">
                            <label>Password</label>
                            <input type="password" placeholder="Enter your password" name="password" required>
                        </div>
                        
                        <div class="input-field">
                            <label>Confirm Password</label>
                            <input type="password" placeholder="Enter your confirm password" name="confirm_password" required>
                        </div>
                    </div>
                </div>

                <div class="details ID">
                    <span class="title">Address Details</span>

                    <div class="fields">
                        <div class="input-field">
                            <label>City</label>
                            <input type="text" placeholder="Enter your city" name="city" required>
                        </div>

                        <div class="input-field">
                            <label>State</label>
                            <input type="text" placeholder="Enter your state" name="state" required>
                        </div>

                        <div class="input-field">
                            <label>Country</label>
                            <input type="text" placeholder="Enter your country" name="country" required>
                        </div> 
                	</div> 
                	
                	<div class="details ID">

                    <div class="fields">
                        <div class="input-field">
                            <button type="submit" class="nextBtn">
                       		 <span class="btnText">Submit</span>
                    		</button>
                        </div>

                        <div class="input-field">
                           <a href="LoginPage" style="text-decoration: none;">
                             <button type="button" class="nextBtn">
	                       	 	<span class="btnText">Back</span>
	                    	 </button>
	                      </a>
                        </div>

                        <div class="input-field">
                        </div> 
                	</div>
                </div>
            </div>
		 </div>
        </form>
    </div>

</body>
</html>