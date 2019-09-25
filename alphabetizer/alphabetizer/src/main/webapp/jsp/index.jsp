<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
        <style>
            .scale-in-center {
                -webkit-animation: scale-in-center 0.5s cubic-bezier(0.250, 0.460, 0.450, 0.940) ;
                animation: scale-in-center 0.5s cubic-bezier(0.250, 0.460, 0.450, 0.940) ;
            }
            @-webkit-keyframes scale-in-center {
                0% {
                    -webkit-transform: scale(0);
                    transform: scale(0);
                    opacity: 1;
                }
                100% {
                    -webkit-transform: scale(1);
                    transform: scale(1);
                    opacity: 1;
                }
            }
            @keyframes scale-in-center {
                0% {
                    -webkit-transform: scale(0);
                    transform: scale(0);
                    opacity: 1;
                }
                100% {
                    -webkit-transform: scale(1);
                    transform: scale(1);
                    opacity: 1;
                }
            }

        </style>

    </head>
    <body style="padding-bottom:50px;background-color:burlywood">

        <div class="container" style="background-color:background;color:#fff;height:100vh">
            <div class="text-center scale-in-center">
                <h1>Welcome to WordSort</h1>
            </div>
            <div class="" style="padding-top:20px">

                <div class="col-md-6 text-center" style="float:none;margin: 0 auto;">
                    <div>
                        Enter text to be sorted: 
                        <br>
                        <sf:form role="form" modelAttribute="inputString"
                                 method="POST" action="submit">
                            <sf:textarea cssStyle="resize:none;color:black" id="input-string" path="string" rows="10" cols="50"/>
                            <br>
                            <button type="submit" style="color:black">Submit</button>
                        </sf:form>
                    </div>
                </div>


            </div>
            <div class="row" style="height:100%">
                <div class="col-md-6 text-right">
                    <div>
                        <h3>Number of times each letter used: </h3>
                    </div>
                    <div>
                        <h4>
                            <c:set var="count" value="96" scope="page"/>
                            <c:forEach var="letter" items="${letterCount}">

                                <c:set var="count" value="${count + 1}" scope="page"/>
                                <c:if test="${letter > 0}">
                                    <br>
                                    <c:out escapeXml="false" value="&#${count}"/> : 
                                    <c:out value="${letter}"/>

                                </c:if>
                            </c:forEach>
                        </h4> 
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="col-md-6">
                        <div>
                            <h3>Letters in each word sorted alphabetically: 
                            </h3>
                        </div>
                        <div>
                            <h4>${results}</h4>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    </body>
</html>
