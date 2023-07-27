import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getTodoById } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { Formik, Form, Field, ErrorMessage } from "formik";
import { updateTodoById } from "./api/TodoApiService";
import { addTodo } from "./api/TodoApiService";

export default function Todo() {
  const navigate = useNavigate();
  const { id } = useParams();
  const authContext = useAuth();
  const [description, setDescription] = useState("");
  const [targetDate, setTargetDate] = useState("");

  useEffect(() => getTodoData(), [id]);

  const username = authContext.username;

  function getTodoData() {
    if (id != -1) {
      getTodoById(username, id)
        .then((response) => {
          setDescription(response.data.description);
          setTargetDate(response.data.targetDate);
          console.log(response);
        })
        .catch((error) => console.log(error));
    }
  }

  function validateInput(values) {
    console.log("VALIDATE");
    console.log(values);
    let errors = {};

    if (values.description.length < 5) {
      errors.description = "Enter a valid description";
    }

    if (values.targetDate == null) {
      errors.targetDate = "Enter a valid target date";
    }

    return errors;
  }

  function handleSubmit(values) {
    console.log("SUBMIT");
    console.log(values);

    const todo = {
      id: id,
      username: username,
      description: values.description,
      targetDate: values.targetDate,
    };

    console.log("TODO DATA");
    console.log(todo);

    if (todo.id == -1) {
      console.log("ADDING NEW TODO");
      addTodo(username, todo)
        .then((response) => {
          navigate("/todos");
        })
        .catch((error) => console.log(error));
    } else {
      console.log("UPDATING TODO");
      updateTodoById(username, id, todo)
        .then((response) => {
          navigate("/todos");
        })
        .catch((error) => console.log(error));
    }
  }

  return (
    <div className="container">
      <h1>Enter Todo Details</h1>
      <div>
        <Formik
          initialValues={{
            description,
            targetDate,
          }}
          enableReinitialize={true}
          onSubmit={handleSubmit}
          validate={validateInput}
          validateOnBlur={false}
          validateOnChange={false}
        >
          {(props) => (
            <Form>
              <ErrorMessage
                name="description"
                component="div"
                className="alert alert-warning"
              />
              <fieldset className="form-group">
                <label>Description</label>
                <Field
                  type="text"
                  className="form-control"
                  name="description"
                ></Field>
                <ErrorMessage
                  name="targetDate"
                  component="div"
                  className="alert alert-danger"
                />
              </fieldset>
              <fieldset className="form-group">
                <label>targetDate</label>
                <Field
                  type="date"
                  className="form-control"
                  name="targetDate"
                ></Field>
              </fieldset>
              <div>
                <button type="submit" className="btn btn-primary m-3">
                  Save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}
