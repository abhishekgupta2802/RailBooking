package main.data;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public class RailDao {
	
    private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		System.out.println("setDataSource");
		jdbcTemplateObject = new JdbcTemplate(ds);
	}
	
	public List<TrainByStation> listTrains(String start,String end) {
		System.out.println("ds");
	      return jdbcTemplateObject.query("select * from trainByStation where statinName = '"+start+"' OR statinName ='"+end+"'" ,new RowMapper<TrainByStation>(){  
			@Override
			public TrainByStation mapRow(java.sql.ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("Start "+start+" end  "+end);
				TrainByStation e=new TrainByStation();  
	              e.setName(rs.getString(1));  
	              e.setNum(rs.getInt(2));  
	               
	              return e; 
				
			}

			  
	      });
	   }

	public List<TrainByStation> trainStations(List<TrainByStation> at) {
		// TODO Auto-generated method stub
		String sql="select * from trainstop where";
		
		for (TrainByStation trainByStation : at) {
		sql=sql+" trainNum = "+ trainByStation.getNum() +" OR";
			
		}
		System.out.println(sql);
		sql=(String) sql.subSequence(0, sql.length()-3);
		System.out.println(sql);
		List<TrainByStation> at1=jdbcTemplateObject.query(sql, new RowMapper<TrainByStation>(){  
			@Override
			public TrainByStation mapRow(java.sql.ResultSet rs, int arg1) throws SQLException {
   				TrainByStation e=new TrainByStation();  
	              e.setName(rs.getString(2));  
	              e.setNum(rs.getInt(1));  
	               
	              return e; 
				
			}

			  
	      });
		
		
		return at1;
	}

	public List<trainDetails> trainData(List<Integer> traiNum,String start,String end,int Flag) {
		String sql;
		if(Flag==0){
       sql="select * from trainTimeDetails where (stationName = '"+ start +"' OR stationName = '"+ end +"') AND (";
		
		for (Integer integer : traiNum) {
			
			sql=sql+" trainNum = "+ integer +" OR";
		}
		
		System.out.println(sql);
		sql=(String) sql.subSequence(0, sql.length()-3);
		sql=sql+")";
		}
		
		else{
			 sql="select * from trainTimeDetails where trainNum = '"+ Flag +"'";
		}
		
		
		System.out.println(sql);
		List<trainDetails> at1=jdbcTemplateObject.query(sql, new RowMapper<trainDetails>(){  
			@Override
			public trainDetails mapRow(java.sql.ResultSet rs, int arg1) throws SQLException {
   				trainDetails e=new trainDetails();  
   				e.setTrainNum(rs.getInt(1));  
   				e.setStationName(rs.getString(2));  
	             e.setJourneyDay(rs.getInt(3)); 
	              e.setStartTime(rs.getTime(4));
	              e.setHaultMins(rs.getInt(5));
	              e.setSta("NotUsed");
	              return e; 
				
			}

			  
	      });
		
		
		return at1;
	}

	public String storePassengerDetails(PassangerDetails pdetails, int trainId, String userId) {
		String sql="insert into bookingdetails(id,pn1,a1,g1,pn2,a2,g2,pn3,a3,g3,trainNum)"+
	" VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		String sql2="insert into bookingDone(userId,uniqueId,seatBooked,Status)"+" Values(?,?,?,?)";
        String time=""+System.currentTimeMillis();
        int seat=1;
        if(pdetails.getPassangerName2()!="")
        	seat++;
        if(pdetails.getPassangerName3()!="")
        	seat++; 
        jdbcTemplateObject.update(sql2,userId,time,seat,"Confirm");
		System.out.println(jdbcTemplateObject.update(sql,time,pdetails.getPassangerName1(),pdetails.getAge1(),pdetails.getGender1(),
				pdetails.getPassangerName2(),pdetails.getAge2(),pdetails.getGender2(),
				pdetails.getPassangerName3(),pdetails.getAge3(),pdetails.getGender3(),trainId));
	return time;	
	}

	public String vaildator(String userId, String password) {
		System.out.println("DAO");
		String sql="select user from login where userId = '"+userId+"' and password = '"+password+"'";
		String type="no";
		SqlRowSet srs=jdbcTemplateObject.queryForRowSet(sql);
		while (srs.next()) {
			type=srs.getString("user");
			
		}
		
		return type;
	}

	public List<Booking> download(String userId) {
		String sql="select * from bookingDone where userId = '"+userId+"'";
		List<Booking> at1=jdbcTemplateObject.query(sql, new RowMapper<Booking>(){  
			@Override
			public Booking mapRow(java.sql.ResultSet rs, int arg1) throws SQLException {
   				Booking e=new Booking();  
   				e.setUniqueId(rs.getString(2));  
   				e.setSeatBooked(rs.getInt(3));  
	             e.setStatus(rs.getString(4)); 
	            return e; 
			}
		});
		return at1;
	}

	
}
