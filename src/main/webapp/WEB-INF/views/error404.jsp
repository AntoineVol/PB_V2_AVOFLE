<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<%-- <%=request.getContextPath()%> --%>
<title>Error404</title>
<base href="/">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/index.css" />

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- LISTE DES URLs -->
	<c:url value="/listeClients" var="listeClientsUrl" />


	<!-- Entête avec Logo -->
	<header class="container-fluid">
		<nav class="navbar fixed-top navbar-dark bg-dark">
			<div class="col-md-2">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">
					<img name="logo"
					src="${pageContext.request.contextPath}/images/logo-banque.jpg"
					alt="LOGO">
				</a>
			</div>
			<div class="col-md-3">
				<h1>
					<font color="white">ProxiBanque</font>
				</h1>
			</div>

			<!-- USERNAME A RECUPERER ET AFFICHER ${Conseiller.Nom} -->
			<div class="Connexion col-md-2">
				<a href="${listeClientsUrl}"><button class="btn">
						<h5>
							<font color="white">Connexion</font>
						</h5>
					</button></a>
			</div>
		</nav>
	</header>

	<!-- Texte d'intro -->
	<section class="container">
		<div>
			<h1>
				<b>Error 404</b>
			</h1>
		</div>

		<!-- Table pour naviguer -->
		<div name="tabCentrale" class="container">
			<h2>Cher Conseiller de clientèle</h2>
			<h4>La page demandée est innexistante</h4>
		</div>
	</section>

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