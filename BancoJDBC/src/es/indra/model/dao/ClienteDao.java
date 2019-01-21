package es.indra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import es.indra.model.entities.Cliente;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class ClienteDao implements Dao<String, Cliente>{
	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Cliente entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO CLIENTE VALUES (?,?,?,?,?) ");
			ps.setString(1, entity.getDni());
			ps.setString(2, entity.getNombre());
			ps.setString(3, entity.getApellidos());
			ps.setString(4, entity.getDireccion());
			ps.setString(5, entity.getTelefono());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
		
	}

	@Override
	public void update(Cliente entity) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String key) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente find(String key) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
