<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/resources/imports/head.jsp" />
<c:if test="${not empty createdMessage}">
	<script>
   window.addEventListener("load",function(){
        alert("${createdMessage}");
   });
   </script>
</c:if>
<c:if test="${not empty createdUser}">
	<script>
   window.addEventListener("load",function(){
        alert("${createdUser}");
   });
   </script>
</c:if>

<div id="skipnav">
	<a href="#maincontent">Retour sur l'accueil</a>
</div>

<c:import url="/resources/imports/nav.jsp" />

<!-- Portfolio Grid Section -->
<section id="portfolio" class="back centring">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
			<br/>
				<h2>Selection des modifications</h2>
				<hr class="star-primary">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 text-center" style="margin-top: 59px;"></div>
		</div>
		<div class="row">
			<div class="col-sm-4 portfolio-item">
				<a href="/assisenior/contact" class="portfolio-link" data-toggle="modal">
					<h2>Contacts</h3>
				</a>
			</div>
			<div class="col-sm-4 portfolio-item">
				<a href="/assisenior/profil" class="portfolio-link" data-toggle="modal">
					<h2>Profils</h3>
				</a>
			</div>
			<div class="col-sm-4 portfolio-item">
				<a href="/assisenior/capteur" class="portfolio-link" data-toggle="modal">
					<h2>Capteurs</h3>
				</a>
			</div>
			<div class="col-sm-3 portfolio-item"></div>
		</div>
	</div>
</section>

<c:import url="/resources/imports/footer.jsp" />

</body>
</html>