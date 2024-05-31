public class PostCar {
    private String registrationNumber;

    public PostCar(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void deliver() {
        System.out.println("Delivering mail with post car: " + registrationNumber);
    }
}
