package es.indra.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.indra.model.entities.Cliente;
import es.indra.model.entities.Cuenta;
import es.indra.model.support.Dao;
import es.indra.model.support.DaoException;
import es.indra.model.support.DatosConexion;

public class ClienteDao implements Dao<String, Cliente>{
	private Connection getConexion() throws SQLException {

		Connection con = DriverManager.getConnection(DatosConexion.URL, DatosConexion.USUARIO_BD,
				DatosConexion.PASSWORD_BD);
		return con;
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
		Cliente c = null;
		try {
			Connection con = getConexion();
			String query = "SELECT * FROM CLIENTE WHERE dni=?";
			PreparedStatement instruccion = con.prepareStatement(query);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM CUENTA WHERE ClienteDni=?");
			instruccion.setString(1, key);
			ResultSet resultados = instruccion.executeQuery();
			if (resultados.next()) {
				c = obtenerCliente(resultados);
				ps.setString(1, key);
				ResultSet resultado = ps.executeQuery();
				c.setPropiedades(obtenerCuentas(resultado));
			}
			con.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> findAll() throws DaoException {
		try {
			Connection con = getConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Cliente obtenerCliente(ResultSet resultado) throws SQLException {
		String dni = resultado.getString(1);
		String nombre = resultado.getString(2);
		String apellidos = resultado.getString(3);
		String direccion = resultado.getString(4);
		String telefono = resultado.getString(5);
		Cliente c = new Cliente(dni,nombre,apellidos,direccion,telefono);
		return c;

	}

	private List<Cuenta> obtenerCuentas(ResultSet resultado) throws SQLException {
		ArrayList<Cuenta> c = new ArrayList<Cuenta>();
		while (resultado.next()) {

			Cuenta cuenta = CuentaDao.obtenerCuenta(resultado);
			c.add(cuenta);
		}
		return c;
	}

}
