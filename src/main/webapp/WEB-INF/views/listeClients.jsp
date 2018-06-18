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
	<c:url value="/listeComptes?idClient=" var="listeComptesUrl" />
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
		<a id="ListeClientColor" href="${listeClientsUrl}" class="col-sm-3">Liste
			des Clients</a><a href="${virementsUrl}" class="col-sm-3">Virements
			compte à compte</a>
	</nav>

	<!-- LISTING DES CLIENTS -->
	<div class="container-fluid">
		<h4>
			<b>Présentation de la liste de vos Clients</b>
		</h4>
		<table id="liste" class="listeClient">
			<thead style="font-variant: small-caps;">
				<tr>
					<th>Id Client</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Mail</th>
					<th>adresse</th>
					<th>Edition</th>
					<th>Details</th>
					<th>Suppression</th>
				</tr>
			</thead>
			<tbody>
				<c:url value="/listeClients?idDeleted=" var="deleteUrl" />
				<c:forEach var="client" items="${listClient}">
					<tr>
						<td>${client.id}</td>
						<td>${client.nom}</td>
						<td>${client.prenom}</td>
						<td>${client.mail}</td>
						<td>${client.adresse}</td>
						<td><a data-target="#Editer"><button>
									<h7> <font style="font-variant: small-caps;">Edition</font></h7>
								</button></a></td>
						<td><a href="${listeComptesUrl}${client.id}"><button>
									<h7> <font style="font-variant: small-caps;">Liste
										des comptes</font></h7>
								</button></a></td>
						<td><a
							href="${deleteUrl}${client.id}&action=suppressionClient"><button>
									<h7> <font style="font-variant: small-caps;">Suppression</font></h7>
								</button></a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container-fluid">
		<form method="post">
			<legend>Nouveau client</legend>
			<div class="form-row">
				<div class="col">
					<input type="text" class="form-control" value=${idCsl} name="idCsl" id="idCsl"/>
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="Nom"
						name="nomNouveauClient" id="nomNouveauClient">
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="Prenom"
						name="prenomNouveauClient" id="prenomNouveauClient">
				</div>
				<div class="col">
					<input type="email" class="form-control"
						placeholder="mail@gmail.com" name="mailNouveauClient"
						id="mailNouveauClient">
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="adresse"
						name="adresseNouveauClient" id="adresseNouveauClient">
				</div>
				<div class="col">
					<button type="submit" class="btn btn-primary">Créer</button>
				</div>
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