<%@ tag language="java"%>
<%@ attribute name="thema" type="java.lang.String"%>
<%@ attribute name="title" type="java.lang.String"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap${empty thema ? '' : '-'.concat(thema)}.min.css">
<title>${title}</title>
</head>
<body style="width: 100%; height: 100%;">
    <!-- LOGO -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="index.html" style="font-size: 200%; color: white;"><img src="resources/mainSite/Logo1.png" height="56"
            width="56"> Pharmacy </a>
    </nav>

    <!-- jsp body -->
    <div>
        <jsp:doBody />
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>