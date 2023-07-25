import { useState } from "react";
import React from "react";
import "./Counter.css";
import { PropTypes } from "prop-types";
import CounterButton from "./CounterButton";
import ResetButton from "./ResetButton";

export default function Counter() {
  const [count, setCount] = useState(0);

  function incrementCounterOnParent(increment) {
    setCount(count + increment);
  }

  function decrementCounterOnParent(increment) {
    setCount(count - increment);
  }

  function resetCounterOnParent() {
    setCount(0);
  }

  return (
    <>
      <span className="count">{count}</span>
      <CounterButton
        increment={1}
        incrementCounterOnParent={incrementCounterOnParent}
        decrementCounterOnParent={decrementCounterOnParent}
      />
      <CounterButton
        increment={2}
        incrementCounterOnParent={incrementCounterOnParent}
        decrementCounterOnParent={decrementCounterOnParent}
      />
      <CounterButton
        increment={3}
        incrementCounterOnParent={incrementCounterOnParent}
        decrementCounterOnParent={decrementCounterOnParent}
      />
      <ResetButton resetCounterOnParent={resetCounterOnParent} />
    </>
  );
}
