package task3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class Test3_Test {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("---------Task3 - Operations with ToDo's-----------");
        HTTP_Utils utils = new HTTP_Utils();
        List<ToDo> tasks = utils.getUsersTasks(4);
        List<ToDo> openTasks = tasks.stream().filter(task -> !task.getCompleted()).collect(Collectors.toList());

        System.out.println("List of opened tasks for user with id 4:");
        for (ToDo task : openTasks) {
            System.out.println(task);
        }

        System.gc();
    }
}
