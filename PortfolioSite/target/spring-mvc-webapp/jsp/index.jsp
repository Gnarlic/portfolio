<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Nicholas Thompson</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap core CSS -->

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">

    </head>
    <style>
        .link-highlight {
            height:50px;
            text-align:center;
            background-image: linear-gradient(to right, transparent 50%, white 100%);
            background-origin: 0;
            background-size: 200% 200%;
            background-repeat: repeat-x;
            background-position: 0 100%;
            transition: background-position 0.5s;
            padding-top:15px;
            padding-right:10px;
            padding-left:3px;
        }

        .link-highlight:hover {
            background-position: -100% 100%;
            color:red;
        }

        .top {
            border-top:solid black 3px;
            border-bottom:solid black 3px;
        }

        .parallax {
            background-image: url(${pageContext.request.contextPath}/images/110.jpg);
            height:100vh;
            background-attachment:fixed;
            background-position:center;
            background-repeat: no-repeat;
            background-size: cover;
        }
        body {
            font: 400 15px Lato, sans-serif;
            line-height: 1.8;
            color: #818181;
        }
        h2 {
            font-size: 24px;
            text-transform: uppercase;
            color: #303030;
            font-weight: 600;
            margin-bottom: 30px;
        }
        h4 {
            font-size: 19px;
            line-height: 1.375em;
            color: #303030;
            font-weight: 400;
            margin-bottom: 30px;
        }  
        .jumbotron {

            color: #fff;
            padding: 100px 25px;
            font-family: Montserrat, sans-serif;
        }
        .container-fluid {
            padding: 60px 50px;
        }
        .bg-grey {
            background-color: #f6f6f6;
        }
        .logo-small {
            color: #f4511e;
            font-size: 50px;
        }
        .logo {
            color: #f4511e;
            font-size: 200px;
        }
        .thumbnail {
            padding: 0 0 15px 0;
            border: none;
            border-radius: 0;
        }
        .thumbnail img {
            width: 100%;
            height: 100%;
            margin-bottom: 10px;
        }
        .carousel-control.right, .carousel-control.left {
            background-image: none;
            color: #f4511e;
        }
        .carousel-indicators li {
            border-color: #f4511e;
        }
        .carousel-indicators li.active {
            background-color: #f4511e;
        }
        .item h4 {
            font-size: 19px;
            line-height: 1.375em;
            font-weight: 400;
            font-style: italic;
            margin: 70px 0;
        }
        .item span {
            font-style: normal;
        }
        .panel {
            border: 1px solid #f4511e; 
            border-radius:0 !important;
            transition: box-shadow 0.5s;
        }
        .panel:hover {
            box-shadow: 5px 0px 40px rgba(0,0,0, .2);
        }
        .panel-footer .btn:hover {
            border: 1px solid #f4511e;
            background-color: #fff !important;
            color: #f4511e;
        }
        .panel-heading {
            color: #fff !important;
            background-color: #f4511e !important;
            padding: 25px;
            border-bottom: 1px solid transparent;
            border-top-left-radius: 0px;
            border-top-right-radius: 0px;
            border-bottom-left-radius: 0px;
            border-bottom-right-radius: 0px;
        }
        .panel-footer {
            background-color: white !important;
        }
        .panel-footer h3 {
            font-size: 32px;
        }
        .panel-footer h4 {
            color: #aaa;
            font-size: 14px;
        }
        .panel-footer .btn {
            margin: 15px 0;
            background-color: #f4511e;
            color: #fff;
        }
        .navbar {
            height:50px;
            margin-bottom: 0;
            background-color: #89A2AF;
            background-size:100%;
            z-index: 9999;
            border: 0;
            font-size: 12px !important;
            line-height: 1.42857143 !important;
            letter-spacing: 4px;
            border-radius: 0;
            font-family: Montserrat, sans-serif;
        }        
        .navbar li a, .navbar .navbar-brand {
            height:100%;
            color: #fff !important;
            padding:2px;
        }
        .navbar-nav li a:hover, .navbar-nav li.active a {
            color: red;
        }
        a {
            color:white;
        }
        a:hover {
            text-decoration:none;
        }

        .navbar-nav li a:hover, .navbar-nav li.active a {
            color: #f4511e !important;
            background-color: #fff !important;

        }
        .navbar-default .navbar-toggle {
            border-color: transparent;
            color: #fff !important;
        }
        footer .glyphicon {
            font-size: 20px;
            margin-bottom: 20px;
            color: #ffffff;
        }
        .slideanim {visibility:hidden;}
        .slide {
            animation-name: slide;
            -webkit-animation-name: slide;
            animation-duration: 1s;
            -webkit-animation-duration: 1s;
            visibility: visible;
        }
        @keyframes slide {
            0% {
                opacity: 0;
                transform: translateY(70%);
            } 
            100% {
                opacity: 1;
                transform: translateY(0%);
            }
        }
        @-webkit-keyframes slide {
            0% {
                opacity: 0;
                -webkit-transform: translateY(70%);
            } 
            100% {
                opacity: 1;
                -webkit-transform: translateY(0%);
            }
        }
        @media screen and (max-width: 768px) {
            .col-sm-4 {
                text-align: center;
                margin: 25px 0;
            }
            .btn-lg {
                width: 100%;
                margin-bottom: 35px;
            }
        }
        @media screen and (max-width: 480px) {
            .logo {
                font-size: 150px;
            }
        }
    </style>
    <body class="parallax">
        <nav class="navbar navbar-dark navbar-expand-lg fixed-top top">

            <div class="navbar-header">
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#myNavbar">
                    <span class="navbar-toggler-icon" style="color:white"></span>
                </button>
                <a class="navbar-brand" href="#myPage">Home</a>
            </div>
            <div class="collapse navbar-collapse" style="background-color:#89A2AF" id="myNavbar">
                <ul class="nav navbar-nav ml-auto">
                    <a href="${pageContext.request.contextPath}/jsp/index.jsp/#about"><li class="nav-item  link-highlight">ABOUT</li></a>

                    <a href="${pageContext.request.contextPath}/jsp/resume.jsp"><li class="nav-item  link-highlight">RESUME</li></a>
                    
                    <li class="nav-item dropdown link-highlight">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Projects
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="http://www.gnarlitronic.com/superherosightings">Superhero Sightings</a>
                            <a class="dropdown-item" href="http://www.gnarlitronic.com/vendingmachine">Vending Machine</a>
                            <a class="dropdown-item" href="http://www.gnarlitronic.com/spellsword">Spellsword Game</a>
                        </div>
                    </li>

                    <a href="https://www.linkedin.com/in/nicholas-seb-thompson/"><li class="nav-item link-highlight">LINKEDIN</li></a>

                    <a href="mailto:nicholas.seb.thompson@gmail.com" target="_top"><li class="nav-item  link-highlight">CONTACT</li></a>
                </ul>
            </div>

        </nav>
        <div class="jumbotron text-center text-white" style="margin:0;background:transparent" id="myPage">
            <h1 style="font-size:10.0vw;text-shadow:-2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;">Nicholas Thompson</h1>
        </div>
        <div id="about" class="container-fluid top" style="height:500px;background-color:#89A2AF;">
            <div class="row text-white">
                <div class="col-md-2"><img src="${pageContext.request.contextPath}/images/1202182203_HDR_3.jpg" style="width:100%;border:solid black 2px"></div>
                <div class="col-md-6">
                    <h3 class="text-center" style="text-shadow:-1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;">Full Stack Web Developer</h4>
                </div>
                <div class="col-md-4">
                    <i class="fa fa-code logo" style="color:#ffffff;text-shadow:-3px 0 black, 0 3px black, 3px 0 black, 0 -3px black;"></i>     
                </div>
            </div>
        </div>
        <div style="height:500px">

        </div>
        <div id="contact" class="container-fluid top" style="height:500px;background-color:#89A2AF;">
            <div>
                <ul>
                    <li><a href="mailto:nicholas.seb.thompson@gmail.com" targer="_top">Email</a></li>
                </ul>
            </div>
        </div>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/js/home.js"></script>

        <script>
            $(document).ready(function () {
                // Add smooth scrolling to all links in navbar + footer link
                $(".navbar a, footer a[href='#myPage']").on('click', function (event) {
                    // Make sure this.hash has a value before overriding default behavior
                    if (this.hash !== "") {
                        // Prevent default anchor click behavior
                        event.preventDefault();

                        // Store hash
                        var hash = this.hash;

                        // Using jQuery's animate() method to add smooth page scroll
                        // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
                        $('html, body').animate({
                            scrollTop: $(hash).offset().top
                        }, 900, function () {

                            // Add hash (#) to URL when done scrolling (default click behavior)
                            window.location.hash = hash;
                        });
                    } // End if
                });

                $(window).scroll(function () {
                    $(".slideanim").each(function () {
                        var pos = $(this).offset().top;

                        var winTop = $(window).scrollTop();
                        if (pos < winTop + 600) {
                            $(this).addClass("slide");
                        }
                    });
                });
            })
        </script>
    </body>
</html>

