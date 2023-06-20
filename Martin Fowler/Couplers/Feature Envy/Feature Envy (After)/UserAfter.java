public class User {
    private ContactInfo _contactInfo;
 
    User(ContactInfo contactInfo) {
        _contactInfo = contactInfo;
    }

        public String GetFullAddress()
        {
            String city = _contactInfo.getCity();
            String state = _contactInfo.getState();
            String streetName = _contactInfo.getStreetName();
            return streetName + ";" + city + ";" + state;
        }
}

