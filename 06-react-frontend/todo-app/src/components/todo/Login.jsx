import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function Login() {
  const [username, setUsername] = useState("in28minutes");
  const [password, setPassword] = useState(null);
  const [showErrorMessage, setShowErrorMessage] = useState(false);
  const navigate = useNavigate();
  const authContext = useAuth();

  function handleUsernameChange(event) {
    setUsername(event.target.value);
  }

  function handlePasswordChange(event) {
    setPassword(event.target.value);
  }

  async function handleLogin() {
    if (await authContext.login(username, password)) {
      console.log("HMMMMMMM");
      navigate("/welcome");
    } else {
      setShowErrorMessage(true);
    }
  }

  function ErrorMessage() {
    if (showErrorMessage) {
      return <div className="errorMessage">Authenticated Failed!</div>;
    } else {
      return null;
    }
  }

  return (
    <div className="Login">
      Login
      <ErrorMessage />
      <div className="LoginForm">
        <div>
          <label>Username</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={handleUsernameChange}
          />
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            name="password"
            onChange={handlePasswordChange}
          />
        </div>
      </div>
      <div>
        <button
          type="button"
          className="btn btn-primary"
          name="login"
          onClick={handleLogin}
        >
          Login
        </button>
      </div>
    </div>
  );
}
