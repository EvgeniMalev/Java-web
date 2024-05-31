import java.util.Map;

public class PostOffice {
    private Map<String, PostCar> postCars;

    public void setPostCars(Map<String, PostCar> postCars) {
        this.postCars = postCars;
    }

    public void deliverMail(String townCode) {
        PostCar postCar = postCars.get(townCode);
        if (postCar != null) {
            postCar.deliver();
        } else {
            System.out.println("No post car found for town code: " + townCode);
        }
    }
}
