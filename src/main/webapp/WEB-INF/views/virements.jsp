<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<%-- <%=request.getContextPath()%> --%>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/index.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>ProxiBanque</title>
</head>
<body>
	<!-- LISTE DES URLs -->
	<c:url value="/listeClients" var="listeClientsUrl" />
	<c:url value="/listeComptes" var="listeComptesUrl" />
	<c:url value="/virements" var="virementsUrl" />


	<!-- Entête avec Logo -->
	<nav class="navbar fixed-top navbar-dark bg-dark">
		<div class="col-md-2">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">
				<img name="logo"
				src="${pageContext.request.contextPath}/images/logo-banque.jpg"
				alt="LOGO">
			</a>
		</div>
		<div class="col-md-8 d-flex justify-content-center align-items-center">
			<h1>
				<font color="white">ProxiBanque Conseiller Clientèle</font>
			</h1>
		</div>
		<!-- UserName -->
		<div class="Connexion col-md-2">
			<h4>
				<font color="green" style="font-variant: small-caps;"><b>${login}</b></font>
			</h4>
			<h5>
				<font color="green" style="font-variant: small-caps;"><b>Connected</b></font>
			</h5>
		</div>
	</nav>
	<!-- </header> -->
	<nav name="tabsHorizontales" class="navbar navbar-dark bg-dark">
		<a href="${listeClientsUrl}" class="col-sm-3">Liste des Clients</a>
	</nav>

	<!-- VIREMENTS -->
	<div class="container-fluid">
		<form method="post">
			<legend>Effectuer un nouveau virement</legend>
			<div class="form-raw">
				<div class="col">
					<label for="Debiter">Compte à debiter</label> <select
						name="Debiter" id="Debiter">
						<c:forEach var="compte" items="${listCompte}">
							<option>${compte}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col">
					<label for="crediter">Compte à crediter</label> <select class="col"
						name="crediter" id="crediter">
						<c:forEach var="compte" items="${listCompte}">
							<option>${compte.id}-${compte.solde}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col">
					<label class="col" for="montant">Montant</label>
					<div class="input-group">
						<input type="text" class="form-control" id="montant"
							name="montant">
						<div class="input-group-prepend">
							<div class="input-group-text">€</div>
						</div>
					</div>
				</div>

				<div class="col">
					<button type="submit" class="btn btn-primary">Effectuer le
						virement</button>
				</div>
			</div>
		</form>
	</div>


	<!-- BAS DE PAGE -->
	<br>
	<br>
	<br>
	<br>
	<nav class="navbar fixed-bottom navbar-dark bg-dark">
		<footer class="container">
			<p>
				<font color="white"> 2018 © ProxiBanque. Tous droits
					réservés. </font>
			</p>
		</footer>
	</nav>
</body>
</html>