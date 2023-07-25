import React from "react";
import { PropTypes } from "prop-types";

export default function ResetButton({ resetCounterOnParent }) {
  return (
    <div>
      <button className="resetButton" onClick={resetCounterOnParent}>
        Reset
      </button>
    </div>
  );
}
