<%-- 
    Document   : index
    Created on : 18 mai 2016, 11:18:10
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
        <h2 class="header center orange-text">Inscrivez vous et vendez ce que vous voulez</h2>


    </div>
</div>
<div class="container">

    <div class="section">
        <!--   Icon Section   -->
        <form class="col s12" action="InscriptionCTRL" method="POST">

            <div class="row">
                <div class="row">
                    <div class="input-field col s6">
                        <input id="first_name" name="nom" type="text" class="validate">
                        <label for="first_name">Nom</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="last_name" name="prenom" type="text" class="validate">
                        <label for="last_name">Prenom</label>
                    </div>
                </div>
                <div class="input-field col s12">
                    <input id="last_name" name="pseudo" type="text" class="validate">
                    <label for="last_name">Pseudo</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="password" name="pwd" type="password" class="validate">
                    <label for="password">Mot de passe</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="email" type="email" name="email" class="validate">
                    <label for="email">Email</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="email" type="tel" name="telephone" class="validate">
                    <label for="email">Telephone</label>
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <textarea id="textarea1" name="adresse" class="materialize-textarea"></textarea>
                            <label for="textarea1">Adresse</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input id="first_name" name="dept" type="text" class="validate">
                    <label for="first_name">Département</label>
                </div>
                <div class="input-field col s6">
                    <input id="last_name" name="ville" type="text" class="validate">
                    <label for="last_name">Ville</label>
                </div>
            </div>


            <div class="row">
                <div class=" input-field col s12">
                    <select name="pays">
                        <option value="" selected>Choissisez votre pays</option>
                        <c:forEach var="Pays"  items="${requestScope['Pays']}" >
                            <option value="${Pays.nomPays}"> ${Pays.nomPays} </option>
                        </c:forEach>
<!--                        <option value="1">Option 1</option>
                        <option value="2">Option 2</option>
                        <option value="3">Option 3</option>-->
                    </select>

                    <label>Pays</label>


                </div>
            </div>

            <button class="btn orange waves-effect waves-purple" type="submit" name="action">Submit
                <i class="material-icons right">send</i>
            </button>
        </form>
    </div>


</div>
<br><br>


<%@ include file="jsp/fragments/Footer.jsp" %>
