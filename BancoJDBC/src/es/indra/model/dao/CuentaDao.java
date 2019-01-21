package es.indra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import es.indra.model.entities.Cuenta;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class CuentaDao implements Dao<Long, Cuenta> {
	private Connection getConexion() throws SQLException {

		Connection co = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return co;
	}

	@Override
	public void create(Cuenta entity) throws DaoException {
		try {
			Connection co = getConexion();
			PreparedStatement ps = co.prepareStatement("INSERT INTO CUENTA VALUES (?,?,?,?,?,?) ");
			ps.setString(1, entity.getId());
			ps.setFloat(2, entity.getComision());
			ps.setString(3, entity.getTipocuenta());
			ps.setFloat(4, entity.getSaldo());
			ps.executeUpdate();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
		
	}

	@Override
	public void update(Cuenta entity) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long key) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cuenta find(Long key) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cuenta> findAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
