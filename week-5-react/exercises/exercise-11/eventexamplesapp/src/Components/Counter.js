import React, { Component } from "react";

class Counter extends Component {
  constructor(props) {
    super(props);

    this.state = {
      count: 0,
    };
  }

  increment = () => {
    this.setState({
      count: this.state.count + 1,
    });
  };

  decrement = () => {
    this.setState({
      count: this.state.count - 1,
    });
  };

  sayHello = () => {
    alert("Hello! Member");
  };

  incrementAndHello = () => {
    this.increment();
    this.sayHello();
  };

  sayWelcome = (message) => {
    alert(message);
  };

  onPress = () => {
    alert("I was clicked");
  };

  render() {
    return (
      <div>

        <h2>{this.state.count}</h2>

        <button onClick={this.incrementAndHello}>
          Increment
        </button>

        <br />
        <br />

        <button onClick={this.decrement}>
          Decrement
        </button>

        <br />
        <br />

        <button onClick={() => this.sayWelcome("Welcome")}>
          Say Welcome
        </button>

        <br />
        <br />

        <button onClick={this.onPress}>
          Click on me
        </button>

      </div>
    );
  }
}

export default Counter;