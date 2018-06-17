<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<%-- <%=request.getContextPath()%> --%>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
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
						<img name="logo" src="${pageContext.request.contextPath}/images/logo-banque.jpg" alt="LOGO">
					</a>
				</div>
				<div class="col-md-8 d-flex justify-content-center align-items-center">
				<h1><font color="white">ProxiBanque Conseiller Clientèle</font></h1>
				</div>
			  <!-- UserName -->
				<div class="Connexion col-md-2">
					<h4><font color="green" style="font-variant: small-caps;"><b>NomConseiller</b></font></h4>
					<h5><font color="green" style="font-variant: small-caps;"><b>Connected</b></font></h5>
				</div>
		</nav>
	<!-- </header> -->
		<nav name="tabsHorizontales" class="navbar navbar-dark bg-dark">
			<a id="ListeClientColor" href="${listeClientsUrl}" class="col-sm-3">Liste des Clients</a>
			<a href="${listeComptesUrl}" class="col-sm-3">Liste des comptes</a>
			<a href="${virementsUrl}" class= "col-sm-3">Virements compte à compte</a>
		</nav>
		
	<!-- LISTING DES CLIENTS -->
		<div class="container-fluid">
			<h4><b>Présentation de la liste de vos Clients</b></h4>
			<table id="liste" class="listeClient">
				<thead style="font-variant: small-caps;">
					<tr>
						<th> Id Client </th>
						<th> Nom </th>
						<th> Prénom </th>
						<th> e-mail </th>
						<th> adresse </th>
						<th>   </th>
						<th>   </th>
						<th>   </th>
					</tr>
				</thead> 	
				<tbody>
					<tr>
						<td>'${client.id}'</td>
						<td>${client.Nom}</td>
						<td>${client.Prenom}</td>
						<td>${client.Mail}</td>
						<td>${client.Adresse}</td>
						<td>${client.DeleteById}</td>
						<td><a href="${listeComptesUrl}"><button><h7><font style="font-variant: small-caps;">Liste des comptes</font></h7></button></a></td>
						<td><a href="${virementsUrl}"><button><h7><font style="font-variant: small-caps;">Virements</font></h7></button></a></td>
					</tr>
					<tr>
						<td>1</td>
						<td>COC</td>
						<td>Cobby</td>
						<td>Cobby@gmail.com</td>
						<td>15 rue de ton frère, 45000 Orleans</td>
						<td><a data-target="#Editer" ><button><h7><font style="font-variant: small-caps;">Edition</font></h7></button></a></td>
						<td><a href="${listeComptesUrl}"><button><h7><font style="font-variant: small-caps;">Liste des comptes</font></h7></button></a></td>
						<td><a href="${virementsUrl}"><button><h7><font style="font-variant: small-caps;">Virements</font></h7></button></a></td>
						</tr>
				</tbody>
			</table>
		</div>
		
	<!-- BAS DE PAGE -->
	<br><br><br><br>
		<nav class="navbar fixed-bottom navbar-dark bg-dark">
			<footer class="container">
				<p><font color="white"> 2018 © ProxiBanque. Tous droits réservés. </font></p>
			</footer>
		</nav>
	</body>
</html>