<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container-fluid">
            <div class="row" style="height:100vh">
                <div class="col-lg-2 bg-primary" id="navigation" style="height:100%;min-width:15%">
                    <div class="container text-light" style="padding-top:10%">
                        <h4>Navigation Menu</h4>
                    </div>
                    <hr/>
                    <div style="padding-left:10%">
                        <button class="btn btn-default" style="width:100%">Home</button>
                        <button class="btn btn-default" style="width:100%">Login</button>
                    </div>
                    <div>

                    </div>
                </div>

                <div class="col-lg-8" style="height:100%;background-color:darkgray;min-width:65%">

                    <h1 class="text-center" style="padding-top:0.75%">Spellsword</h1>
                    <hr/>
                    <div>

                    </div>

                </div>
                <div class="col-lg-2 bg-primary" style="height:100%;min-width:15%"></div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

