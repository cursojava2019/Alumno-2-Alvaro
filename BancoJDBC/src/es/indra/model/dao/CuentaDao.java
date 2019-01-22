package es.indra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import es.indra.model.entities.Cuenta;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class CuentaDao implements Dao<Long, Cuenta> {
	private Connection getConexion() throws SQLException {

		Connection con = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return con;
	}

	@Override
	public void create(Cuenta entity) throws DaoException {
		try {
			Connection con = getConexion();
			PreparedStatement ps = con.prepareStatement("INSERT INTO CUENTA VALUES (?,?,?,?,?) ");
			ps.setString(1, entity.getId());
			ps.setFloat(2, entity.getComision());
			ps.setString(3, entity.getTipocuenta());
			ps.setFloat(4, entity.getSaldo());
			ps.setString(5, entity.getDnicliente());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
		
	}

	@Override
	public void update(Cuenta entity) throws DaoException {
		try {
			Connection con = getConexion();
			PreparedStatement ps = con.prepareStatement("UPDATE CUENTA SET saldo=? WHERE id=?");
			ps.setFloat(1, entity.getSaldo());
			ps.setString(2, entity.getId());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error creando objeto en BBDD");
			throw new DaoException();
		}
		
	}

	@Override
	public void delete(Long key) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cuenta find(String key) throws DaoException {
		Cuenta c = null;
		try {
			Connection con = getConexion();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM CUENTA WHERE id=?");
			ps.setString(1, key);
			ResultSet resultados = ps.executeQuery();
			if (resultados.next()) {
				c = obtenerCuenta(resultados);

			}
			con.close();
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cuenta> findAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected static Cuenta obtenerCuenta(ResultSet resultado) throws SQLException {
		String id = resultado.getString(1);
		Float comision = resultado.getFloat(2);
		String tipoCuenta = resultado.getString(3);
		Float saldo = resultado.getFloat(4);
		String dnicliente = resultado.getString(5);
		/*if (dni != null && !dni.equalsIgnoreCase("")) {
			vendido = true;
		}*/
		Cuenta c = new Cuenta(id,comision,tipoCuenta,saldo,dnicliente);
		return c;
	}

}
