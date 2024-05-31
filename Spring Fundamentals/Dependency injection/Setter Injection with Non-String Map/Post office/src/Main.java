import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        PostCar sofiaCar = new PostCar("SV 9999 AK");
        PostCar varnaCar = new PostCar("VT 8988 SO");
        PostCar plovdivCar = new PostCar("EV 7887 GG");
        PostCar burgasCar = new PostCar("GO 5555 YO");


        Map<String, PostCar> postCars = new HashMap<>();
        postCars.put("Sofia", sofiaCar);
        postCars.put("Varna", varnaCar);
        postCars.put("Plovdiv", plovdivCar);
        postCars.put("Burgas", burgasCar);

     
        PostOffice postOffice = new PostOffice();
        postOffice.setPostCars(postCars);


        postOffice.deliverMail("Sofia");    
        postOffice.deliverMail("Varna");    
        postOffice.deliverMail("Plovdiv");  
        postOffice.deliverMail("Burgas");   
        postOffice.deliverMail("Ruse");     
    }
}
