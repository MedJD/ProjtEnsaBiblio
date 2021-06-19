package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date; 
import java.util.List;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;

import beans.Emprunt;
import beans.Etudiant;
import beans.Livre;
import dao.EmpruntDao;
import dao.EtudiantDao;
import dao.LivreDao;

import java.io.IOException;

public class Menu {

	public static void main(String[] args) throws SQLException, ParseException, IOException {
		try
		{
			menuPrincipal();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			menuPrincipal();
		}

	}
	
	static public void menuPrincipal() throws SQLException, ParseException, IOException {
		
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		for(;quit == false;)
		{
			
			System.out.println("1- Gerer les livres");
			System.out.println("2- Gerer les etudiants");
			System.out.println("3- Emprunter un livre");
			System.out.println("4- Remettre un livre");
			System.out.println("5- Enregistrer les donnees dans des fichiers CSV.");
			System.out.println("6- Quitter");
			System.out.println("");
			System.out.print("Entrez votre choix: ");
			
			String choix = sc.nextLine();
			switch (choix) {
			  case "1":
				  	menuLivres(sc);
				  	break;
			  case "2":
				  	menuEtudiants(sc);
				  	break;
			  case "3":
				  	Emprunt emp = new Emprunt();
				  	String Stdin;
				  	
				  	System.out.print("Numéro du livre à emprunter: ");
					Stdin = sc.nextLine();
					emp.setNumero_livre(Integer.parseInt(Stdin));
					
					System.out.print("Cin de l'étudiant: ");
					Stdin = sc.nextLine();
					emp.setCin_etudiant(Stdin);
					
	                LocalDate date = java.time.LocalDate.now();
	                String today = date.toString();
					emp.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(today));
					
					emp.setRemis_le(null);
					
					EmpruntDao eDao = new EmpruntDao();
					eDao.ajouter(emp);
				    
				    break;
			  case "4":
				    EmpruntDao e1Dao = new EmpruntDao();
				    
				    System.out.print("Numéro de l'emprunt: ");
					Stdin = sc.nextLine();
				    Emprunt empr = e1Dao.getEmpruntById(Integer.parseInt(Stdin));
				    
				    LocalDate remis_date = java.time.LocalDate.now();
	                String today1 = remis_date.toString();
					empr.setRemis_le(new SimpleDateFormat("yyyy-MM-dd").parse(today1));
					
					e1Dao.modifier(empr);
					e1Dao.emprunter(Integer.parseInt(Stdin));
				    
				    break;
			  case "5":
				    menuExtraire(sc);
				    break;
			  case "6":
				    System.out.println("Vous avez choisi de quitter le programme ;)");
				    quit = true;
				    sc.close();
				    break;
			  default:
				  	System.out.println("Choix invalid");
			}
			
		}
	}
	
	@SuppressWarnings("deprecation")
	static public void menuLivres(Scanner sc) throws SQLException {
		
		boolean quit = false;
		for( ; quit == false ; )
		{
			
			System.out.println("1- Lister les livres");
			System.out.println("2- Alimenter le stock d’un livre");
			System.out.println("3- Ajouter un livre");
			System.out.println("4- Modifier un livre ");
			System.out.println("5- Supprimer un livre");
			System.out.println("6- Quitter le menu Gestion des livres");
			System.out.println("");
			System.out.print("Entrez votre choix: ");
			
			String choix = sc.nextLine();
			String Stdin;
			
			switch (choix) {
			  case "1":
				LivreDao livreDao = new LivreDao();
				List<Livre> ls = new ArrayList<Livre>();
				ls = livreDao.Lister();
				for(int i = 0; i < ls.size(); i++) {
				    System.out.println(ls.get(i));
				}

			    break;
			  case "2":
				  	Livre livr = new Livre();
				    LivreDao lDao = new LivreDao();
					
					System.out.println("ID du livre à alimenter: ");
					Stdin = sc.nextLine();
					livr = lDao.getLivreById(Integer.parseInt(Stdin));
					
					System.out.print("Nouveau stock: ");
					Stdin = sc.nextLine();
					livr.setStock(Integer.parseInt(Stdin));

					lDao.modifier(livr);
					System.out.println("Stock alimenté avec succes");
			    break;
			  case "3":
					Livre l = new Livre();
					
					System.out.print("Titre du livre: ");
					Stdin = sc.nextLine();
					l.setTitre(Stdin);
					
					System.out.print("Numéro d'édition: ");
					Stdin = sc.nextLine();
					l.setNumero_edition(Stdin);
					
					System.out.print("Date d'apparition (JJ/MM/AAAA): ");
					Stdin = sc.nextLine();
					l.setDate_apparition(new Date(Stdin));
					
					
					System.out.print("Stock: ");
					Stdin = sc.nextLine();
					l.setStock(Integer.parseInt(Stdin));
					
					LivreDao lnDao = new LivreDao();
					lnDao.ajouter(l);
					System.out.println("Livre ajouté avec succes");
				    break;
			  case "4":
				    Livre li = new Livre();
				    LivreDao liDao = new LivreDao();
					
					System.out.println("ID du livre à modifier: ");
					Stdin = sc.nextLine();
					li = liDao.getLivreById(Integer.parseInt(Stdin));
					
					System.out.print("Nouveau titre: ");
					Stdin = sc.nextLine();
					li.setTitre(Stdin);
					
					System.out.print("Nouveau numéro d'édition: ");
					Stdin = sc.nextLine();
					li.setNumero_edition(Stdin);
					
					System.out.print("Nouvelle date d'apparition (JJ/MM/AAAA): ");
					Stdin = sc.nextLine();
					li.setDate_apparition(new Date(Stdin));
					
					
					System.out.print("Stock: ");
					Stdin = sc.nextLine();
					li.setStock(Integer.parseInt(Stdin));

					liDao.modifier(li);
					System.out.println("Livre modifié avec succes");
				    break;
			  case "5":
				    LivreDao livDao = new LivreDao();
					
					System.out.println("ID du livre à supprimer: ");
					Stdin = sc.nextLine();
					livDao.supprimer(Integer.parseInt(Stdin));
					
					System.out.println("Livre modifié avec succes");
				    break;
			  case "6":
				    System.out.println("");
				    quit = true;
				    break;
			  default:
			    System.out.println("Choix invalid");
			}
		}
	}
	
	static public void menuEtudiants(Scanner sc) throws SQLException {
		
		boolean quit = false;
		for( ; quit == false ; )
		{
			
			System.out.println("1- Lister les étudiants");
			System.out.println("2- Ajouter un étudiant");
			System.out.println("3- Modifier un etudiant ");
			System.out.println("4- Supprimer un livre");
			System.out.println("5- Quitter le menu Gestion des Etudiants");
			
			System.out.print("Entrez votre choix: ");
			
			String choix = sc.nextLine();
			switch (choix) {
			  case "1":
				EtudiantDao EtudiantDao = new EtudiantDao();
				List<Etudiant> ls = new ArrayList<Etudiant>();
				
				ls = EtudiantDao.Lister();
				int i = -1;
				while (++i < ls.size())
					System.out.println(ls.get(i));
			    break;
			    
			  case "2":
					Etudiant e = new Etudiant();
					EtudiantDao eDao = new EtudiantDao();
					String Stdin;
					
					System.out.print("CIN de l'étudiant: ");
					Stdin = sc.nextLine();
					e.setCin(Stdin);	
					
					System.out.print("Nom de l'étudiant: ");
					Stdin = sc.nextLine();
					e.setNom(Stdin);
					
					System.out.print("Prenom de l'étudiant: ");
					Stdin = sc.nextLine();
					e.setPrenom(Stdin);
					
					System.out.print("Fillière de l'étudiants: ");
					Stdin = sc.nextLine();
					e.setFiliere(Stdin);
					
					eDao.ajouter(e);
			    break;
			    
			  case "3":
				  Etudiant et = new Etudiant();
				  EtudiantDao etDao = new EtudiantDao();
				  
				  System.out.println("CIN de l'étudiant à modifier: ");
				  String input = sc.nextLine();
				  et = etDao.getEtudiantById(input);
				  
				  System.out.print("Nouveau nom: ");
				  String nom = sc.nextLine();
				  et.setNom(nom);
				  
				  System.out.print("Nouveau prenom: ");
				  String prenom = sc.nextLine();
				  et.setPrenom(prenom);
				  
				  System.out.print("Nouvelle filière: ");
				  String filiere = sc.nextLine();
				  et.setFiliere(filiere);
				  
				  etDao.modifier(et);
				    break;    
			  case "4":
				  EtudiantDao etudao = new EtudiantDao();
				  System.out.println("CIN de l'étudiant à supprimer: ");
				  String eInput = sc.nextLine();
				  
				  etudao.supprimer(eInput);
				  
				    break;
			  case "5":
				  System.out.println("vous avez quitter l'espace de gestion des etudiants");
				    quit = true;
				  break;
				 
			  default:
			    System.out.println("Choix invalid");
			}
		}
	}
	
	static public void menuExtraire(Scanner sc) throws SQLException, IOException {
		
		boolean quit = false;
		for( ; quit == false ; )
		{
			
			System.out.println("1- Extraire la liste des étudiants");
			System.out.println("2- Extraire les livres");
			System.out.println("3- Extraire les emprunts");
			System.out.println("4- Quitter le menu Extraire");
			
			System.out.print("Entrez votre choix: ");
			
			String choix = sc.nextLine();
			switch (choix) {
			  case "1":
				EtudiantDao EtudiantDao = new EtudiantDao();
				EtudiantDao.extraire();
			    break;
			    
			  case "2":
				  LivreDao LivreDao = new LivreDao();
				  LivreDao.extraire();
				  break;
			    
			  case "3":
				  EmpruntDao EmpruntDao = new EmpruntDao();
				  EmpruntDao.extraire();
				  break;
			  case "4":
				    quit = true;
				  break;
				 
			  default:
			    System.out.println("Choix invalid");
			}
		}
	}
}
