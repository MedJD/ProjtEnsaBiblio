<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="beans.Emprunt"%>
<%@ page import="dao.EmpruntDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.LocalDate"%>


<html lang="en">
<head>
    <title>Gestion des étudiants</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<%
	EmpruntDao dao = new EmpruntDao();
	List<Emprunt> empruntList = dao.Lister();
	%>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

<div class="container">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-1">
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

<div class="row flex-lg-nowrap">

  <div class="col">
    <div class="e-tabs mb-3 mt-5 px-3">
      <ul class="nav nav-tabs">
        <li class="nav-item"><a class="nav-link active" href="/ELJADI_Mohammed_biblio/emprunt/listEmprunt.jsp">Liste des emprunts en cours</a></li>
        <li class="nav-item"><a class="nav-link" href="/ELJADI_Mohammed_biblio/emprunt/listEmprunt2.jsp">Liste des emprunts remis</a></li>
      </ul>
    </div>

    <div class="row flex-lg-nowrap">
      <div class="col mb-3">
        <div class="e-panel card">
          <div class="card-body">
            <div class="card-title">
              <h6 class="mr-2"><span>Liste des étudiants</span>
            </div>
            <div class="e-table">
              <div class="table-responsive table-lg mt-3">
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      
                      <th>Numero du livre</th>
                      <th class="max-width">CIN de l'étudiant</th>
                      <th class="sortable">Date d'emprunt</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <%
						for (Emprunt emprunt : empruntList) {
						if (emprunt.getRemis_le() == null) {
					%>
                    <tr>
                      
						<td class="text-nowrap align-middle"><%=emprunt.getNumero_livre()%></td>
						<td class="text-nowrap align-middle"><%=emprunt.getCin_etudiant()%></td>
						<td class="text-nowrap align-middle"><%=emprunt.getDate()%></td>
                      	<td class="text-center align-middle">
                        	<div class="btn-group align-top">
								<button class="btn btn-sm btn-outline-secondary badge" type="button" data-toggle="modal" data-target="#delete-<%=emprunt.getNumero() %>">Remettre</button>                      
							</div>
                      	</td>
                    </tr>
                    
    <div class="modal fade" role="dialog" tabindex="-1" id="delete-<%=emprunt.getNumero() %>">
      <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content pop-up">
          <div class="modal-header">
            <h5 class="modal-title">Ajouter un étudiant</h5>
            <button type="button" class="close" data-dismiss="modal">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="py-1">
              <form method="POST" action='/ELJADI_Mohammed_biblio/EmpruntHandler' name="formRemis">
				<input type="hidden" name="remis_le" value="<%=java.time.LocalDate.now()%>"/>
				<input type="hidden" name="numero" value="<%=emprunt.getNumero()%>" />
				<input type="hidden" name="action" value="remis" />
                    <div class="row">
                      <div class="col">
                        <div class="form-group">
                          etes-vous sur ?
                      </div>
                    </div>
                    
                    
                <div class="row">
                  <div class="col d-flex justify-content-end">
                    <button class="btn btn-primary" type="submit" value="Remis">Confirmer la remise</button>
                  </div>
                </div>
                
              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
                    
                    <%
                        	}
                        }
                    %>
                  </tbody>
                </table>
              </div>

            </div>
          </div>
        </div>
      </div>
      <div class="col-12 col-lg-3 mb-3">
        <div class="card">
          <div class="card-body">
            <div class="text-center px-xl-3">
              <button class="btn btn-dark btn-block" type="button" data-toggle="modal" data-target="#user-form-modal">Nouveau emprunt</button>
            </div>
          </div>
        </div>
      </div>
    </div>

    
    <div class="modal fade" role="dialog" tabindex="-1" id="user-form-modal">
      <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content pop-up">
          <div class="modal-header">
            <h5 class="modal-title">Ajouter un étudiant</h5>
            <button type="button" class="close" data-dismiss="modal">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="py-1">
              <form method="POST" action='/ELJADI_Mohammed_biblio/EmpruntHandler' name="formAddEmprunt">
				<input type="hidden" name="action" value="insert" />
				<input type="hidden" name="date" value="<%=java.time.LocalDate.now()%>"/>
				
				
                    <div class="row">
                      <div class="col">
                        <div class="form-group">
                          <label>Numero de livre</label>
                          <input class="form-control" name="numero_livre" type="text">
                        </div>
                      </div>
                    </div>
                    
                    <div class="row">
                      <div class="col">
                        <div class="form-group">
                          <label>CIN de l'étudiant</label>
                          <input class="form-control" name="cin_etudiant" type="text">
                        </div>
                      </div>
                    </div>
                    
                    

                <div class="row">
                  <div class="col d-flex justify-content-end">
                    <button class="btn btn-primary" type="submit" value="insert">Confirmer la céation</button>
                  </div>
                </div>
                
              </form>

            </div>
          </div>
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