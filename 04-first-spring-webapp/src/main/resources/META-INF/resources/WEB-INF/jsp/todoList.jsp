<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>${name}'sTodo List</h1>
	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>description</th>
				<th>target date</th>
				<th>done</th>
			</tr>
		</thead>
		<tbody>


			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="edit-todo?id=${todo.id}"
						class="btn btn-sm btn-warning">Edit</a></td>
					<td><a href="delete-todo?id=${todo.id}"
						class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-primary" href="add-todo">Add new</a>

</div>
<%@ include file="common/footer.jspf"%>