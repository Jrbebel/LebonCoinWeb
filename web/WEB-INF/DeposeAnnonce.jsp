<%-- 
    Document   : DeposeAnnonce
    Created on : 20 mai 2016, 14:53:07
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
        <h3 class="header center orange-text">Enregistrer Votre annonce</h3>


    </div>
</div>
<div class="container">

    <div class="section">
        <!--   Icon Section   -->
        <form class="col s12" action="DeposeAnnonceCTRL" method="POST">

            <div class="row">
                <div class="row">
                    <div class="input-field col s12">
                        <div class="card-panel teal orange">Annonce</div>

                    </div>
                </div>
                <div class="input-field col s12">
                    <select name="categorie" >
                        <%                            String Categorie = (String) request.getAttribute("Categorie");
                            out.print(Categorie);
                        %>
                    </select>
                    <label>Categorie</label>
                </div>

                <div class="row">

                    <div class="input-field col s12">
                        <p>Vous êtes un : </p> 
                        <p>


                            <input name="type" value =1 type="radio" id="particulier" required="required"/>
                            <label for="particulier">Particulier</label>
                        </p>
                        <p>
                            <input name="type" value =2 type="radio" id="professionnel" required="required"/>
                            <label for="professionnel">professionnel</label>
                        </p>

                    </div>
                </div>
                <div class="input-field col s12">
                    <p>Type d'annonce: </p> 
                    <p>
                        <input name="group2" type="radio" id="offres" required="required" />
                        <label for="offres">Offres</label>
                    </p>
                    <p>
                        <input name="group2" type="radio" id="demande" required="required" />
                        <label for="demande">Demande</label>
                    </p>

                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="titre" name="titre" type="text" class="validate" required="required">
                        <label for="titre">Titre</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="prix" name="prix" type="text" class="validate" required="required">
                        <label for="prix">Prix</label>
                    </div>
                </div>

                <div class="row">

                    <div class="row">
                        <div class="input-field col s12">
                            <textarea id="textarea1" name="descriptif" class="materialize-textarea" required="required" maxlength="100"  ></textarea>
                            <label for="textarea1">Texte descriptif de l'annonce</label>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <div class="card-panel teal orange">Localisation</div>

                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input id="email" type="text" class="validate">
                        <label for="email">Email</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="adresse" type="text" class="validate">
                        <label for="adresse">Adresse</label>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                        <div class="card-panel teal orange">Vos informations</div>

                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="pseudo" type="text" class="validate">
                        <label for="pseudo">Pseudo</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input id="email" type="text" class="validate">
                        <label for="email">Email</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input id="tel" type="tel" class="validate">
                        <label for="tel">Telephone</label>
                    </div>
                </div>


                <button class="btn orange waves-effect waves-purple" type="submit" name="action">Submit
                    <i class="material-icons right">send</i>
                </button>

            </div>

        </form>
    </div>
    <br><br>





</div>

<%@ include file="jsp/fragments/Footer.jsp" %>
