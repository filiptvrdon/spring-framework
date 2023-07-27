import { apiClient } from "./ApiClient";

export const getTodosByUsername = (username) =>
  apiClient.get(`/users/${username}/todos`);

export const deleteTodoById = (username, id) =>
  apiClient.delete(`/users/${username}/todos/${id}`);

export const getTodoById = (username, id) =>
  apiClient.get(`/users/${username}/todos/${id}`);

export const updateTodoById = (username, id, todo) =>
  apiClient.put(`/users/${username}/todos/${id}`, todo);

export const addTodo = (username, todo) =>
  apiClient.post(`/users/${username}/todos`, todo);
