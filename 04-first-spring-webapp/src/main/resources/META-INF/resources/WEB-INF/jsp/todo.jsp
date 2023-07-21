<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Enter Todo Details</h1>
	<form:form method="post" modelAttribute="todo">
		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>

		<!--  Description: <form:input type="text" path="description" required="required" name="description" />-->
		<form:errors path="description" cssClass="text-warning" />
		<input type="submit" class="btn btn-success" />
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="username" />
		<form:input type="hidden" path="targetDate" />
		<form:input type="hidden" path="done" />
	</form:form>

</div>
<script
	src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'dd.mm.yyyy'
		});
	</script>
<%@ include file="common/footer.jspf"%>