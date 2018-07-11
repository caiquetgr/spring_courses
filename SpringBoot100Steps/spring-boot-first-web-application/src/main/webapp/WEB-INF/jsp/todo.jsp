<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		ADD Todo Page

		<form:form method="post" action="update-todo" modelAttribute="todo">
			<form:hidden path="id" />
			<form:hidden path="done"/>
			<fieldset class="form-group">
				<form:label path="desc">Description:</form:label> 
				<form:input name="desc" type="text" path="desc" class="form-control" required="required" />
				<form:errors path="desc" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">Target Date</form:label>
				<form:input path="targetDate" type="text" class="form-control" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"/> 
			</fieldset>
				
			<button type="submit" class="btn btn-success">Update</button>
		</form:form>
	</div>
</body>
</html>