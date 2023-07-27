import React, { useState } from "react";
import { Link } from "react-router-dom";
import { getHelloWorlWithPathVariable } from "./api/HelloWorldApiService";

export default function Welcome() {
  function callHelloWorldRestApi() {
    getHelloWorlWithPathVariable("Ranga")
      .then((response) => successResponse(response))
      .catch((error) => errorResponse(error))
      .finally(() => console.log("cleanup"));
  }

  function successResponse(response) {
    console.log(response);
    setMessage(response.data.message);
  }

  function errorResponse(error) {
    console.log(error);
  }
  const [message, setMessage] = useState(null);

  return (
    <div className="Welcome">
      <h1>Welcome! </h1>
      <div>
        <Link to="/todos"> Click here</Link> to manage your Todos
      </div>
      <div>
        <button className="btn btn-success m-3" onClick={callHelloWorldRestApi}>
          Call Hello Worl REST API
        </button>
      </div>
      <div className="text-info">{message}</div>
    </div>
  );
}
