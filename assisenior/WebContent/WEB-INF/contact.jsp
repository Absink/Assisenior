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
					<div class="row">
						<div class="col-xs-12">
						
							<!--<c:if test="${notEmpty}">
								<c:forEach items="${listConversation}" var="iConv">
									<h3>Conversation</h3>
									<table style="width: 100%">
										<tr>
											<th style="text-decoration: underline;">Mes messages :</th>
										</tr>
										<c:forEach items="${iConv.getMessages()}" var="iMsg">
											<tr>
												<td align="left">${iMsg.getContenu()}</td>
											</tr>
										</c:forEach>

									</table>
								</c:forEach>
							</c:if>
							<c:if test="${ConvEmpty}">
								<h3>Aucune archive trouvée</h3>
							</c:if> !-->
						</div>
				</form>
			</div>
		</div>
	</div>
</section>

<c:import url="/resources/imports/footer.jsp" />

</body>
</html>