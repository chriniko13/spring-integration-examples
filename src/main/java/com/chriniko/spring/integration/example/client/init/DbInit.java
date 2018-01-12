package com.chriniko.spring.integration.example.client.init;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DbInit {

    private final DataSource dataSource;

    public DbInit(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void initializeScript() {

        try (Connection connection = dataSource.getConnection()) {

            URL resource = this.getClass()
                    .getClassLoader()
                    .getResource("db/scripts/init.sql");

            resource = Optional
                    .ofNullable(resource)
                    .orElseThrow(IllegalStateException::new);

            List<String> allLines = Files.readAllLines(Paths.get(resource.toURI()));

            String sqlToExecute = allLines
                    .stream()
                    .reduce(String::concat)
                    .orElseThrow(IllegalStateException::new);


            ScriptUtils.executeSqlScript(connection, new ByteArrayResource(sqlToExecute.getBytes()));

        } catch (SQLException | URISyntaxException | IOException e) {
            throw new IllegalStateException("DbInit#initializeScript --- error occurred!");
        }

    }
}
