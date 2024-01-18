<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="pages/head.jsp"%>

<body class="v-light mini-nav fix-header fix-sidebar">
	<div id="main-wrapper">
		<!-- header -->
		<%@ include file="pages/header.jsp"%>
		<!-- #/ header -->
		<!-- sidebar -->
		<%@ include file="pages/nav.jsp"%>
		<!-- #/ sidebar -->
		<!-- content body -->
		 <!-- Dynamic Content -->
           <%@ include file="pages/content.jsp"%>
            

		<!-- footer -->
		<%@ include file="pages/footer.jsp"%>
		
		<!-- #/ footer -->

		<!-- Common JS -->
		<%@ include file="pages/js.jsp"%>
	</div>

</body>

</html>
