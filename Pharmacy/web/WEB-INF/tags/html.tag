<%@ tag language="java" %>
<%@ attribute name="thema" type="java.lang.String"%>
<%@ attribute name="title" type="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet"
	href="css/bootstrap${empty thema ? '' : '-'.concat(thema)}.min.css">
<title>${title}</title>
</head>
<body>
	<!-- LOGO -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="index.html" style="font-size: 250%; color: #1b8e99;"><img
			src="resources/mainSite/LogoPharmacy.png" height="64" width="56">
			Pharmacy </a>
		<!-- Logo -->

		<!-- Search -->
		<c:url value="/find.html" var="href" />
		<form class="form-inline my-2 my-lg-0" action="${href}" method="POST">
			<input class="form-control mr-sm-2" type="search" name="findName"
				placeholder="Enter name" aria-label="product search">
			<button class="btn btn-success my-2 my-sm-0" type="submit">
				Search <img src="resources/mainSite/Srch.png" height="15" width="15">
			</button>
			<!--  type="button" -->
		</form>
	</nav>

	<!-- jsp body -->
	<div>

		<jsp:doBody />

	</div>

	<!-- Footer -->
	<!--<div class="footer container-lg width-full p-responsive"
		role="contentinfo">
		<div
			class="position-relative d-flex flex-row-reverse flex-lg-row flex-wrap flex-lg-nowrap flex-justify-center flex-lg-justify-between pt-6 pb-2 mt-6 f6 text-gray border-top border-gray-light ">
			<ul
				class="list-style-none d-flex flex-wrap col-12 col-lg-5 flex-justify-center flex-lg-justify-between mb-2 mb-lg-0">
				<li class="w-100">admin: Kate Gorlan</li>
				<li class="col"><a href="https://new.vk.com/katya_gorlan"
					data-ga-click="Footer, go to vk, text:vk">vk</a></li>
			</ul>
		</div>
	</div>-->

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>