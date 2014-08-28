package com.nextel.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.nextel.dashboard.bean.MatrixBean;


@Repository
public class AdminMatrixDAOImpl implements AdminMatrixDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    private List<MatrixBean> listMatrix = null;
    
    private MatrixBean db = null;
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/*
	 * 
	 * */
	public int getIdScalingMatrix(){
		int idScalingMatrix = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT MAX(idScalingMatrix) FROM matrix";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				idScalingMatrix = rs.getInt(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		//Plus one and return
		idScalingMatrix = idScalingMatrix + 1;
		return idScalingMatrix;
	}
	
	
	/*
	 * 
	 * */
	public boolean createMatrix(MatrixBean db){
		boolean created = false;
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "INSERT INTO matrix (idScalingMatrix, idAuth, NameTeam, NameTeamPuesto, Support, SupportPuesto, EscalationLevel, " +
				  "EscalationLevelPuesto, enabled) " + 
				  "VALUES(?,?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, db.getIdScalingMatrix());
			pstm.setString(2, db.getIdAuth());
			pstm.setString(3, db.getNameTeam());
			pstm.setString(4, db.getNameTeamPuesto());
			pstm.setString(5, db.getSupport());
			pstm.setString(6, db.getSupportPuesto());
			pstm.setString(7, db.getEscalationLevel());
			pstm.setString(8, db.getEscalationLevelPuesto());
			pstm.setString(9, enabled);
			int res = pstm.executeUpdate();
			
			if(res == 1){
				created = true;
			}
			
			System.out.println("RESULT " + res);
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL MATRIX CREATE" + sqle.getMessage());
		}
		
		return created;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteMatrix(String idScalingMatrix){
		boolean deleted = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "UPDATE matrix SET enabled='Baja' WHERE idScalingMatrix=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idScalingMatrix);
			int res = pstm.executeUpdate();
			
			System.out.println("RESULT " + res);
			
			if(res == 1){
				deleted = true;
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return deleted;
	}
		
	
	/*
	 * 
	 * */
	public boolean updateMatrix(MatrixBean db){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			qry = "UPDATE matrix SET NameTeam=?, NameTeamPuesto=?, Support=?, SupportPuesto=?, EscalationLevel=?, "
				  + "EscalationLevelPuesto=? "	
				  + "WHERE idScalingMatrix=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, db.getNameTeam());
			pstm.setString(2, db.getNameTeamPuesto());
			pstm.setString(3, db.getSupport());
			pstm.setString(4, db.getSupportPuesto());
			pstm.setString(5, db.getEscalationLevel());
			pstm.setString(6, db.getEscalationLevelPuesto());
			pstm.setInt(7, db.getIdScalingMatrix());
			
			int res = pstm.executeUpdate();
			
			System.out.println("RESULT " + res);
			
			if(res == 1){
				updated = true;
			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return updated;
	}
	
	
	/*
	 * 
	 * */
	public List<MatrixBean> getListNameTeam(String idAuth){
		listMatrix = new ArrayList<MatrixBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT idScalingMatrix, NameTeam FROM matrix WHERE idAuth = ? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, enabled);
			rs = pstm.executeQuery();

			while(rs.next()){				
				db = new MatrixBean();
				db.setIdScalingMatrix(rs.getInt(1));
				db.setNameTeam(rs.getString(2));
				
				listMatrix.add(db);
			}

		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listMatrix;
		
	}
	
	
	
	/*
	 *
	 * */
	public List<MatrixBean> getMatrixByID(MatrixBean db){
		listMatrix = new ArrayList<MatrixBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			

			qry = "SELECT idAuth, idScalingMatrix, NameTeam, NameTeamPuesto, Support, SupportPuesto, "
				  + "EscalationLevel, EscalationLevelPuesto " +
				  "FROM matrix WHERE idAuth=? and idScalingMatrix=? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, db.getIdAuth());
			pstm.setInt(2,db.getIdScalingMatrix());
			pstm.setString(3,enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				db = new MatrixBean();
				db.setIdAuth(rs.getString(1));
				db.setIdScalingMatrix(rs.getInt(2));
				db.setNameTeam(rs.getString(3));
				db.setNameTeamPuesto(rs.getString(4));
				db.setSupport(rs.getString(5));
				db.setSupportPuesto(rs.getString(6));
				db.setEscalationLevel(rs.getString(7));
				db.setEscalationLevelPuesto(rs.getString(8));

				listMatrix.add(db);

			}
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}	
		
		return listMatrix;
	}
	
}
