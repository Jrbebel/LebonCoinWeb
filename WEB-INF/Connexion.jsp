<html>
    <form method="POST" action="ConnexionCTRL" class="col s12">

        <div id="modal1" class="modal">

            <div class="modal-content">

                <div class="row">
                    <div class="input-field col s5">
                        <i class="material-icons prefix">email</i>
                        <input id="icon_prefix" type="text" name="email" class="validate black-text">
                        <label for="icon_prefix">Email</label>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s5">
                        <i class="material-icons prefix">edit</i>
                        <input id="icon_password" name="mdp" type="password" class="validate black-text">
                        <label for="icon_password">Pass</label>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button class="btn orange waves-effect waves-purple  modal-action modal-close waves-effect waves-orange btn-flat" type="submit" name="action">Envoyer
                </button>

                <!--//   <a href="ConnexionCTRL/?demandeConnexion=2" class=" modal-action modal-close waves-effect waves-orange btn-flat">Se connecter</a>-->
                <!--<a href="#!" class=" modal-action modal-close waves-effect waves-orange btn-flat">Annuler</a>-->
            </div>
        </div>
    </form>
</html>