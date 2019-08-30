package com.arishenk;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.http.HttpClient;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.Group;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class VertXClient extends Application {

    public static String  str = "";

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40)); // количество обработчиков
        HttpClientOptions options = new HttpClientOptions().
                setProtocolVersion(HttpVersion.HTTP_2).
                setSsl(true).
                setUseAlpn(true).
                setTrustAll(true);

        HttpClient client = vertx.createHttpClient(options);
        client.requestAbs(HttpMethod.GET, /*"https://api.vk.com/method/users.get?" +
                        "user_ids=460171064&fields=bdate&access_token=aa95b21f7bc0e06a2e9e72ab8660566e23f156c38cee47f797d963d544672bee71971479958799c8a20aa&v=5.101",*/
        "http://localhost:8081/get_users",
        result -> {
                    System.out.println(result.statusCode());//user_ids=460171064&fields=bdate&access_token=aa95b21f7bc0e06a2e9e72ab8660566e23f156c38cee47f797d963d544672bee71971479958799c8a20aa&v=5.101
                    result.bodyHandler(body -> {
                        str = body.toString();
                        System.out.println(body.toString());
                        launch(args);
                    });
                }).end();

    }

    @Override
    public void start(Stage stage) throws IOException {

        TableView<User> table = new TableView<User>();
        TableColumn<User, Integer> userId = new TableColumn<>("id");
        TableColumn<User, String> userNameCol = new TableColumn<User, String>("Name");
        TableColumn<User, String> phoneCol = new TableColumn<User, String>("Phone");
        //TableColumn<User, String> langCol = new TableColumn<User, String>("Lang");

        userId.setCellValueFactory(new PropertyValueFactory<>("id"));
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        //langCol.setCellValueFactory(new PropertyValueFactory<>("Lang"));

        //ObservableList<User> list = getUserList();

        table.getColumns().addAll(userId, userNameCol, phoneCol);

        /*StackPane root = new StackPane();
        //root.setPadding(new Inserts(5));
        root.getChildren().add(table);

        stage.setTitle("TableView (o7planning.org)");

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();*/


        Text text = new Text(str);
        ObjectMapper obj = new ObjectMapper();
        User[] users = obj.readValue(str, User[].class);
        List<User> userList = new LinkedList<>();

        for (User user: users) {
            userList.add(user);
        }

        ObservableList<User> list = FXCollections.observableArrayList(user1, user2, user3);
        table.setItems(userList);

        // установка надписи
        //table.setLayoutY(80); table.setLayoutX(100);
        Group group = new Group(table);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("First Application");
        stage.setWidth(450); stage.setHeight(450);
        stage.show();
    }

    private ObservableList<User> getUserList() {

        User user1 = new User(1, "arina", "888", new String[] {"Java"});
        User user2 = new User(2, "masha", "999", new String[] {"Java"});
        User user3 = new User(3, "boris", "777", new String[] {"Java"});

        ObservableList<User> list = FXCollections.observableArrayList(user1, user2, user3);
        return list;
    }
}