package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import beans.Emprunt;
import beans.Etudiant;
import beans.Livre;
import dao.EmpruntDao;
import dao.EtudiantDao;
import dao.LivreDao;

public class Menu {

	public static void main(String[] args) {
		try {
			menu1();
//			menu2();
//			menu3();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static public void menu1() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		for(;quit == false;)
		{
			System.out.println("________________________________________________");
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
				  	menu2(sc);
				  	break;
			  case "2":
				  	System.out.println("Gestion des etudiants");
				  	break;
			  case "3":
				    System.out.println("Emprunter un livres");
				    break;
			  case "4":
				    System.out.println("Remettre un livre");
				    break;
			  case "5":
				    System.out.println("Enregistrer les donnees en CSV");
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
		
		//ADD Etudiant Test
//		Etudiant e = new Etudiant();
//		e.setCin("IB229273");
//		e.setFiliere("GRT2");
//		e.setNom("EL JADIDIDI");
//		e.setPrenom("Moha");
//		EtudiantDao eDao = new EtudiantDao();
//		eDao.ajouter(e);
	}
	@SuppressWarnings("deprecation")
	static public void menu2(Scanner sc) throws SQLException {
		
		boolean quit = false;
		for( ; quit == false ; )
		{
			System.out.println("________________________________________________");
			System.out.println("1- Lister les livres");
			System.out.println("2- Alimenter le stock d’un livre");
			System.out.println("3- Ajouter un livre");
			System.out.println("4- Modifier un livre ");
			System.out.println("5- Supprimer un livre");
			System.out.println("6- Quitter le menu Gestion des livres");
			System.out.println("");
			System.out.print("Entrez votre choix: ");
			
			String choix = sc.nextLine();
			switch (choix) {
			  case "1":
				LivreDao lDao = new LivreDao();
				List<Livre> ls = new ArrayList<Livre>();
				ls = lDao.Lister();
				for(int i = 0; i < ls.size(); i++) {
				    System.out.println(ls.get(i));
				}

			    break;
			  case "2":
			    System.out.println("");
			    break;
			  case "3":
					Livre l = new Livre();
					String Stdin;
					
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
					
//					l.setDate_apparition(new Date("08/08/2022"));
//					l.setNumero_edition("edition 33");
//					l.setStock(10);
//					l.setTitre("SSSSS");
//					l.setNumero(7);
					LivreDao lnDao = new LivreDao();
					lnDao.ajouter(l);
					System.out.println("Livre ajouté avec succes");
				    break;
			  case "4":
				    System.out.println("");
				    break;
			  case "5":
				    System.out.println("");
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
	static public void menu3() throws SQLException {
		System.out.println("Menu3");
		
		//ADD Emprunt TEST
		Emprunt emp = new Emprunt();
		emp.setCin_etudiant("IB229273");
		emp.setDate(new Date());
		emp.setNumero_livre(1);
		emp.setRemis_le(new Date());
		emp.setNumero(4);
		EmpruntDao eDao = new EmpruntDao();
		eDao.modifier(emp);
	}
	
//	static public void wait_enter() {
//		System.out.println("\n\nCliquez 'entrer' pour continuer");
//		Scanner c = new Scanner(System.in);
//		String s = c.nextLine();
//		c.close();
//	}

}
