package task1;

import java.util.Objects;

public class User {
    private int id;
    private String name, username, email, phone, website;
    private Address address;
    private Company company;

    public User() {
    }

    public User(String name, String username, String email, String phone, String website, Address address, Company company) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.address = address;
        this.company = company;
    }

    static class Address {
        private String street, suite, city, zipcode;
        private Geo geo;

        public Address(String street, String suite, String city, String zipcode, Geo geo) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.geo = geo;
        }

        @Override
        public String toString() {
            return "{" + street + ", " + suite + ", " + city + ", " + zipcode + ", " + geo + '}';
        }
    }

    static class Geo {
        private String lat, lng;

        public Geo(String lat, String lng) {
            this.lat = lat;
            this.lng = lng;
        }

        @Override
        public String toString() {
            return "{" + lat + ", " + lng + '}';
        }
    }

    static class Company {
        private String name, catchPhrase, bs;

        public Company(String name, String catchPhrase, String bs) {
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }

        @Override
        public String toString() {
            return "{" + name + ", " + catchPhrase + ", " + bs + '}';
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return username.equals(user.username) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }

    @Override
    public String toString() {
        return "User{" + getId() + " - " + getName() + ", " + getUsername() + ", " + getEmail() + ", " + getPhone() +
                ", " + getWebsite() + ", " + getAddress() + ", " + getCompany() + '}';
    }
}
