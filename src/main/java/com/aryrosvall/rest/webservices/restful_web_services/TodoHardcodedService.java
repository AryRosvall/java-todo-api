package com.aryrosvall.rest.webservices.restful_web_services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

  private static List<Todo> todos = new ArrayList();
  private static int idCounter = 0;

  static {
    todos.add(new Todo(++idCounter, "aryrosvall", "Learn to Dance", new Date(), false));
    todos.add(new Todo(++idCounter, "aryrosvall", "Learn Angular", new Date(), false));
    todos.add(new Todo(++idCounter, "aryrosvall", "Learn Java", new Date(), false));
    todos.add(new Todo(++idCounter, "aryrosvall", "Learn Spring", new Date(), false));
  }

  public List<Todo> findAll() {
    return todos;
  }

  public Todo deleteById(long id) {
    Todo todo = findById(id);
    if (todo == null) {
      return null;
    }

    if (todos.remove(todo)) {
      return todo;
    }
    return null;
  }

  public Todo findById(long id) {
    for (Todo todo : todos) {
      if (todo.getId() == id) {
        return todo;
      }
    }
    return null;
  }

}