import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:8080",
});

export const getHelloWorldMessage = () => apiClient.get("/hello-world");

export const getHelloWorlWithPathVariable = (username) =>
  apiClient.get(`/hello-world/path-variable/${username}`);
