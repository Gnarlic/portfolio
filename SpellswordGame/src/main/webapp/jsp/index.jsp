<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Spellsword</title>
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
            background-repeat:repeat-x;
            background-position: 0 100%;
            transition: background-position 0.5s;
            padding-top:15px;
            padding-right:10px;
            padding-left:3px;
        }

        .link-highlight:hover {
            background-position: -100% 100%;
            color:#767681;
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
            -webkit-background-size: cover;
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

            color: #FFF7E2;
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
        .navbar {
            height:50px;
            margin-bottom: 0;
            background-color: #256384;
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
        .slide {
            animation-name: slide;
            -webkit-animation-name: slide;
            animation-duration: 1s;
            -webkit-animation-duration: 1s;
            visibility: visible;
        }
        .slideanim {
            visibility:hidden;
        }
        footer .glyphicon {
            font-size: 20px;
            margin-bottom: 20px;
            color: #ffffff;
        }


        li {
            font-family: Montserrat, sans-serif;
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
            <div class="collapse navbar-collapse" style="background-color: #256384;max-width:100%" id="myNavbar">
                <ul class="nav navbar-nav mx-auto" style="max-width:100%">
                    <a href="http://www.gnarlitronic.com/jsp/index.jsp/#about"><li class="nav-item  link-highlight">ABOUT</li></a>

                    <a href="#resume"><li class="nav-item  link-highlight">RESUME</li></a>

                    <a href="#projects"><li class="nav-item link-highlight">PROJECTS</li></a>

                    <a href="https://www.github.com/Gnarlic"><li class="nav-item link-highlight">GITHUB</li></a>

                    <a href="https://www.linkedin.com/in/nicholas-seb-thompson"><li class="nav-item link-highlight">LINKEDIN</li></a>

                    <a href="#contact"><li class="nav-item  link-highlight">CONTACT</li></a>
                </ul>
            </div>

        </nav>
        <div class="container-fluid" style="height:100%vh">
            <div class="row">
                <div class="col-lg-3" style="background-color:#1E74AD">

                </div>
                <div class="col-lg-6" style="background-color:#C7AE90">

                </div>
                <div class="col-lg-3" style="background-color:yellowgreen">

                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
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

