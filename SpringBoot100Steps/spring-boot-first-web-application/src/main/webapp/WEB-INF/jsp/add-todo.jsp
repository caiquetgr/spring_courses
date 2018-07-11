<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First Web Application</title>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>


<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="webjars/bootstrap-datepicker/1.0.1/css/datepicker.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		ADD Todo Page

		<form:form method="post" action="add-todo" modelAttribute="todo">
			<form:hidden path="id" />
			<form:hidden path="done"/>
			<fieldset class="form-group">
				<form:label path="desc">Description:</form:label> 
				<form:input name="desc" type="text" path="desc" class="form-control" required="required" />
				<form:errors path="desc" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">Target Date</form:label>
				<form:input id="targetDate" path="targetDate" type="text" class="form-control" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"/> 
			</fieldset>
				
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
	
	
<script>
	$('#targetDate').datepicker({
		format: 'dd/mm/yyyy'
	})
</script>
</body>
</html>