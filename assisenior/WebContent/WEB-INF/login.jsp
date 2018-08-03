<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/resources/imports/head.jsp" />

<div id="skipnav"><a href="#maincontent">Retour sur l'accueil</a></div>

<c:import url="/resources/imports/nav.jsp" />

    <!-- Contact Section -->
    <section id="contact" class="back centring">
        <div class="container ">
            <div class="row">
                <div class="col-lg-12 text-center" style="margin-top: 136px;">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 zoneSaisieLogin">
                    <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                    <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                    <form method="POST" action="/assisenior/login">
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="login">Nom d'utilisateur</label>
                                <input type="text" class="form-control" placeholder="Nom d'utilisateur" id="login" name="login" required data-validation-required-message="Entrez votre nom d'utilisateur">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="Password">Mot de passe</label>
                                <input rows="5" type="password" class="form-control" placeholder="Mot de passe" id="password" name="password" required data-validation-required-message="Entrez votre mot de passe"></input>
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn btn-success btn-lg" style="margin-right: 15px;">Se connecter</button><span class="alert alert-danger" style="display:${display};">${actionMessage}</span>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

<c:import url="/resources/imports/footer.jsp" />

</body>
</html>
