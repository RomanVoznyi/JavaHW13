package task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import task2.Comment;
import task2.Post;

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

    public List<ToDo> getUsersTasks(int userId) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/users/"+userId+"/todos"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type listType = new TypeToken<List<ToDo>>() {}.getType();
        List<ToDo> tasks = gson.fromJson(response.body(), listType);

        return tasks;
    }
}
