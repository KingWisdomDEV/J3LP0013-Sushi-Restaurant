<%-- 
    Document   : menu
    Created on : Jan 17, 2021, 8:14:01 PM
    Author     : hoang
--%>

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
                                    <div class="section">
                                        <div class="content">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Menu 1</th>
                                                        <th class="align-right">Price</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Claritas est etiam processus</td>
                                                        <td class="align-right">€15.00</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                                        </div>
                                    </div>
                                    <div class="section">
                                        <div class="content">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Menu 2</th>
                                                        <th class="align-right">Price</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Duis autem vel eum iriure dolor.</td>
                                                        <td class="align-right">€20.00</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                                        </div>
                                    </div>
                                    <div class="section">
                                        <div class="content">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Menu 3</th>
                                                        <th class="align-right">Price</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Eodem modo typi, qui nunc nobis videntur.</td>
                                                        <td class="align-right">€25.00</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
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