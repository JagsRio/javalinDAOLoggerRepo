package com.jags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
    public static void main( String[] args )
    {
        try{
           /*
            Connection conn = SqlConnectionHelperClass.getConnection();
            Statement st = conn.createStatement();
            String query = "Select * from employees limit 5"; // CorderNumber
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            String colNames = "";
            for (int i = 1; i <= columnCount; i++) {
                colNames += metadata.getColumnName(i) + "\t";
            }
            colNames.concat("AXFG");
            colNames.replace("AXFG", "");
            System.out.println(colNames);

            while (rs.next()) {
                String rowDetails = "";
                for (int i = 1; i <= columnCount; i++) {
                    String colValue = rs.getString(i);
                    rowDetails += colValue + "\t";
                }
                rowDetails.concat("FGHF");
                rowDetails.replace("\tFGHF", "");
                System.out.println(rowDetails);
            }  
            Connection conn = MySqlConnectionFactory.getConnectionFactory().getMySqlConnection();
            Statement st = conn.createStatement();
            String qry = "Select officecode from offices;";
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
               int curCode = rs.getInt(1);
                if (curCode > maxCode){
                    maxCode=curCode;
                }
            }

            String offCode = Integer.toString(maxCode + 1);
            System.out.println(offCode);
            conn.close();
            
            
            //OfficeModel newOffice = new OfficeModel(offCode, "Fullerton", "814 122 1234", "122 Malvern", "", "CA", "USA", "92833", "NA");
            //ClassicModelsImp cm = new ClassicModelsImp();
            //cm.CreateOffice(newOffice);
            //cm.DeleteOffice("12");

            ClassicModelsImp cm = new ClassicModelsImp();
            List<OfficeModel> offices = new LinkedList<>();
            offices = cm.GetAllOffices();
            System.out.println(offices.size());
            for (int i=0; i<offices.size(); i++){
                OfficeModel om = (OfficeModel) offices.get(i);
                //System.out.println(om.getOfficeDetails());
                System.out.println(om.toString());
            }
            */

         /*    Javalin app = Javalin.create().start(9100);
            app.get("/offices", OfficeController.fetchAllOffices);
            
            app.get("/office/{id}", OfficeController.getOfficeById);

            app.exception(NullPointerException.class, (e, ctx) -> {
                ctx.json(e.getMessage());
           });*/

           Logger logger = LoggerFactory.getLogger(App.class);

           logger.trace("TRACE from logger");
           logger.debug("INFO Message from logger {}", App.class.getSimpleName());
           logger.info("INFO Message from logger {}", App.class.getSimpleName());
           logger.warn("WARN Message from logger {}", App.class.getSimpleName());
           logger.error("ERROR Message from logger {}", App.class.getSimpleName());
           try {
            throw new Exception();
           } catch (Exception e) {
                logger.warn("Exception Occured", e);
           }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Hello World!" );
    }
}
