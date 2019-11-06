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
        .gradient {
            background: rgb(2,0,36);
            background: linear-gradient(180deg, rgba(2,0,36,1) 0%, rgba(120,158,178,1) 0%, rgba(0,212,255,0) 50%);
        }
        .link-highlight {
            height:50px;
            text-align:center;
            background-image: linear-gradient(to right, transparent 50%, white 100%);
            background-origin: 0;
            background-size: 200% 200%;
            background-repeat:repeat-x;
            background-position: 0 100%;
            /*transition: background-position 0.5s;*/
            padding-top:15px;
            padding-right:10px;
            padding-left:10px;
        }
        /*        .link-highlight:hover {
                    background-position: -100% 100%;
                    color:#767681;
                }*/
        .top {
            border-top:solid black 3px;
            border-bottom:solid black 3px;
        }
        .parallax {
            background-image: url(${pageContext.request.contextPath}/images/psbackground.png);
            height:100vh;
            background-attachment:fixed;
            background-position:center;
            background-repeat: no-repeat;
            background-size: cover;
            -webkit-background-size: cover;
        }
        body {
            font: 400 18px Lato, sans-serif;
            line-height: 1.8;
            color: #fff;
            <!--text-shadow: #000 1px 1px,
                #000 -1px 1px;
        }
        h2 {
            font-size: 24px;
            text-transform: uppercase;
            color: #CAB58A;
            font-weight: 600;
            margin-bottom: 30px;
            text-shadow:
                -1px -1px 0 #000,  
                1px -1px 0 #000,
                -1px 1px 0 #000,
                1px 1px 0 #000;

        }
        h4 {
            font-size: 19px;
            line-height: 1.375em;
            color: #CAB58A;
            font-weight: 400;
            margin-bottom: 30px;
            text-shadow:
                -1px -1px 0 #000,  
                1px -1px 0 #000,
                -1px 1px 0 #000,
                1px 1px 0 #000;
        }  
        .jumbotron {

            color: #FFF7E2;
            padding: 100px 25px;
            font-family: Montserrat, sans-serif;
        }
        .container-fluid {
            padding: 60px 50px;
        }
        .bg-dark-grey {
            background-color:#818181;
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
        a {
            color:#CAB58A;
        }
        #nav-links a {
            transition-property: background-color, color, border-bottom-left-radius, border-top-right-radius;
            transition-duration: 0.5s, 0.1s, 0.5s, 0.5s;
        }
        #nav-links a:hover {
            background-color: #3389B8;
            color: #F2DEB6;
            border-bottom-left-radius: 50%;
            border-top-right-radius: 50%;
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
        li a {
/*            text-shadow:
                -0.5px -0.5px 0 #000,  
                0.5px -0.5px 0 #000,
                -0.5px 0.5px 0 #000,
                0.5px 0.5px 0 #000;*/
                color:#CAB58A;
                font-weight: bold;
            transition-property:color;
            transition-duration:0.25s;
        }
        li a:hover {
            color:#B29E76;
        }
        #infopane {
            background-color:rgba(121,184,220, 0.8);
            padding-top:20px;
            padding-bottom:20px;
            transition-property:background-color;
            transition-duration:0.25s;
        }
        #infopane:hover {
            background-color:rgba(121,184,220, 0.9);
        }
        #main {
            background-color:rgba(137, 137, 137, 0.8);
            transition-property:background-color;
            transition-duration:0.25s;
        }
        /*179,179,179*/
        #main:hover{
            background-color:rgba(137, 137, 137, 0.9)
        }
        li {
            font-family: Montserrat, sans-serif;
        }
        #home-button a{

            transition-property: background-color;
            transition-duration: 1s;
        }
        #home-button a:hover {
            background-color:#3389B8;
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
                <a id="home-button" class="navbar-brand" href="#myPage">Home</a>
            </div>
            <div class="collapse navbar-collapse" style="background-color: #256384;max-width:100%" id="myNavbar">
                <ul id="nav-links" class="nav navbar-nav mx-auto" style="max-width:100%">

                    <a href="${pageContext.request.contextPath}/Resume/NicholasThompsonResume.pdf" download><li class="nav-item  link-highlight">RESUME</li></a>

                    <a href="https://www.github.com/Gnarlic"><li class="nav-item link-highlight">GITHUB</li></a>

                    <a href="https://www.linkedin.com/in/nicholas-seb-thompson"><li class="nav-item link-highlight">LINKEDIN</li></a>

                    <a href="mailto:nicholas.seb.thompson@gmail.com"><li class="nav-item  link-highlight">CONTACT</li></a>
                </ul>
            </div>

        </nav>
        <div class="container" style="padding-top:50px">
            <div class="row" style="height:90vh">
                <div id="infopane" class="col-md-4" style="padding-top:20px;padding-bottom:20px">

                    <div>
                        <img src="${pageContext.request.contextPath}/images/1202182203_HDR_3.jpg" style="width:100%;border:solid black 2px">
                    </div>

                    <div style="padding-top:30px">
                        <h2 style="margin-bottom:10px;">I'm Nicholas Thompson,</h2>
                        <div class="text-white">
                            a committed full-stack developer, with a foundation provided by The Software Guild. As an inquisitive INTP in Myers-Briggs model,
                            I am constantly on the hunt to expand and learn new skills. Here you can check out my latest work.
                        </div>
                    </div>
                </div>

                <div id="main" class="col-md-8" style="padding-top:30px">
                    <div class="text-center">
                        <h2 class="" style="margin-bottom:20px;color: #CAB58A;">Technical Skills</h2>
                    </div>
                    <div id="tech-skills" class="row text-center">
                        <div class="col-md-4">
                            <ul style="list-style-type:none">
                                <li>Java</li>
                                <li>HTML / CSS / Javascript</li>
                                <li>MySql</li>
                                <li>JavaServer Pages (JSP)</li>
                                <li>OOP</li>
                            </ul>
                        </div>
                        <div class="col-md-4">
                            <ul style="list-style-type:none">
                                <li>SOAP/REST</li>
                                <li>TDD</li>
                                <li>jQuery</li>
                                <li>Data / Class Modeling</li>
                                <li>Netbeans IDE</li>
                            </ul>
                        </div>
                        <div class="col-md-4">
                            <ul style="list-style-type:none">
                                <li>Spring MVC / JDBC / SECURITY</li>
                                <li>Bootstrap</li>
                                <li>Version Control (Git)</li>
                                <li>Adobe Photoshop</li>
                                <li>Adobe Illustrator</li>
                            </ul>
                        </div>
                    </div>
                    <br>
                    <hr/>
                    <br>

                    <div id="personal-projects">
                        <div>
                            <h2 class="text-center" style="padding-bottom:10px;color: #CAB58A;">
                                Personal Projects</h2>
                            <ul class="text-white">
                                <li>
                                    <a href="http://www.gnarlitronic.com/spellsword" style="font-size:16pt;text-decoration:underline;">Spellsword</a> - A simple combat rpg game that generates random enemies that you fight. More features to come!
                                </li>
                                <li>
                                    <a style="font-size:16pt;text-decoration:underline;" href="http://www.gnarlitronic.com/calculator">Calculator</a> - Simple calculator app. Displays last 10 calculations performed.
                                </li>
                                <li>
                                    <a href="http://www.gnarlitronic.com/tabtracker" style="font-size:16pt;text-decoration:underline;">Tab Tracker</a> - Library for storing links to guitar tablature. Utilizes mariaDb to store song name, artist, and link to tabs. Tabs within the database are searchable by song name or artist.
                                </li>
                                <li>
                                    <a href="http://www.gnarlitronic.com/mapspace" style="font-size:16pt;text-decoration:underline;">MapSpace</a> -  Web app that utilizes the Google Maps API to display locations that users save. Users can name 
                                </li>
                                <li>
                                    <h3>Other projects are on my Github account</h3>
                                </li>
                            </ul>

                        </div>
                    </div>
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
