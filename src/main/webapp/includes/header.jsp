<!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center">
    <div class="container d-flex align-items-center">

      <div class="logo me-auto">
        <h1><a href="index.html">Orphan</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="nav-link scrollto active" href="#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="#about">About</a></li>
          
          <c:if test="${sessionScope.role  == 'user'}">
       	  	<li class="dropdown"><a href="#"><span>Services</span> <i class="bi bi-chevron-down"></i></a>
           		 <ul>
             	 <li><a href="<%=request.getContextPath()%>/UserPage">User Services</a></li>
            	</ul>
          	</li>
		  </c:if>
		  
		   <c:if test="${sessionScope.role  == 'user'}">
       	  	<li class="dropdown"><a href="#"><span>Services</span> <i class="bi bi-chevron-down"></i></a>
           		 <ul>
             	 <li><a href="<%=request.getContextPath()%>/OrphanagePage">Orphanage Services</a></li>
            	</ul>
          	</li>
		  </c:if>
          
          
          
          
          <!-- <li><a class="nav-link scrollto " href="#portfolio">Portfolio</a></li> -->
          <!-- <li><a class="nav-link scrollto" href="#testimonials">Testimonials</a></li> -->


          <!-- <li class="dropdown"><a href="#"><span>Drop Down</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li> -->
          <!-- 
          
          <li><a class="nav-link scrollto" href="#contact">Contact</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i> -->



          <li class="dropdown"><a href="#"><span>Login</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="<%=request.getContextPath()%>/User">User Login</a></li>
              <li><a href="<%=request.getContextPath()%>/Orphanage">Orphanage Login</a></li>
            </ul>
          </li>



          <li><a class="nav-link scrollto" href="#contact">Contact</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>

      </nav>



    </div>

  </header><!-- End Header -->