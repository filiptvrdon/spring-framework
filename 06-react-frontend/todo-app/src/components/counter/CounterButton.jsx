import React from "react";
import { PropTypes } from "prop-types";

export default function CounterButton({
  increment,
  incrementCounterOnParent,
  decrementCounterOnParent,
}) {
  return (
    <div>
      <button
        className="counterButton"
        onClick={() => incrementCounterOnParent(increment)}
      >
        +{increment}
      </button>
      <button
        className="counterButton"
        onClick={() => decrementCounterOnParent(increment)}
      >
        -{increment}
      </button>
    </div>
  );
}

CounterButton.prototypes = {
  increment: PropTypes.number.isRequired,
};

CounterButton.defaultProps = {
  increment: 1,
};
