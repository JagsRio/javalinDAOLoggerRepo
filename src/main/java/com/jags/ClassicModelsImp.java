package com.jags;
import java.sql.*;
import java.util.*;


public class ClassicModelsImp implements ClassicDAOIntClass{
    @Override
    public OfficeModel CreateOffice(OfficeModel newOffice){
        try
        {
            Connection conn = MySqlConnectionFactory.getConnectionFactory().getMySqlConnection();
            String insertQuery = "INSERT INTO offices(officeCode,city,phone,addressLine1,addressLine2,state,country,postalCode,territory) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertQuery);
            ps.setString(1, newOffice.getOfficeCode());
            ps.setString(2, newOffice.getCity());
            ps.setString(3, newOffice.getPhone());
            ps.setString(4, newOffice.getAddressLine1());
            ps.setString(5, newOffice.getAddressLine2());
            ps.setString(6, newOffice.getState());
            ps.setString(7, newOffice.getCountry());
            ps.setString(8, newOffice.getPostalCode());
            ps.setString(9, newOffice.getTerritory());

            int checkInsert = ps.executeUpdate();

            if (checkInsert==0){
                throw new SQLException(); 
            }
            return newOffice;
        }
        catch(SQLException e){
           e.printStackTrace(); 
        }
        
        return null;
    }

    @Override
    public boolean DeleteOffice(String officeCode){
        try {
            Connection conn = MySqlConnectionFactory.getConnectionFactory().getMySqlConnection();
            String delQuery = "Delete from offices where officeCode=?";
            PreparedStatement ps = conn.prepareStatement(delQuery);
            ps.setString(1, officeCode);
            int delSuccess = 0;
            delSuccess = ps.executeUpdate();
            if (delSuccess==0){
                return false;
            }
            System.out.println("Office successfully deleted");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<OfficeModel> GetAllOffices(){
        List<OfficeModel> offices = new LinkedList<>();

        try{
            Connection conn = MySqlConnectionFactory.getConnectionFactory().getMySqlConnection();
            String getQuery = "Select * from offices";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(getQuery);
            while (rs.next()) {
                //(String ofcode, String city, String phone, String add1, String add2, String state, String country, String pcode, String territory)
                String ofcode = rs.getString("officecode");
                String city = rs.getString("city");
                String phone = rs.getString("phone");
                String add1 = rs.getString("addressLine1");
                String add2 = rs.getString("addressLine2");
                String state = rs.getString("state");
                String country = rs.getString("country");
                String pcode = rs.getString("postalcode");
                String territory = rs.getString("territory");
                OfficeModel om = new OfficeModel(ofcode, city, phone, add1, add2, state, country, pcode, territory);
                offices.add(om);
            }
            return offices;
        } catch(SQLException e){
            e.printStackTrace();
        }

        return offices;
    }

    @Override
    public OfficeModel GetOfficeById(String offcode){
        OfficeModel om = null;
        try {
            Connection conn = MySqlConnectionFactory.getConnectionFactory().getMySqlConnection();
            String getOfficeQuery = "Select * from Offices where officecode=?";
            PreparedStatement ps = conn.prepareStatement(getOfficeQuery);
            ps.setString(1, offcode);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
            String ofcode = rs.getString("officecode");
            String city = rs.getString("city");
            String phone = rs.getString("phone");
            String add1 = rs.getString("addressLine1");
            String add2 = rs.getString("addressLine2");
            String state = rs.getString("state");
            String country = rs.getString("country");
            String pcode = rs.getString("postalcode");
            String territory = rs.getString("territory");
            om = new OfficeModel(ofcode, city, phone, add1, add2, state, country, pcode, territory);
            return om;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return om;
    }
}

