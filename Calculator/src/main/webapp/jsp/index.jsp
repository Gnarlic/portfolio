<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Calculator</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <style>
        @media all and (max-width: 480px) {
            .sidediv { display: none;}
        }
    </style>
    <body style="background-color:burlywood">
        <div class="container-fluid">
            <div class="text-center">
                <a href="http://www.gnarlitronic.com#about">Return to Homepage</a>
            </div>
            <div class="text-center" style="margin-bottom:30px">
                <h1 style="color:#ffffff;text-shadow:-3px 0 black, 0 3px black, 3px 0 black, 0 -3px black;">Calculator</h1>
            </div>
            <div class="alert-danger text-center" style="margin-bottom:30px">
                <h2>${error}</h2>
            </div>
            <div class="row" style="height:100vh;background-color:dodgerblue">
                <div class="col-md-3 sidediv" >

                </div>
                <div class="col-md-6" style="background-color:burlywood;height:100%">
                    <div class="form-group">
                        <form action="${pageContext.request.contextPath}/calculate" method="get">
                            <div>
                                <label for="num1">Number 1</label>
                                <input class="form-control" type="number" name="num1" step="any" value="0"/>
                            </div>
                            <div>
                                <label for="num2">Number 2</label>
                                <input class="form-control" type="number" name="num2" step="any" value="0"/>
                            </div>
                            <div class="text-center form-inline">
                                <input  type="radio" name="operation" value="Add" checked="true">+
                                <input type="radio" name="operation" value="Sub">-
                                <input  type="radio" name="operation" value="Mul">x
                                <input  type="radio" name="operation" value="Div">%
                            </div>
                            <div class="text-center">
                                <input type="submit" value="Submit">
                            </div>
                        </form>
                    </div>
                            <div>
                                
                                <h2>Answer: ${returnAnswer}</h2>
                            </div>
                </div>
                <div class="col-md-3 sidediv">
                    
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

