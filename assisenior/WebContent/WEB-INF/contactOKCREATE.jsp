<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/resources/imports/head.jsp" />


<c:import url="/resources/imports/nav.jsp" />



<section id="contact" class="back centring">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>Contacts</h2>
				<hr class="star-primary">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<form action="ContactServlet" method="POST">
					<div class="row control-group"></div>
					<br>
					<div id="success"></div>
					<div class="col-xs-12">
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="firstname">Nom</label> <input type="text"
									class="form-control" placeholder="Nom" name="lastname"
									id="lastname" required
									data-validation-required-message="Entrez votre nom">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="lastname">Prenom</label> <input type="text"
									class="form-control" placeholder="Prenom" name="firstname"
									id="firstname" required
									data-validation-required-message="Entrez votre prenom">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="phone1">Telephone 1</label> <input type="text"
									class="form-control" placeholder="Telephone 1" name="phone1"
									id="phone1" required
									data-validation-required-message="Entrez votre numéro de téléphone">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="phone2">Telephone 2</label> <input type="text"
									class="form-control" placeholder="Telephone 2" name="phone2">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="address">Adresse</label> <input type="text"
									class="form-control" placeholder="Adresse" name="address"
									id="address" required
									data-validation-required-message="Entrez votre adresse">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="priority">Priorité</label> <input type="text"
									class="form-control" placeholder="Priorité" name="priority">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<br>
						<div id="success"></div>
						<div class="row">
							<div class="form-group col-xs-12">
								<button type="submit" class="btn btn-success btn-lg">Sauvegarder</button>
							</div>
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