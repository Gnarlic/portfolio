<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <!-- comment -->
    <body>
        <style>
            .row{
                padding-bottom: 2%;
            }
            a:hover{
                color: #007bff;
            }
            a:link{
                text-decoration: none;
            }
            .card{
                box-shadow: 4px 4px 2px lightgrey;
            }
            .a{
                background-color: transparent;
                border: none;
                outline: 0;
                -webkit-shadow-box: none;
                inner-box-shadow: none;
            }
        </style>
        <div class="container">

            <h1 class="text-center">Vending Machine</h1>
            <hr/>
            <div class="row">

                <div class="col-md-8 border-right border-primary text-center">
                    <div class="row card-deck" style="font-size:15">

                        <c:forEach var="thisItem" items="${items}">
                            <a href="${pageContext.request.contextPath}/selectItem?itemId=${thisItem.id}" class="card" style="min-width:25%;margin-bottom:2%;border-color:#428bca">
                                <div class="border-primary" style="margin-bottom:10px">
                                    <div class="text-left" style="margin-left:10px">${thisItem.id}</div>
                                    <br>
                                    <div>${thisItem.itemName}</div>
                                    <br>
                                    <div>$${thisItem.itemPrice}</div>
                                    <br>
                                    <div>Stock: ${thisItem.itemInventory}</div>
                                </div>
                            </a>
                        </c:forEach>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="text-center">
                                <h4>Total $ In</h4>
                                <input type="text" class="text-center" value="${funds}" readonly>
                                <br/>
                                <br/>
                                <div class="row">
                                    <div class="col-md-6">
                                        <a href="${pageContext.request.contextPath}/addMoney?amount=1.00">
                                            <button type="button"
                                                    class="btn btn-primary btn-sm w-100">Add Dollar</button>
                                        </a>
                                    </div>
                                    <div class="col-md-6">
                                        <a href="${pageContext.request.contextPath}/addMoney?amount=.25">
                                            <button type="button"
                                                    class="btn btn-primary btn-sm w-100">Add Quarter</button>
                                        </a>    
                                    </div>
                                    <br/>
                                    <br/>
                                    <div class="col-md-6">
                                        <a href="${pageContext.request.contextPath}/addMoney?amount=.10">
                                            <button type="button"
                                                    class="btn btn-primary btn-sm w-100">Add Dime</button>
                                        </a>
                                    </div>
                                    <div class="col-md-6">
                                        <a href="${pageContext.request.contextPath}/addMoney?amount=.05">
                                            <button type="button"
                                                    class="btn btn-primary btn-sm w-100">Add Nickel</button>
                                        </a>
                                    </div>
                                </div>
                                <hr/>
                            </div>
                            <div class="text-center">
                                <div>
                                    <h4>Messages</h4>
                                    <textarea class="col-md-10" rows="2" readonly>${errorMessage}${messages}</textarea>
                                </div>
                                <br>
                                <div class="text-center row">
                                    <label style="" class="text-center col-md-6">Item:</label>
                                    <input type="text" class="col-md-6" value="${itemId}" readonly>
                                </div>
                                <div class="text-center row col-md-12">
                                    
                                  <a href="${pageContext.request.contextPath}/purchaseItem?itemId=${itemId}">
                                        <button type="submit" class="btn btn-primary btn-sm">Make Purchase</button>
                                   </a>
                                </div>
                            </div>
                            <hr/>
                            <div>
                                <div class="text-center">
                                    <h4>Change</h4>
                                    <textarea rows="4" value="" readonly><c:if test="${showChange eq 'y'}">Quarters: ${changeReturn.getQuarters()}&#013Dimes: ${changeReturn.getDimes()}&#013Nickels: ${changeReturn.getNickels()}&#013Pennies: ${changeReturn.getPennies()}</c:if></textarea>
                                    
                                    <br>
                                    <form action="returnChange" method="POST">
                                        <button type="submit" class="btn btn-primary btn-sm">Change Return</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

