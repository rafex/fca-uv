<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7]>
<html lang="es"  class="no-js lt-ie9 lt-ie8 lt-ie7"></html><![endif]-->
<!--[if IE 7]>
<html lang="es"  class="no-js lt-ie9 lt-ie8"></html><![endif]-->
<!--[if IE 8]>
<html lang="es"  class="no-js lt-ie9"></html><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="es"  class="no-js">
<!--<![endif]-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sistemas de la Facultad de Contaduría y Administración de Xalapa - Universidad Veracruzana</title>

  <spring:url value="/resources/" var="path" />
  <link rel="stylesheet" href="${path}css/login.css"/>
  <%--<link rel="stylesheet" href="${path}jquery.mobile-1.4.5/jquery.mobile-1.4.5.css"/>--%>
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
  <!--[if lt IE 9]>
  <script src="${path}js/html5shiv.js"></script>
  <script src="${path}js/respond.min.js"></script>
  <script src="${path}js/lte-ie7.js"></script>
  <![endif]-->

  <%--<link rel="icon" type="image/x-icon" href="<%=imgPath%>/favicon.ico">--%>
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- librerias -->
  <script type="text/javascript" src="${path}js/jquery.js"></script>
  <%--<script type="text/javascript" src="${path}jquery.mobile-1.4.5/jquery.mobile-1.4.5.js"></script>--%>
  <script type="text/javascript" src="${path}js/prefixfree.min.js"></script>

  <script type="text/javascript">
    var staticPath = "${path}";
  </script>


</head>
<body id="bodyPage">
<div id="containerInit">
  <div id="init"></div>
</div>

<script type="text/javascript" src="${path}js/login.js"></script>
</body>
</html>
