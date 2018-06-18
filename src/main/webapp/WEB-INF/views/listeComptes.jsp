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
				<font color="green" style="font-variant: small-caps;"><b>NomConseiller</b></font>
			</h4>
			<h5>
				<font color="green" style="font-variant: small-caps;"><b>Connected</b></font>
			</h5>
		</div>
	</nav>
	<!-- </header> -->
	<nav name="tabsHorizontales" class="navbar navbar-dark bg-dark">
		<a href="${listeClientsUrl}" class="col-sm-3">Liste des Clients</a> <a
			id="ListeCompteColor" href="${listeComptessUrl}" class="col-sm-3">Liste
			des comptes</a> <a href="${virementsUrl}" class="col-sm-3">Virements
			compte à compte</a>
	</nav>

	<!-- LISTE DES COMPTES D'UN CLIENTS -->
	<div class="container-fluid">
		<h4>
			<b>Liste des comptes d'un client</b>
		</h4>
		<ul>
			<li>Rentrer l'id d'un client: <input id="creditCE"
				name="creditCE" type="number"></li>
			<div>
				<input type="submit">
			</div>
		</ul>
		<div class="raw">
			<h2>Comptes Courants</h2>
			<table class="listeClient">
				<thead style="font-variant: small-caps;">
					<th>Id Compte</th>
					<th>Solde</th>
					<th>Decouvert</th>
				</thead>
				<tbody>
					<c:forEach var="CompteCourant" items="${listCompteCourant}">
						<tr>
							<td>${CompteCourant.id}</td>
							<td>${CompteCourant.solde}</td>
							<td>${CompteCourant.decouvert}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="raw">
		<h2>Comptes Epargnes</h2>
			<table class="listeClient">
				<thead style="font-variant: small-caps;">
					<th>Id Compte</th>
					<th>Solde</th>
					<th>Taux</th>
				</thead>
				<tbody>
					<c:forEach var="CompteEpargne" items="${listCompteEpargne}">
						<tr>
							<td>${CompteEpargne.id}</td>
							<td>${CompteEpargne.solde}</td>
							<td>${CompteEpargne.taux}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
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