package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Task2_Test {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("---------Task2 - Operations with Posts-----------");
        HTTP_Utils utils = new HTTP_Utils();
        List<Post> posts = utils.getUsersPosts(2);
        Integer maxPostId = posts.stream().map(post -> post.getId()).max(Integer::compareTo).get();
        System.out.println("The biggest post's ID for user with ID #2 is " + maxPostId);

        List<Comment> comments = utils.getCommentsToPost(maxPostId);
        System.out.println("List of comments to post with id #" + maxPostId + " has been found. It length is " + comments.size() + " records");

        File fileTarget = new File(".\\src\\main\\resources\\task2\\user-2-post-" + maxPostId + "-comments.json");
        writeCommentsToFile(comments, fileTarget);

        System.gc();
    }

    public static void writeCommentsToFile(List<Comment> comments, File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonData = gson.toJson(comments);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonData);
            writer.flush();
            System.out.println("File '" + file.getName() + "' has been written");
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
