<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes Page</title>
<%@ include file="components/bootstrap_css.jsp" %>
</head>
<body>
<%@ include file="components/homenavbar.jsp" %>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">WRITE YOUR NOTES</p>
						<form action="addnote" method="post">
							
							<div class="mb-3">
								<label class="form-label">Title</label> <input
									name="title" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Description</label>
								<textarea rows="10" cols="46" class="form control" name="description"></textarea>	
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">AddNotes</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>