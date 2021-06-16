package dao;

import beans.Emprunt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IEmpruntDao {

	List<Emprunt> Lister() throws SQLException;
	void ajouter(Emprunt e) throws SQLException;
	void modifier(Emprunt e) throws SQLException;
	void supprimer(Number numero) throws SQLException;
	public Emprunt getEmpruntById(Number numero) throws SQLException;
	void emprunter(Number numero) throws SQLException;
	void extraire(String directoryPath) throws SQLException, IOException;

}
