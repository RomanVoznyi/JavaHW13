package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import task1.User;

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

    public List<Post> getUsersPosts(int id) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/users/" + id + "/posts"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type listType = new TypeToken<List<Post>>() {}.getType();
        List<Post> posts = gson.fromJson(response.body(), listType);

        return posts;
    }

    public List<Comment> getCommentsToPost(int postId) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/posts/" + postId + "/comments"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type listType = new TypeToken<List<Comment>>() {}.getType();
        List<Comment> comments = gson.fromJson(response.body(), listType);

        return comments;
    }
}
