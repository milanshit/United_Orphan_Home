<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!----======== CSS ======== -->
    <link rel="stylesheet" href="css/orphanage-register-style.css">

    <!----===== Iconscout CSS ===== -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

    <title>Orphanage Sign Up Form</title>
</head>

<body>
    <div class="container">
        <header>Orphanage Sign Up Form</header>

        <form action=OrphanageRegister method="POST">
            <div class="form first">
                <div class="details personal">
                    <span class="title">Personal Details</span>

                    <div class="fields">
                        <div class="input-field">
                            <label>Full Name</label>
                            <input type="text" placeholder="Enter your name" name="name" required>
                        </div>

                        <div class="input-field">
                            <label>Register Id</label>
                            <input type="number" placeholder="Enter your register id" name="registration_id" required>
                        </div>

                        <div class="input-field">
                            <label>Email</label>
                            <input type="text" placeholder="Enter your email" name="email" required>
                        </div>

                        <div class="input-field">
                            <label>Mobile Number-1</label>
                            <input type="number" placeholder="Enter number-1" name="phone_number_1" required>
                        </div>
                        <div class="input-field">
                            <label>Mobile Number-2 </label>
                            <input type="number" placeholder="Enter number-2" name="phone_number_2" required>
                        </div>

                        <div class="input-field">
                            <label>Password</label>
                            <input type="password" placeholder="Enter your password" name="password" required>
                        </div>

                        <div class="input-field">
                            <label>Confirm Password</label>
                            <input type="password" placeholder="Enter confirm password" name="confirm_password" required>
                        </div>
                        <div class="input-field">
                            <label>Address</label>
                            <input type="text" placeholder="Enter your address" name="address" required>
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

                           <label for="input-field">Description</label>
                            <textarea rows="3" placeholder="your message" name="description"></textarea>

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
