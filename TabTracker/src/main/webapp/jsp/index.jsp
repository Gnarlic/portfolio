<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tab Tracker</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <style>
            
            .light {
                
                color:#fff;
            }
            
            a {
                color:#fff;
            }
            
            a:hover {
                color:#fff;
                text-decoration:underline;
            }
            
        </style>
    </head>
    <body style="background-color:#002D6E">
        <div class="container" style="background-color:#0056D2;height:100vh">
            <div class="text-center light" style="margin-bottom:50px">
                <h1>Tab Tracker</h1>
                <p>
                    Keep track of tabs for guitar.
                </p>
                <div>
                    <sf:form class="form-horizontal" role="form" modelAttribute="tab"
                             method="POST" action="${pageContext.request.contextPath}/addTab">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="song-name" class="control-label">Song Name</label>
                                <sf:input type="text" id="song-name" name="songName" path="songName"/>
                            </div>
                            <div class="col-md-3">
                                <label for="artist" class="control-label">Artist</label>
                                <sf:input type="text" id="artist" name="artist" path="artist"/>
                            </div>
                            <div class="col-md-3">
                                <label for="url" class="control-label">URL</label>
                                <sf:input type="text" id="url" name="url" path="url"/>
                            </div>
                            <div class="col-md-3">
                                <button class="btn btn-default" type="submit">Submit</button>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
            <div>
                <table class="table table-hover" style="">
                    <tr class="bg-primary light">
                        <th>
                            <h3>Song Name</h3>
                        </th>
                        <th>
                            <h3>Artist</h3>
                        </th>
                        <th>
                            <h3>URL</h3>
                        </th>
                    </tr>
                    <c:forEach var="tab" items="${tabList}">
                        <tr>
                            <td class="border-bottom border-dark light"><h4>${tab.songName}</h4></td>
                            <td class="border-bottom border-dark light"><h4>${tab.artist}</h4></td>
                            <td class="border-bottom border-dark light"><a href="${tab.url}"><h4>Link</h4></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

