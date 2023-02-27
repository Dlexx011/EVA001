package dao;

import java.util.ArrayList;
import java.util.List;
import bean.Cine;


public class CineDAO {
	
	db.Db db = new db.Db("Cinestar");

	public Object getCines(int id,boolean blista)
	{
		db.Sentencia(String.format("call sp_getCines()",id) );
		String[][] mRegistros = db.getRegistros();
		
		if (mRegistros == null) return null;
		if (!blista) return mRegistros;
		
		List<Cine> lstCines = new ArrayList<>();
		for ( String[] aRegistro : mRegistros)
			lstCines.add(new Cine(aRegistro));
		
		return lstCines;
	}
	public Object getCine(String id, boolean bEntidad) {
		db.Sentencia(String.format("call sp_getCine(%s)",id) );
		String[] aRegistro = db.getRegistro();
		
		if (aRegistro == null) return null;
		if (!bEntidad) return aRegistro;
					
		return new Cine(aRegistro);
		
		
	}
	

	

}
