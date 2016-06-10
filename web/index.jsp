<%-- 
    Document   : index
    Created on : 18 mai 2016, 11:18:10
    Author     : formation
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<%@ include file="WEB-INF/jsp/fragments/Header.jsp" %>

<%@ include file="WEB-INF/jsp/fragments/NavBar.jsp" %>


<div class="section no-pad-bot" id="index-banner">
    <div class="container">
        <%            if (request.getAttribute("messageErreur") != null) {
                out.print("<div class='card-panel teal orange'>" + session.getAttribute("messageErreur") + "</div >");
            }


        %>
        <br><br>
        <h1 class="header center orange-text">Le site de vente d'occasion de M2I</h1>
        <div class="row center">
            <h5 class="header col s12 light">Un site communautaire fait par les stagiares de M2I formation Paris</h5>
        </div>
        <div class="row center">
            <a href="AnnonceCTRL" id="download-button" class="btn-large waves-effect waves-light orange">Voir les annonces</a>
        </div>
        <br><br>

    </div>
</div>
<div class="container">
    <div class="section">

        <!--   Icon Section   -->
        <div class="row">
            <div class="col s12 m4">
                <div class="icon-block">
                    <h2 class="center light-blue-text"><i class="material-icons">flash_on</i></h2>
                    <h5 class="center">Développement</h5>

                    <p class="light">We did most of the heavy lifting for you to provide a default stylings that incorporate our custom components. Additionally, we refined animations and transitions to provide a smoother experience for developers.</p>
                </div>
            </div>

            <div class="col s12 m4">
                <div class="icon-block">
                    <h2 class="center light-blue-text"><i class="material-icons">group</i></h2>
                    <h5 class="center">Une expérience utilisateur</h5>

                    <p class="light">By utilizing elements and principles of Material Design, we were able to create a framework that incorporates components and animations that provide more feedback to users. Additionally, a single underlying responsive system across all platforms allow for a more unified user experience.</p>
                </div>
            </div>

            <div class="col s12 m4">
                <div class="icon-block">
                    <h2 class="center light-blue-text"><i class="material-icons">settings</i></h2>
                    <h5 class="center">Facilité d'utilisation</h5>

                    <p class="light">We have provided detailed documentation as well as specific code examples to help new users get started. We are also always open to feedback and can answer any questions a user may have about Materialize.</p>
                </div>
            </div>
        </div>

    </div>
    <br><br>

    <div class="section">

    </div>
</div>

<%@ include file="WEB-INF/jsp/fragments/Footer.jsp" %>
