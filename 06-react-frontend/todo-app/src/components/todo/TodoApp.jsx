import React, { useState } from "react";
import "./TodoApp.css";
import {
  BrowserRouter,
  Routes,
  Route,
  useNavigate,
  Link,
} from "react-router-dom";

export default function TodoApp() {
  return (
    <div className="TodoApp">
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/login" element={<Login />} />
          <Route path="/welcome" element={<Welcome />} />
          <Route path="/todos" element={<TodoList />} />
          <Route path="/logout" element={<Logout />} />
          <Route path="*" element={<Error />} />
        </Routes>
      </BrowserRouter>
      <Footer />
    </div>
  );
}

function Login() {
  const [username, setUsername] = useState("in28minutes");
  const [password, setPassword] = useState("");
  const [showSuccessMessage, setShowSuccessMessage] = useState(false);
  const [showErrorMessage, setShowErrorMessage] = useState(false);
  const navigate = useNavigate();

  function handleUsernameChange(event) {
    setUsername(event.target.value);
  }

  function handlePasswordChange(event) {
    setPassword(event.target.value);
  }

  function handleLogin() {
    console.log(username);
    console.log(password);

    if (username === "in28minutes" && password === "aaa") {
      console.log("login success");
      setShowSuccessMessage(true);
      setShowErrorMessage(false);
      navigate("/welcome");
    } else {
      console.log("login failed");
      setShowSuccessMessage(false);
      setShowErrorMessage(true);
    }
  }

  function SuccessMessage() {
    if (showSuccessMessage) {
      return <div className="successMessage">Authenticated Successfully!</div>;
    } else {
      return null;
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
      <SuccessMessage />
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
        <button type="button" name="login" onClick={handleLogin}>
          Login
        </button>
      </div>
    </div>
  );
}

function Welcome() {
  return (
    <div className="Welcome">
      <h1>Welcome! </h1>
      <div>
        <Link to="/todos"> Click here</Link> to manage your Todos
      </div>
    </div>
  );
}

function Error() {
  return (
    <div className="Error">
      <h1>404</h1>
      <h2>Apologies for the inconvenience, we're working on it!</h2>
    </div>
  );
}

function TodoList() {
  const today = new Date();
  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay()
  );

  const todos = [
    { id: 1, description: "Learn AWS", done: false, targetDate: targetDate },
    { id: 2, description: "Learn Azure", done: false, targetDate: targetDate },
    {
      id: 3,
      description: "Learn Google Cloud",
      done: false,
      targetDate: targetDate,
    },
  ];

  return (
    <div className="container">
      <h1>Your Todo List</h1>
      <div>
        <table>
          <thead>
            <tr>
              <td>ID</td>
              <td>Description</td>
              <td>Done</td>
              <td>Target Date</td>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.id}</td>
                <td>{todo.description}</td>
                <td>{todo.done.toString()}</td>
                <td>{todo.targetDate.toDateString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

function Header() {
  return (
    <header className="border-bottom border-light border-5 mb-5 p-2">
      <div className="container">
        <div className="row">
          <nav className="navbar navbar-expand-lg">
            <a
              className="navbar-brand ms-2 fs-2 fw-bold text-black"
              href="https://www.in28minutes.com"
            >
              in28minutes
            </a>
            <div className="collapse navbar-collapse">
              <ul className="navbar-nav">
                <li className="nav-item fs-5">
                  <Link className="nav-link" to="/welcome">
                    Home
                  </Link>
                </li>
                <li className="nav-item fs-5">
                  <Link className="nav-link" to="/todos">
                    Todos
                  </Link>
                </li>
              </ul>
            </div>
            <ul className="navbar-nav">
              <li className="nav-item fs-5">
                <Link className="nav-link" to="/login">
                  Login
                </Link>
              </li>
              <li className="nav-item fs-5">
                <Link className="nav-link" to="/logout">
                  Logout
                </Link>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </header>
  );
}

function Footer() {
  return (
    <div className="Footer">
      <hr />
      <h4>My Custom Footer</h4>
    </div>
  );
}

function Logout() {
  return (
    <div className="Logout">
      <h1>You've been logged out</h1>
      <h2>Come back soon!</h2>
    </div>
  );
}
