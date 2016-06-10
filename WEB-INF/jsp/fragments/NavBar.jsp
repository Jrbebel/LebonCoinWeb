<%-- 
    Document   : NavBar
    Created on : 19 mai 2016, 15:32:31
    Author     : formation
--%>
<%@ page pageEncoding="UTF-8" %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<nav>
    <!-- Dropdown Structure -->
    <ul id="dropdown1" class="dropdown-content">

        <li><a href="#!">Mon Compte</a></li>
        <li class="divider"></li>
        <li><a href="ConnexionCTRL">Deconnexion</a></li>
    </ul>
    <div class=" orange lighten-1 nav-wrapper">

        <a href="index.jsp" class="brand-logo">LebonCoin M2I</a>

        <ul id="nav-mobile" class="right hide-on-med-and-down"> 

            <li><a href="DeposeAnnonceCTRL">Deposer une annonce</a></li>  
            <li><a href="AnnonceCTRL?titre='offres'">Offre</a></li>  
            <li><a href="AnnonceCTRL?titre=annonces">Demande</a></li>   

            <c:choose>

                <c:when test="${!empty sessionScope.sessionUtilisateur}">

                    <li><a class="dropdown-button" href="#!" data-activates="dropdown1">
                            <%

                                String identity = (String) session.getAttribute("sessionUtilisateur");
                                out.print(identity);

                            %> 

                            <i class="material-icons right">arrow_drop_down</i></a></li>

                </c:when> 

                <c:otherwise>
                    <li><a href="InscriptionCTRL">Inscription</a></li>
                    <li><a class="waves-effect waves-orange modal-trigger " href="#modal1">Connexion</a></li>

                </c:otherwise>   

            </c:choose>


            <%@ include file="../../Connexion.jsp" %>

        </ul>
    </div>
</nav>
