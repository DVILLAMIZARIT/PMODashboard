package com.nextel.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.nextel.dashboard.bean.FourUpBean;


@Repository
public class Admin4UPDAOImpl implements Admin4UPDAO {
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
    
    private List<FourUpBean> list4Ups = null;
    private List<FourUpBean> listTypes = null;
    
    private FourUpBean fub = null;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private String qry;
	private Connection con;
	private DataSource ds;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/*
	 * 
	 * */
	public int getLastId4up(){
		int lastId4up = 0;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT MAX(id4Ups) FROM fourups";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				lastId4up = rs.getInt(1);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		//Plus one and return
		lastId4up = lastId4up + 1;
		return lastId4up;
	}
	
	
	/*
	 * 
	 * */
	public boolean create4up(FourUpBean fub){
		boolean created = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			Calendar creationDate = Calendar.getInstance();
			String sCreationDate = sdf.format(new Date(creationDate.getTimeInMillis()));
			
			qry = "INSERT INTO fourups (id4Ups, idAuth, Description, Type, DateUps, Flag, creationDate) " +
				  "VALUES(?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(qry);
			pstm.setInt(1, fub.getId4ups());
			pstm.setString(2, fub.getIdAuth());
			pstm.setString(3, fub.getDescription());
			pstm.setString(4, fub.getType());
			pstm.setString(5, fub.getDateUps());
			pstm.setString(6, fub.getFlag());
			pstm.setString(7, sCreationDate);
			int res = pstm.executeUpdate();
			
			if(res == 1){
				created = true;
			}
			
			System.out.println("RESULT " + res);
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL 4UP CREATE" + sqle.getMessage());
		}
		
		return created;
	}
	
	
	/*
	 * 
	 * */
	public List<FourUpBean> getListTypes(){
		Map<String, String> mapTypes = new HashMap<String, String>();
		listTypes = new ArrayList<FourUpBean>();
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT Type FROM fourups";
			pstm = con.prepareStatement(qry);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				mapTypes.put(rs.getString(1), rs.getString(1));
			}
			
			for(Map.Entry<String,String> entry : mapTypes.entrySet()){
				
				fub = new FourUpBean();
				fub.setType(entry.getValue());
				
				listTypes.add(fub);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return listTypes;
	}
	
	
	
	
	
	/*
	 * 
	 * */
	public boolean delete4up(String id4ups){
		boolean deleted = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "UPDATE fourups SET enabled='Baja' WHERE id4Ups=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, id4ups);
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
	public boolean update4up(FourUpBean fub){
		boolean updated = false;
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "UPDATE fourups SET Description=?, Type=?, DateUps=?, Flag=? WHERE id4Ups=? ";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, fub.getDescription());
			pstm.setString(2, fub.getType());
			pstm.setString(3, fub.getDateUps());
			pstm.setString(4, fub.getFlag());
			pstm.setInt(5, fub.getId4ups());
			
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
	public List<FourUpBean> getListDescriptions(String idAuth){
		list4Ups = new ArrayList<FourUpBean>();
		String enabled = "Activo";
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT id4Ups, Description FROM fourups WHERE idAuth = ? and enabled=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, idAuth);
			pstm.setString(2, enabled);
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				fub = new FourUpBean();
				fub.setId4ups(rs.getInt(1));
				fub.setDescription(rs.getString(2));
				
				list4Ups.add(fub);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}
		
		return list4Ups;
		
	}
	
	
	
	/*
	 *
	 * */
	public List<FourUpBean> get4upsByDesc(FourUpBean fub){
		list4Ups = new ArrayList<FourUpBean>();
		
		try{
			if(con == null){
				ds = DataSourceFactory.getMySQLDataSource();
				con = ds.getConnection();
			}
			
			qry = "SELECT id4Ups, Description, Type, DateUps, Flag " +
				  "FROM fourups WHERE idAuth=? and id4Ups=?";
			pstm = con.prepareStatement(qry);
			pstm.setString(1, fub.getIdAuth());
			pstm.setInt(2,fub.getId4ups());
			rs = pstm.executeQuery();
			
			while(rs.next()){				
				
				fub = new FourUpBean();
				fub.setIdAuth(rs.getString(1));
				fub.setDescription(rs.getString(2));
				fub.setType(rs.getString(3));
				fub.setDateUps(rs.getString(4));
				fub.setFlag(rs.getString(5));
				
				list4Ups.add(fub);
			}
			
		} catch(SQLException sqle){
			log.error("ERROR DAOIMPL" + sqle.getMessage());
		}	
		
		return list4Ups;
	}
	
}
