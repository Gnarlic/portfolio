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
                    <a href="#about"><li class="nav-item  link-highlight">ABOUT</li></a>

                    <a href="#resume"><li class="nav-item  link-highlight">RESUME</li></a>

                    <a href="#projects"><li class="nav-item link-highlight">PROJECTS</li></a>

                    <a href="https://www.github.com/Gnarlic"><li class="nav-item link-highlight">GITHUB</li></a>

                    <a href="https://www.linkedin.com/in/nicholas-seb-thompson"><li class="nav-item link-highlight">LINKEDIN</li></a>

                    <a href="#contact"><li class="nav-item  link-highlight">CONTACT</li></a>
                </ul>
            </div>

        </nav>
        <div class="jumbotron text-center" style="background:transparent" id="myPage">
            <h1 style="font-size:9.0vw;text-shadow:-2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;">Hi, I'm Nicholas Thompson.</h1>
        </div>
        <div id="about"></div>
        <div  class="container pt-4" style="background-color:#064378;">
            <div class="row text-white">
                <div class="col-md-3"><div></div><img src="${pageContext.request.contextPath}/images/1202182203_HDR_3.jpg" style="width:100%;border:solid black 2px"></div>
                <div class="col-md-6"><div></div>
                    <p class="text-center" style="font-size:20pt">
                        I'm a full stack web developer ready to tackle any project. I like to learn new things regularly. A skillset is never complete. Here you can check out my latest work.
                        I'm currently developing Spellsword, a browser-based rogue-like RPG as a personal project.
                    </p>
                </div>
                <div class="col-md-3 text-center"><div></div>
                    <i class="fa fa-code logo" style="color:#ffffff;text-shadow:-3px 0 black, 0 3px black, 3px 0 black, 0 -3px black;"></i>     
                </div>

            </div>
            <hr/>
        </div>
        <div id="resume" class="container text-white" style="background-color:#064378">
            <div class="text-center">
                <h2 class="text-white">Technical Skills</h2>
            </div>
            <div class="row text-center">
                <div class="col-md-4">
                    <ul style="list-style-type:none">
                        <li>Java</li>
                        <li>Kotlin</li>
                        <li>HTML / CSS / Javascript</li>
                        <li>MySql</li>
                        <li>JavaServer Pages (JSP)</li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <ul style="list-style-type:none">
                        <li>SOAP/REST</li>
                        <li>TDD</li>
                        <li>OOP</li>
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
            <hr/>
            <div class="text-center">
                <h2 class="text-white">Technical Experience</h2>
            </div>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <p>
                        The Software Guild - <br>
                        Java Apprentice
                    <ul>
                        <li>
                            Full-stack development using Java, Spring frameworks, HTML, CSS, Javascript and Bootstrap. Used Atlassing tools for version control, workflow management, and communication.
                            Built console and web based programs, including:
                            <ul>
                                <li>
                                    An app for tracking sightings of superbeings. Logged info for superbeings, organizations they belong to, locations, and dates. Specific functions are locked behind user roles implemented using Spring security.
                                    <a style="text-decoration:underline" href="http://www.gnarlitronic.com/superhero">Click here to check it out</a> - Log in with user "user" and password "password".
                                </li>
                                <li>
                                    A vending machine application that tracks inventory, currency entered, and returns correct change in the least amount of coins.
                                </li>
                                <li>
                                    A Dvd library app that stores dvd information and is searchable.
                                </li>
                            </ul>
                        </li>
                        These applications used Java, MySql, JavaServer Pages, jQuery, JSON, and ajax.
                    </ul>
                    </p>
                    <p>
                        Experience in the Workplace - <br>
                    <ul>
                        <li>
                            Terminix - Helped implement new system for route management software for field technicians.
                        </li>
                        <li>
                            Delta Global Services - Daily use of command line software for flight and ticketing information.
                        </li>
                        <li>
                            Pizza Factory - Use of excel for sales information, as well as Point-of-Sale software at registers.
                        </li>
                    </ul>
                    </p>
                </div>
                <div class="col-md-2">
                </div>
            </div>
            <div>
                <div class="text-center">
                    <h2 class="text-white">Education</h2>
                </div>
                <div>
                    <table class="table text-center">
                        <tr>
                            <th>
                                The Software Guild
                            </th>                 
                            <th>
                                2017-2018
                            </th>
                        </tr>
                        <tr>
                            <td colspan="2">
                                Java Apprenticeship Program
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Palomar College
                            </th>
                            <th>
                                2008-2013
                            </th>
                        </tr>
                        <tr>
                            <td colspan="2">
                                General Education / Illustration
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div id="projects" class="container pt-4" style="background-color:#064378">
            <div>
                <h2 class="text-center text-white">Personal Projects</h2>
            </div>
            <div>
                <p class="text-white">
                    Personal Projects - <br>
                <ul class="text-white">
                    <li>
                        <a href="http://www.gnarlitronic.com/spellsword" style="font-size:16pt;text-decoration:underline">Spellsword</a> - (Just allows simple combat at the moment - first milestone will include random enemy generation for encounters, and random weapon stats. Also basic database implementation and the ability to save your play record.) Rogue-like fantasy RPG. Combining magic and weapons, fight enemies to gain gold and better equipment. The different combinations of magic and weapons drastically change combat.
                        will be hosted here soon, and on github.
                    </li>
                    <li>
                        <a style="font-size:16pt;text-decoration:underline" href="http://www.gnarlitronic.com/calculator">Calculator</a> - Calculator web app. Next feature planned is to display past calculations.
                    </li>
                    <li>
                        <a style="font-size:16pt;text-decoration:underline">DeltaV</a> - (Coming Soon) Basic thrust calculator for rockets that displays delta-v, burn time, and starting and ending thrust. Calculations can be saved.
                    </li>
                    <li>
                        <a style="font-size:16pt;text-decoration:underline">Travel Log</a> - (Coming Soon) Web app for tracking locations that I've visited, and storing notes and images, utilizing the Google Maps API to display locations.
                    </li>
                    <li>
                        <h3>Other projects are on my Github account</h3>
                    </li>
                </ul>
                </p>
            </div>
        </div>
        <div id="contact" class="container pt-4" style="background-color:#064378;">
            <div class="text-center text-white" style="text-shadow:-3px 0 black, 0 3px black, 3px 0 black, 0 -3px black;height:100%">
                <h1>Contact Information</h1>
            </div>
            <div class="text-white text-center">
                <p>
                <ul style="list-style-type:none;">
                    <li><h1><a style="word-break: break-all" href="mailto:nicholas.seb.thompson@gmail.com" targer="_top">Email: Nicholas.seb.thompson@gmail.com</a></h1></li>
                    <li><h1>Phone: 541-390-4185</h1></li>
                </ul>
                </p>
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

