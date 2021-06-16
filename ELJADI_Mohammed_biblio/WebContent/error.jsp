<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Projet java</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="/ELJADI_Mohammed_biblio/css/style.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

<div class="container">

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-5">
    <div class="container-fluid">

      <a class="navbar-brand" href="#">Gestion de bibliothèque</a>
      
      <div class="collapse navbar-collapse " id="navbarText">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link text-warning" aria-current="page" href="/ELJADI_Mohammed_biblio">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-warning" href="/ELJADI_Mohammed_biblio/etudiant/listEtudiant.jsp">Gestion des étudiants</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-warning" href="/ELJADI_Mohammed_biblio/livre/listLivre.jsp">Gestion des livres</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-warning" href="/ELJADI_Mohammed_biblio/emprunt/listEmprunt.jsp">Gestion des emprunts</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

<div class="container-fluid pt-5">

  <div class="row w-200">
  
    <div class="col w-200">
      <div class="text-center">
        <a href="/ELJADI_Mohammed_biblio/emprunt/listEmprunt.jsp">
          <button class="btn btn-dark p-4 rounded-5 pt-5 pb-5 manage-button">
          
          	<%String msg = (String)session.getAttribute("error");
				if (msg != null) {
    			%>
    			
    			<p style="color:red"><%= msg %></p>
    			
    		<%
				}
			%>
				
          </button>
        </a>
      </div>
    </div>
    
    <div class="col w-200">
      <div class="text-center">
        
      </div>
    </div>
    
  </div>
  
</div>


</div>
</div>
<style type="text/css">
body{
    margin-top:20px;
    background:#f8f8f8
}
</style>

<script type="text/javascript">

</script>
</body>
</html>