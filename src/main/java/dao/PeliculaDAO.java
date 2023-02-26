package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Pelicula;

public class PeliculaDAO {
	db.Db db = new db.Db("Cinestar");
	
	//blista es true : se devuelve una lisa de peliculas
	//blista es false : se devuelve una matriz de peliculas
	public Object getPeliculas(int id,boolean blista) {
		db.Sentencia(String.format("call sp_getPeliculas(%s)",id) );
		String[][] mRegistros = db.getRegistros();
		
		if (mRegistros == null) return null;
		if (!blista) return mRegistros;
		
		List<Pelicula> lstPeliculas = new ArrayList<>();
		for ( String[] aRegistro : mRegistros)
			lstPeliculas.add(new Pelicula(aRegistro));
		
		return lstPeliculas;
		
	}

	public Object getPelicula(String id, boolean bEntidad) {
			db.Sentencia(String.format("call sp_getPelicula(%s)",id) );
			String[] aRegistro = db.getRegistro();
			
			if (aRegistro == null) return null;
			if (!bEntidad) return aRegistro;
						
			return new Pelicula(aRegistro);
			
			
	}
	
	
}
