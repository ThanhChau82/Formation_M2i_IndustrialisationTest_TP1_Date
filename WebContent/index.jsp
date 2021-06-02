<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
	  <div class="row">
	    <div class="col">
	    </div>
	    
	    <div class="col">
			<form method="get" action="DateServlet">
			  <div class="mb-3">
			    <label for="annee" class="form-label">Année : </label>
			    <input type="text" pattern="[0-9]{4,}" required name="annee" class="form-control" id="annee" >
			  </div>
			  <div class="mb-3">
			    <label for="mois" class="form-label">Mois :</label>
			    <input type="text" pattern="[0-9]{1,2}" required name="mois" class="form-control" id="mois">
			  </div>
			  <div class="mb-3">
			    <label for="jour" class="form-label">Jour : </label>
			    <input type="text" required name="jour" class="form-control" id="jour">
			  </div>
		
			  <div class="mb-3">
			  	<button type="submit" class="btn btn-primary">Vérifier date valide</button>
			  </div>
			  
			  <!-- Afficher le message d'erreur -->
			  <% if(request.getAttribute("erreur") != null) { %>
			  	<div class="alert alert-danger" role="alert" >
					<%=request.getAttribute("erreur") %>
				</div>
			  <% } %>
			  			  
			</form>    
		</div>
		
	    <div class="col">	      
	    </div>
	  </div>
	</div>
</body>
</html>