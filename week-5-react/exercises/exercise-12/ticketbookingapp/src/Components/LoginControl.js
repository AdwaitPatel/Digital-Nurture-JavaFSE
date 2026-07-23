import React, { Component } from "react";
import GuestGreeting from "./GuestGreeting";
import UserGreeting from "./UserGreeting";

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;

  if (isLoggedIn) {
    return <UserGreeting />;
  }

  return <GuestGreeting />;
}

class LoginControl extends Component {

  constructor(props) {
    super(props);

    this.state = {
      isLoggedIn: false,
    };
  }

  handleLoginClick = () => {
    this.setState({
      isLoggedIn: true,
    });
  };

  handleLogoutClick = () => {
    this.setState({
      isLoggedIn: false,
    });
  };

  render() {

    const isLoggedIn = this.state.isLoggedIn;

    let button;

    if (isLoggedIn) {
      button = (
        <LogoutButton
          onClick={this.handleLogoutClick}
        />
      );
    } else {
      button = (
        <LoginButton
          onClick={this.handleLoginClick}
        />
      );
    }

    return (
      <div>

        <Greeting isLoggedIn={isLoggedIn} />

        <br />

        {button}

      </div>
    );
  }
}

export default LoginControl;