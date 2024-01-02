package com.kodilla.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.List;

class DbManagerTestSuite {
    private static DbManager dbManager;

    @BeforeAll
    public static void setup() throws SQLException {
        dbManager = DbManager.getInstance();
    }

    @Test
    void testConnect() {
        //Given
        //When
        //Then
        Assertions.assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        String countQuery = "SELECT COUNT(*) AS userCount FROM USERS";
        Statement statement = createStatement();
        ResultSet rs = statement.executeQuery(countQuery);
        int count = getRowsCount(rs);
        insertUsers(statement);

        //When
        String sqlQuery = "SELECT * FROM USERS";
        statement = createStatement();
        rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = getResultsCount(rs);
        int expected = count + 5;
        Assertions.assertEquals(expected, counter);

        rs.close();
        statement.close();
    }

    private Statement createStatement() throws SQLException {
        return dbManager.getConnection().createStatement();
    }

    private static final List<AbstractMap.SimpleEntry<String, String>> USERS = List.of(
            new AbstractMap.SimpleEntry<>("Zara", "Ali"),
            new AbstractMap.SimpleEntry<>("Otman", "Use"),
            new AbstractMap.SimpleEntry<>("Mark", "Boq"),
            new AbstractMap.SimpleEntry<>("Uli", "Wimer"),
            new AbstractMap.SimpleEntry<>("Oli", "Kosiw")
    );

    private void insertUsers(Statement statement) throws SQLException {
        for (AbstractMap.SimpleEntry<String, String> user : USERS) {
            statement.executeUpdate(
                    String.format("INSERT INTO USERS(FIRSTNAME, LASTNAME) VALUES ('%s', '%s')",
                            user.getKey(),
                            user.getValue()
                    )
            );
        }
    }

    private static int getResultsCount(ResultSet rs) throws SQLException {
        int counter = 0;
        while (rs.next()) {
            System.out.printf("%d, %s, %s%n",
                    rs.getInt("ID"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"));
            counter++;
        }
        return counter;
    }

    private static int getRowsCount(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
            count = rs.getInt("userCount");
        }
        return count;
    }

    @Test
    void testUsersWithAtLeastTwoPosts() throws SQLException {
        // Given
        Statement statement = dbManager.getConnection().createStatement();

        // When
        String sqlQuery = "SELECT u.ID, u.FIRSTNAME, u.LASTNAME, COUNT(p.ID) AS postCount " +
                "FROM USERS u " +
                "LEFT JOIN POSTS p ON u.ID = p.USER_ID " +
                "GROUP BY u.ID, u.FIRSTNAME, u.LASTNAME " +
                "HAVING COUNT(p.ID) >= 2";
        ResultSet rs = statement.executeQuery(sqlQuery);

        // Then
        int usersWithAtLeastTwoPosts = displayUsersWithAtLeastTwoPosts(rs);
        Assertions.assertTrue(usersWithAtLeastTwoPosts > 0);

        rs.close();
        statement.close();
    }

    private static int displayUsersWithAtLeastTwoPosts(ResultSet rs) throws SQLException {
        int userCount = 0;
        while (rs.next()) {
            int userId = rs.getInt("ID");
            String firstName = rs.getString("FIRSTNAME");
            String lastName = rs.getString("LASTNAME");
            int postCount = rs.getInt("postCount");

            System.out.printf("User ID: %d, Name: %s %s, Post Count: %d%n", userId, firstName, lastName, postCount);

            userCount++;
        }
        return userCount;
    }
}
