package task1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Task1_Test {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("---------Task1 - Operations with Users-----------");
        HTTP_Utils utils = new HTTP_Utils();
        User newUser = getMyNewUser();

        part1_Creating(utils,newUser);
        part2_Updating(utils,newUser);
        part3_Deleting(utils);
        part4_GettingList(utils);
        part5_GettingUserByID(utils);
        part6_GettingUserByUsername(utils);

        System.gc();
    }

    private static void part1_Creating(HTTP_Utils utils, User newUser) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("---------Part1 - Creating new User-----------");
        User createdUser = utils.createUser(newUser);
        int expectedId = 11;
        System.out.println("My new user in DB -> " + createdUser);
        System.out.println("Does the user have an id as expected ? -> " + (expectedId == createdUser.getId()));
        System.out.println();
    }

    private static void part2_Updating(HTTP_Utils utils, User newUser) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("---------Part2 - Updating User's data-----------");
        newUser.setPhone("(007) 222-222-222");
        User updatedUser = utils.updateUser(newUser, 2);
        System.out.println("My updated user in DB -> " + updatedUser);
        System.out.println("Does the user equals to user from DB ? -> " + newUser.equals(updatedUser));
        System.out.println();
    }

    private static void part3_Deleting(HTTP_Utils utils) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("---------Part3 - Deleting User-----------");
        int statusCode = utils.deleteUser(3).statusCode();
        System.out.println("User with ID '3' was successfully deleted -> " + (statusCode > 199 && statusCode < 300));
        System.out.println();
    }

    private static void part4_GettingList(HTTP_Utils utils) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("---------Part4 - Getting List of Users-----------");
        List<User> usersList = utils.getUsers();
        for (User user : usersList) {
            System.out.println(user);
        }
        System.out.println();
    }

    private static void part5_GettingUserByID(HTTP_Utils utils) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("---------Part5 - Getting User by ID-----------");
        System.out.println("User with ID 5 is -> " + utils.getUserById(5));
        System.out.println();
    }

    private static void part6_GettingUserByUsername(HTTP_Utils utils) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("---------Part6 - Getting User[s] by Username-----------");
        System.out.println("User[s] with username 'Samantha' is[are]:");
        List<User> usersList = utils.getUsersByUsername("Samantha");
        for (User user : usersList) {
            System.out.println(user);
        }
        System.out.println();
    }

    public static User getMyNewUser() {
        User user = new User("James Bond", "bond007", "bond@mi6.com.uk", "(007) 111-222-333", "bond.mi6.com.uk",
                new User.Address("Albert Embankment", "85", "Vauxhall, Lambeth, London", "SW8",
                        new User.Geo("51.490306", "-0.119306")),
                new User.Company("Mi6", "No time to die", "Foreign intelligence service")
        );
        return user;
    }
}
