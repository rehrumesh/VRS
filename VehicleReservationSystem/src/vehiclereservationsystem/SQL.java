/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclereservationsystem;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Nimos
 */
public class SQL {
    //this is the class where you will type all your sql commands..sselect statements, insert statments oki.. yea.. 
    //for exampl, imagin u want to insert customer,

    public static void insertGuide(String userName, String password, String name, String address, String date) throws Exception {
        //if you are using selcet query, method should be executeQuery(), if u using any inset, update,delete it should be executeUpdate()   clear????
        //wahat was the name of that user table?no user tbl,, then wat was that  username password thing? fr officers. both ofcr n guid hs pwrds n user
        DbCon.createCon().createStatement().executeUpdate("insert into TravelGuide values('" + userName + "', '" + password + "', '" + name + "', '" + address + "',  '" + date + "')");
        //it was easey wasnt it?:)//
        //oki nw it is time for us to create a form to insert guids//it comes under transport oficer//hw to create special pages to officer n sm to guid? n hw to creat multiple pages n connect/?
        //whrs the SQL file u sent to me?? u complt da rest owkii.


        //what dd u mean nder officer??only officrs cn go to the page.once n afficer logs he hs an option to create a guide

        ///oki/lets deal with dat  leter. first will create a form to insert guids.later will connect that to officer
    }

    public static void insertVehicle(String regNo, String driver, String vehiType, String noOfSeats) throws Exception {

        DbCon.createCon().createStatement().executeUpdate("insert into vehicle values('" + regNo + "', '" + driver + "', '" + vehiType + "', '" + noOfSeats + "')");
    }

    public static void insertOfficer(String userName, String password, String name, String salary, String empDate) throws Exception {

        DbCon.createCon().createStatement().executeUpdate("insert into transportofficer values('" + userName + "', '" + password + "', '" + name + "', '" + salary + "', '" + empDate + "')");
    }

    public static boolean checkOfficer(String userName, String password) throws Exception {
        boolean isOfficer = false;
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select * from transportofficer where username ='" + userName + "'");

        if (r.next()) {
            String dbPassword = r.getString("password");
            if (dbPassword.equals(password)) {
                isOfficer = true;
            }
        }
        return isOfficer;
    }

    public static boolean checkGuide(String userName, String password) throws Exception {
        boolean isGuide = false;
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select * from travelguide where username ='" + userName + "'");

        if (r.next()) {
            String dbPassword = r.getString("password");
            if (dbPassword.equals(password)) {
                isGuide = true;
            }
        }
        return isGuide;
    }

    public static ResultSet getDetailsOfOfficer(String userName) throws Exception {
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select * from transportofficer where username ='" + userName + "'");
        return r;
    }

    static ResultSet getDetailsOfOfficerAll() throws Exception {
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select * from transportofficer");
        return r;
    }
    public static void updateOfficer(String userName, String password, String name, String salary, String empDate) throws Exception {
        DbCon.createCon().createStatement().executeUpdate("update transportofficer set username='" + userName + "', password='" + password + "', name= '" + name + "', salary= '" + salary + "', employement_date ='" + empDate + "' where username ='" + userName + "'");
    }
    public static void deleteOfficer(String userName)throws Exception{
        DbCon.createCon().createStatement().executeUpdate("delete from transportofficer where username ='"+userName+"'");
    }
    
    
    public static ResultSet getDetailsOfGuide(String userName) throws Exception {
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select * from travelguide where username ='" + userName + "'");
        return r;
    }
    static ResultSet getDetailsOfGuideAll() throws Exception {
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select * from travelguide");
        return r;
    }
    public static void updateGuide(String userName, String password, String name, String address, String endDate) throws Exception {
        DbCon.createCon().createStatement().executeUpdate("update travelguide set username='" + userName + "', password='" + password + "', name= '" + name + "', address= '" + address + "', contract_end_date ='" + endDate + "' where username ='" + userName + "'");
    }
    public static void deleteGuide(String userName)throws Exception {
        DbCon.createCon().createStatement().executeUpdate("delete from travelguide where username ='"+userName+"'");
    }
    
    
    public static ResultSet getDetailsOfVehicle(String regNo) throws Exception {
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select * from vehicle where reg_no ='" + regNo + "'");
        return r;
    }
    static ResultSet getDetailsOfVehicleAll() throws Exception {
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select * from vehicle");
        return r;
    }
    public static void updateVehicle(String regNo, String driver, String vehicleType, String noOfSeats) throws Exception {
        DbCon.createCon().createStatement().executeUpdate("update vehicle set reg_no='" + regNo + "', driver= '" + driver + "', vehicle_type= '" + vehicleType + "', no_of_seats ='" + noOfSeats + "' where reg_no ='" + regNo + "'");
    }
    public static void deleteVehicle(String regNo)throws Exception{
        DbCon.createCon().createStatement().executeUpdate("delete from vehicle where reg_no ='"+regNo+"'");
    }
    
    public static ResultSet getDetailsOfReservations() throws Exception {
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select * from reserve");
        return r;
    }
    public static ResultSet getSelectedReservation(String vehicle, String travelGuide, String fromDate, String toDate)throws Exception{
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select * from reserve where vehicle = '"+vehicle+"' and travel_guide ='"+travelGuide+"' and from_date ='"+fromDate+"'and to_date ='"+toDate+"'");
        return r;
    }

    public static void ApproveReservations(String vehicle, String travelGuide, String fromDate, String toDate,String approvedOfficer) throws Exception {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_time = sf.format(c.getTime());
        
        DbCon.createCon().createStatement().executeUpdate("update reserve set approved_officer = '"+approvedOfficer+"', approved_date_time = '"+date_time+"' where vehicle = '"+vehicle+"' and travel_guide ='"+travelGuide+"' and from_date ='"+fromDate+"'and to_date ='"+toDate+"'");
    }
    
    public static void RejectReservations(String vehicle, String travelGuide, String fromDate, String toDate,String approvedOfficer) throws Exception {
        DbCon.createCon().createStatement().executeUpdate("update reserve set approved_officer = '"+approvedOfficer+"' where vehicle = '"+vehicle+"' and travel_guide ='"+travelGuide+"' and from_date ='"+fromDate+"'and to_date ='"+toDate+"'");
    }
    
    public static ResultSet getNotReservedVehicle(String noOfPasengers, String from, String to)throws Exception{
        ResultSet r = DbCon.createCon().createStatement().executeQuery("select reg_no as 'reg', driver, vehicle_type as 'typ', no_of_seats as 'no' from vehicle where reg_no not in (select DISTINCT(vehicle) from reserve where (from_date between '"+from+"' and '"+to+"' ) or (to_date between '"+from+"' and '"+to+"')) and no_of_seats >='"+noOfPasengers+"'");
        return r;
    }
}
