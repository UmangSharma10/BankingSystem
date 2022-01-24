package Training;

public class Search {
    static void search(String startDate, String endDate) throws ParseException {
             Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
             Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(endDate);

             for(int i = 0; i< usergetpassword.Date.size(); i++)
             {
                 Date dateTemp=new SimpleDateFormat("dd/MM/yyyy").parse(usergetpassword.Date.get(i));
                 if(dateTemp.after(date1) && dateTemp.before(date2))
                 {
                     System.out.println(usergetpassword.details.get(i));
                 }
             }
         }
}
