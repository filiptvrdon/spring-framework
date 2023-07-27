import React, { useState, useEffect } from "react";
import { getTodosByUsername, deleteTodoById } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export default function TodoList() {
  const [todos, setTodos] = useState([]);
  const [message, setMessage] = useState(null);
  const authContext = useAuth();
  const username = authContext.username;
  const navigate = useNavigate();

  useEffect(() => refreshTodos());

  function refreshTodos() {
    getTodosByUsername(username)
      .then((response) => setTodos(response.data))
      .catch((error) => console.log(error));
  }

  function deleteTodo(id) {
    console.log("delete id: " + id);
    deleteTodoById(username, id)
      .then(() => {
        setMessage(`Todo id ${id} deleted`);
        refreshTodos();
      })
      .catch((error) => console.log(error));
  }

  function updateTodo(id) {
    console.log("update todo id: " + id);
    navigate(`/todo/${id}`);
  }

  function addTodo(id) {
    console.log("add new todo");
    navigate(`/todo/-1`);
  }

  return (
    <div className="container">
      <h1>Your Todo List</h1>
      {message && <div className="alert alert-danger">{message}</div>}

      <div>
        <table className="table table-striped">
          <thead>
            <tr>
              <th>Description</th>
              <th>Done</th>
              <th>Target Date</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.description}</td>
                <td>{todo.done.toString()}</td>
                <td>{todo.targetDate}</td>
                <td>
                  <button
                    type="button"
                    className="btn btn-danger"
                    onClick={() => deleteTodo(todo.id)}
                  >
                    Delete
                  </button>
                </td>
                <td>
                  <button
                    type="button"
                    className="btn btn-warning"
                    onClick={() => updateTodo(todo.id)}
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div>
        <button type="button" className="btn btn-primary" onClick={addTodo}>
          Add New Todo
        </button>
      </div>
    </div>
  );
}
