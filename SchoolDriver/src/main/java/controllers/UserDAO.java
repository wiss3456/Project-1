
package controllers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

	public class UserDAO {

		
		public int addUser (User us)
		{
			DBInteraction.connect();
			String sql="INSERT INTO drivers_supplier (FIRSTNAME,LASTNAME,AGE,ADRESS,NUMBER,MAILADRESS,LOGIN,PASSWORD) VALUES ('" + us.getFIRST_NAME() + "', '" + us.getLAST_NAME() + "', " + us.getAGE() + ", '" + us.getADRESS() +"','"+us.getNUMBER()+"','"+us.getMAIL_ADRESS()+"','"+us.getLOGIN()+"','"+us.getPASSWORD()+"')";
			int nb=DBInteraction.Maj(sql);
			DBInteraction.disconnect();
			return nb;
		}
		
		public int deleteUser (int ID)
		{
			DBInteraction.connect();
			String sql="delete from drivers_supplier where ID ="+ID;
			int nb=DBInteraction.Maj(sql);
			DBInteraction.disconnect();
			return nb;
		}
		public int deleteDemande (int ID)
		{
			DBInteraction.connect();
			String sql="delete from future_drivers where ID ="+ID;
			int nb=DBInteraction.Maj(sql);
			DBInteraction.disconnect();
			return nb;
		}
		
		public User findById(int ID)
		{
			User us=null;
			DBInteraction.connect();
			String sql="select * from drivers_supplier where ID ="+ID;
			ResultSet  rs = DBInteraction.select(sql);
			try {
				if (rs.next())
				{
					us=new User(rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				}
				
			}
			 catch (SQLException e1) {
				 e1.printStackTrace();
			 }
			
			DBInteraction.disconnect();
			return us ;
		}
		
		public List<User> allusers()
		{
			DBInteraction.connect();
			List<User> es = new ArrayList<User>();
			String sql="select * from drivers_supplier";
			ResultSet rs = DBInteraction.select(sql);
			try {
				while (rs.next())
				{
					User us=new User(rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
					us.setId(rs.getInt(1));
				    es.add(us);
				}
			} catch (SQLException e1 ) {
				e1.printStackTrace();
			}
			
			DBInteraction.disconnect();
			return es;
			
		}
		
		
		public User findByLOGIN(String LOGIN)
		{
			User us=null;
			DBInteraction.connect();
			String sql="select * from drivers_supplier where LOGIN ='"+LOGIN+"';";
			ResultSet  rs = DBInteraction.select(sql);
			try {
				if (rs.next())
				{
					us=new User(rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				}
				
			}
			 catch (SQLException e1) {
				 e1.printStackTrace();
			 }
			
			DBInteraction.disconnect();
			return us ;
		}
		
		public User findByMAIL_ADRESS(String MAIL_ADRESS)
		{
			User us=null;
			DBInteraction.connect();
			String sql="select * from drivers_supplier where MAILADRESS ='"+MAIL_ADRESS+"';";
			ResultSet  rs = DBInteraction.select(sql);
			try {
				if (rs.next())
				{
					us=new User(rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				}
				
			}
			 catch (SQLException e1) {
				 e1.printStackTrace();
			 }
			
			DBInteraction.disconnect();
			return us ;
		}
		
		public int updateUser( User use)
		{
			DBInteraction.connect();
			String sql="update drivers_supplier set AGE="+use.getAGE()+", ADRESS='"+use.getADRESS()+"',NUMBER='"+use.getNUMBER()+"' ,MAILADRESS='"+use.getMAIL_ADRESS()+"', PASSWORD='"+use.getPASSWORD()+"' where ID="+use.getID();
			int nb=DBInteraction.Maj(sql);
			DBInteraction.disconnect();
			return nb;
		}
		
   		public User authentifier(String LOGIN , String PASSWORD)
     	{
    		User u=null;
  			DBInteraction.connect();
  			ResultSet rs=DBInteraction.select("select * from drivers_supplier where PASSWORD='"+PASSWORD+"' and LOGIN ='"+LOGIN+"'");
 			try {
    			if(rs.next())
  				{
  				u=new User();
  					
  					u.setFIRST_NAME(rs.getString(2));
  				    u.setLAST_NAME(rs.getString(3));
  				    u.setAGE(rs.getInt(4));
  					u.setADRESS(rs.getString(5));
  					u.setNUMBER(rs.getString(6));
  					u.setMAIL_ADRESS(rs.getString(7));
  					u.setLOGIN(rs.getString(8));
  					u.setPASSWORD(rs.getString(9));
  					
  			}
  			} catch (SQLException e )
  			{
  				e.printStackTrace();
     		}
  			DBInteraction.disconnect();
  			
     		return u;
	          }
	
		public int inscrire(User us)
     	{
     	DBInteraction.connect();
	
        String query = "insert into drivers_supplier (FIRSTNAME,LASTNAME,AGE,ADRESS,NUMBER,MAILADRESS,LOGIN,PASSWORD) values ('" + us.getFIRST_NAME() + "', '" + us.getLAST_NAME() + "', " + us.getAGE() + ", '" + us.getADRESS() +"','"+us.getNUMBER()+"','"+us.getMAIL_ADRESS()+"','"+us.getLOGIN()+"','"+us.getPASSWORD()+"')";
		int nb=DBInteraction.Maj(query);
		return nb;
		}
		public int inscrireDemande(User us)
     	{
     	DBInteraction.connect();
	
        String query = "insert into future_drivers (FIRSTNAME,LASTNAME,AGE,ADRESS,NUMBER,MAILADRESS,LOGIN,PASSWORD) values ('" + us.getFIRST_NAME() + "', '" + us.getLAST_NAME() + "', " + us.getAGE() + ", '" + us.getADRESS() +"','"+us.getNUMBER()+"','"+us.getMAIL_ADRESS()+"','"+us.getLOGIN()+"','"+us.getPASSWORD()+"')";
		int nb=DBInteraction.Maj(query);
		return nb;
		}
		public List<User> allDemandes()
		{
			DBInteraction.connect();
			List<User> es = new ArrayList<User>();
			String sql="select * from future_drivers";
			ResultSet rs = DBInteraction.select(sql);
			try {
				while (rs.next())
				{
					User us=new User(rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
					us.setId(rs.getInt(1));
				    es.add(us);
				}
			} catch (SQLException e1 ) {
				e1.printStackTrace();
			}
			
			DBInteraction.disconnect();
			return es;
			
		}
		public User findByIdD(int ID)
		{
			User us=null;
			DBInteraction.connect();
			String sql="select * from future_drivers where ID ="+ID;
			ResultSet  rs = DBInteraction.select(sql);
			try {
				if (rs.next())
				{
					us=new User(rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				}
				
			}
			 catch (SQLException e1) {
				 e1.printStackTrace();
			 }
			
			DBInteraction.disconnect();
			return us ;
		}
		
		
	}
