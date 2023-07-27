import { apiClient } from "./ApiClient";

export const getHelloWorldMessage = () => apiClient.get("/hello-world");

export const getHelloWorlWithPathVariable = (username) =>
  apiClient.get(`/hello-world/path-variable/${username}`);
