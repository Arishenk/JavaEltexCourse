package com.arishenk;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JavaFx extends Application {
    public static String  str = "";
    public static User[] users;

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40)); // количество обработчиков
        HttpClientOptions options = new HttpClientOptions().
                setProtocolVersion(HttpVersion.HTTP_2).
                setSsl(true).
                setUseAlpn(true).
                setTrustAll(true);

        HttpClient client = vertx.createHttpClient(options);
        client.requestAbs(HttpMethod.GET, "http://localhost:8081/get_users",
                result -> {
                    result.bodyHandler(body -> {
                        str = body.toString();
                        ObjectMapper obj = new ObjectMapper();
                        try {
                            users = obj.readValue(str, User[].class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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

        userId.setCellValueFactory(new PropertyValueFactory<>("id"));
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));

        table.getColumns().addAll(userId, userNameCol, phoneCol);

        ObservableList<User> list = FXCollections.observableArrayList(users);
        table.setItems(list);

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