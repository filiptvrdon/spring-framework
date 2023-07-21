<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div>
	<h1>Hello!</h1>
</div>
<div>
	<pre>${errorMessage}</pre>
</div>
<form method="post">
	Name: <input type="text" name="name"> Password: <input
		type"password" name="password"> <input type="submit">
</form>
<%@ include file="common/footer.jspf"%>