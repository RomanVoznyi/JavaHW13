package task1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HTTP_Utils {
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new GsonBuilder().create();

    public User createUser(User user) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/users"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(user)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), User.class);
    }

    public User updateUser(User user, int id) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/users/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(user)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), User.class);
    }

    public HttpResponse<String> deleteUser(int id) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/users/" + id))
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    public List<User> getUsers() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/users"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type listType = new TypeToken<List<User>>() {}.getType();
        List<User> usersList = gson.fromJson(response.body(), listType);

        return usersList;
    }

    public User getUserById(int id) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/users/" + id))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        User user = gson.fromJson(response.body(), User.class);

        return user;
    }

    public List<User> getUsersByUsername(String username) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/users?username=" + username))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type listType = new TypeToken<List<User>>() {}.getType();
        List<User> usersList = gson.fromJson(response.body(), listType);

        return usersList;
    }
}
