<%-- 
    Document   : Annonce
    Created on : 20 mai 2016, 16:08:25
    Author     : formation
--%>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<%@ include file="jsp/fragments/Header.jsp" %>

<%@ include file="jsp/fragments/NavBar.jsp" %>


<div class="section no-pad-bot" id="index-banner">

    <div class="container">   
        <br><br>
        <%            String name = (String) request.getAttribute("type");
            if (name == "annonces") {
                out.print("<h3 class='header center orange-text'>Vos annonces, profitez des bons plans</h3>");

            } else {
                out.print("<h3 class='header center orange-text'>Recherchez les meilleurs bons plans</h3>");

            }
        %>



    </div>
</div>
<div class="container">
    <nav>
        <div class="nav-wrapper orange">
            <form>
                <div class="input-field">
                    <input id="search" type="search" required>
                    <label for="search"><i class="material-icons">search</i></label>
                    <i class="material-icons">close</i>
                </div>
            </form>
        </div>
    </nav>
    <div class="section">

        <table class="highlight">


            <tbody>
             
                <c:forEach var="Annonce"  items="${requestScope['Annonce']}" >
                    <tr>
                        <td>
                            <div id="titre">
                                <img src="images/exemple.jpg" />
                            </div>
                            <div>
                                <strong><a href="DescriptionCTRL?id=${Annonce.idProduit}">
                                      ${Annonce.designationProduit} 
                                    </a></strong> <br>
                                ${Annonce.sousCategorieProduit.sousCategorieProduit} <br>
                                Herbault/Loir-et-Cher<br>
                               ${Annonce.prixProduit}
                            </div>

                        </td>         
                    </tr>
                </c:forEach>
               
                </tbody>
            </table>

        </div>
        <br><br>





    </div>

    <%@ include file="jsp/fragments/Footer.jsp" %>

