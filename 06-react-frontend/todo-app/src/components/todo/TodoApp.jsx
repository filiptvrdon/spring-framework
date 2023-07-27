import React from "react";
import "./TodoApp.css";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Logout from "./Logout";
import Login from "./Login";
import Footer from "./Footer";
import Welcome from "./Welcome";
import Error from "./Error";
import TodoList from "./TodoList";
import Header from "./Header";
import AuthProvider, { useAuth } from "./security/AuthContext";
import Todo from "./Todo";

function AuthenticatedRoute({ children }) {
  const authContext = useAuth();
  if (authContext.isAuthenticated) {
    return children;
  } else {
    return <Navigate to="/" />;
  }
}

export default function TodoApp() {
  return (
    <div className="TodoApp">
      <AuthProvider>
        <BrowserRouter>
          <Header />
          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />

            <Route
              path="/welcome"
              element={
                <AuthenticatedRoute>
                  <Welcome />
                </AuthenticatedRoute>
              }
            />

            <Route
              path="/todos"
              element={
                <AuthenticatedRoute>
                  <TodoList />
                </AuthenticatedRoute>
              }
            />

            <Route
              path="/todo/:id"
              element={
                <AuthenticatedRoute>
                  <Todo />
                </AuthenticatedRoute>
              }
            />

            <Route
              path="/logout"
              element={
                <AuthenticatedRoute>
                  <Logout />
                </AuthenticatedRoute>
              }
            />
            <Route path="*" element={<Error />} />
          </Routes>
        </BrowserRouter>
      </AuthProvider>
      <Footer />
    </div>
  );
}
