package com.nail.decoplanner;
import io.github.cdimascio.dotenv.Dotenv;
import com.nail.decoplanner.domain.user.UserService;
public class DB_config {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");

        System.out.println("Database is running on host: " + host + ", port: " + port);
    }

}
