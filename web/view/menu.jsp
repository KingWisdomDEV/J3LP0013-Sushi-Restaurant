<%-- 
    Document   : menu
    Created on : Jan 17, 2021, 8:14:01 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US" class="">
    <head>
        <title>Sushi Restaurant - Menu and Price list</title>
        <%@include file="common/head.jsp" %>    
    </head>
    <body data-pid="410908035" data-iid="">
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <!-- this is the Header Wrapper -->
            <%@include file="common/header.jsp" %>
            <script>
                document.querySelector('#header #topMenu > li:nth-child(2)').className = "active";
            </script>
            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper list list-prices">
                                <div class="heading">
                                    <h1 class="page-title">Menu and Price list</h1>
                                </div>

                                <div class="content">
                                    <c:forEach items="${requestScope.listObj}" var="listObj">                                                                            
                                        <div class="section">
                                            <div class="content">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>${listObj.name}</th>
                                                            <th class="align-right">Price</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>${listObj.shortDesc}</td>
                                                            <td class="align-right">€${listObj.price}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                <p>${listObj.detailDesc}</p>
                                            </div>
                                        </div>
                                   </c:forEach>
                                    
                                </div>
                            </div>
                            <!-- PAGING START -->
                            <div class="pagination">
                                <%  int numOfLink = 5;// số lượng page muốn hiển thị
                                    int pageNum = Integer.parseInt(request.getAttribute("page") + "");
                                    int perpage = Integer.parseInt(request.getAttribute("perpage") + "");

                                    int size = Integer.parseInt(request.getAttribute("size") + "");
                                    int totalPage = (size / perpage) + ((size % perpage == 0 && (pageNum) != 0) ? 0 : 1);//tổng số trang tối đa của list
                                    int maxPage = (totalPage < numOfLink) ? totalPage : numOfLink;//số page hiển thị tối đa
                                    int startPage = ((pageNum - (maxPage / 2)) > 0) ? (pageNum - (maxPage / 2)) : 1;
                                    int endPage = ((startPage + maxPage - 1) < totalPage) ? (startPage + maxPage - 1) : totalPage;
                                    if ((endPage - startPage) < totalPage && maxPage <= totalPage) {
                                        startPage = endPage - (numOfLink - 1);
                                    }
                                    if (startPage <= 0) {
                                        startPage = 1;
                                    }
                                    if (maxPage > 1) {  %>
                                        <a href="menu?page=1">&laquo;</a>
                                        <%  for (int i = startPage; i <= endPage; i++) {    %>
                                            <a class="<%=((pageNum == i) ? "active" : "")%>" href="menu?page=<%=i%>"><%=i%></a>
                                        <%  } %>
                                        <a href="menu?page=<%=(totalPage)%>">&raquo;</a>
                                    <%  }   %>
                            </div>
                            <!-- PAGING END -->
                        </div>
                        <%@include file="common/social-network.jsp" %>
                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <!-- this is the Footer Wrapper -->
            <%@include file="common/footer.jsp" %>
        </div>
    </body>
</html>