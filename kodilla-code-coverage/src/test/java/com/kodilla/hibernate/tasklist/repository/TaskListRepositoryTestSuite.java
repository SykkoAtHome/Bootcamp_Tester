package com.kodilla.hibernate.tasklist.repository;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListRepositoryTestSuite {

    @Autowired
    private TaskListRepository taskListRepository;

    @AfterEach
    public void cleanup() {
        taskListRepository.deleteAll();
    }

    @Test
    public void testFindByListName() {
        // Given
        String listName = "Test List";
        TaskList taskList = new TaskList(listName, "Test description");
        taskListRepository.save(taskList);

        // When
        List<TaskList> foundLists = taskListRepository.findByListName(listName);

        // Then
        assertEquals(1, foundLists.size());
        TaskList foundList = foundLists.get(0);
        assertEquals(listName, foundList.getListName());
    }
}
