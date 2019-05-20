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

    </head>
    <body>

        <div class="container">
            <div class="text-center">
                <h1>Welcome to WordSort</h1>
            </div>
            <div class="row" style="padding-top:20px">
                <div class="col-md-6">
                    <div>
                        <br>
                        <sf:form role="form" modelAttribute="inputString"
                                 method="POST" action="submit">
                            <sf:input id="input-string" type="text" path="string"/>
                            <button type="submit">Submit</button>
                        </sf:form>
                    </div>
                </div>
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
            <div>
                <div>
                    <h3>Number of times each letter used: </h3>
                </div>
                <div>
                    <c:set var="count" value="96" scope="page"/>
                    <c:forEach var="letter" items="${letterCount}">
                        <br>
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <c:out escapeXml="false" value="&#${count}"/> : 
                        <c:out value="${letter}"/>
                    </c:forEach>
                </div>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    </body>
</html>
