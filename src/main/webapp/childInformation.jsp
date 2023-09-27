<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!----======== CSS ======== -->
    <link rel="stylesheet" href="css/childinformation-style.css">

    <!----===== Iconscout CSS ===== -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

    <title>NGO Child Info </title>
</head>

<body>

    <div class="container">
        <header>Child Information
        	<c:if test="${new_child !=null}">
            			Update
            </c:if>
			<c:if test="${new_child ==null}">
            			Add
           </c:if>
        
        </header>

        <c:if test="${new_child !=null}">
			<form action="UpdateChild" method="post">
			
			
			<div class="form first">
                <div class="details personal">	
				
					<c:if test="${new_child !=null}">
						<input type="hidden" name="id" value="<c:out value='${new_child.getChild_id()}' />" />
					</c:if>

                    <div class="fields">
                        <div class="input-field">
                            <label>Full Name</label>
                            <input type="text" value="<c:out value='${new_child.getName()}' />" name="name" required>
                        </div>

                        <div class="input-field">
                            <label>Age</label>
                            <input type="number" value="<c:out value='${new_child.getAge()}' />" name="age" required>
                        </div>

                        <div class="input-field">
                            <label>Date of Birth</label>
                            <input type="date" value="<c:out value='${new_child.getDob()}' />" name="dob" required>
                        </div>

 
                        <div class="input-field">
                            <label>Gender</label>
                            <select name="gender" required>
                                <option disabled selected>Select gender</option>
                                <option value="1">Male</option>
                                <option value="2">Female</option>
                                <option value="3">Others</option>
                            </select>
                        </div>

                        <div class="input-field">
                            <label>Religion</label>
                            <input type="text" value="<c:out value='${new_child.getReligion()}' />" name="religion" required>
                        </div>
                        

                         <div class="input-field">
                            <label for="disease">physically disable</label>
                            <select name="physically_disable" required>
                                <option disabled selected>Select</option>
                                <option value="1">Yes</option>
                                <option value="2">No</option>
                            </select>
                        </div>

<!-- 
                        <div class="img" >
                            <br>
                            <label for="input-file">Upload Image</label>
                            <input type="file" accept="image/jpeg, image/png, imagejpg" id="input-file">
                        </div>

 -->

                        <div class="input-field">
                            <button type="submit" class="nextBtn">
                       		 <span class="btnText">Submit</span>
                    		</button>
                        </div>

                        <div class="input-field">
                           <a href="OrphanagePage" style="text-decoration: none;">
                             <button type="button" class="nextBtn">
	                       	 	<span class="btnText">Back</span>
	                    	 </button>
	                      </a>
                        </div>
                        
                    </div>
                </div>
             </div>
             </form>
		</c:if>
		
		<c:if test="${new_child ==null}">
			<form action="AddChild" method="post">
			
			<div class="form first">
                <div class="details personal">	
                    <div class="fields">
                        <div class="input-field">
                            <label>Full Name</label>
                            <input type="text"  name="name" placeholder="Enter The Name" required>
                        </div>

                        <div class="input-field">
                            <label>Age</label>
                            <input type="number"  name="age" placeholder="Enter The Age" required>
                        </div>

                        <div class="input-field">
                            <label>Date of Birth</label>
                            <input type="date" name="dob" required>
                        </div>

 
                        <div class="input-field">
                            <label>Gender</label>
                            <select name="gender" required>
                                <option disabled selected>Select</option>
                                <option value="1">Male</option>
                                <option value="2">Female</option>
                                <option value="3">Others</option>
                            </select>
                        </div>

                        <div class="input-field">
                            <label>Religion</label>
                            <input type="text" name="religion"  placeholder="Enter The Religion" required>
                        </div>
                        

                         <div class="input-field">
                            <label for="disease">physically disable</label>
                            <select name="physically_disable" required>
                                <option disabled selected>Select</option>
                                <option value="1">Yes</option>
                                <option value="2">No</option>
                            </select>

                        </div>



<!--                         <div class="img" >
                            <br>
                            <label for="input-file">Upload Image</label>
                            <input type="file" accept="image/jpeg, image/png, imagejpg" id="input-file">
                        </div>

 -->





                        <div class="input-field">
                            <button type="submit" class="nextBtn">
                       		 <span class="btnText">Submit</span>
                    		</button>
                        </div>

                        <div class="input-field">
                           <a href="OrphanagePage" style="text-decoration: none;">
                             <button type="button" class="nextBtn">
	                       	 	<span class="btnText">Back</span>
	                    	 </button>
	                      </a>
                        </div>

                	</div>
                        
                    </div>
                </div>
             
             </form>
		</c:if>
				
				
					

	</div>
    <script src="script.js"></script>
</body>

</html>

</body>
</html>