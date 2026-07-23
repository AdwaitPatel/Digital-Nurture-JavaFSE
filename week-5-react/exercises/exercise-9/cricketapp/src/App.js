import "./App.css";

import {
  ListofPlayers,
  Scorebelow70,
} from "./Components/ListofPlayers";

import {
  OddPlayers,
  EvenPlayers,
  IndianPlayers,
  ListofIndianPlayers,
  IndianTeam,
} from "./Components/IndianPlayers";

function App() {

  const flag = false;

  if (flag === true) {
    return (
      <div>

        <h1>List of Players</h1>

        <ListofPlayers />

        <hr />

        <h1>List of Players having Scores Less than 70</h1>

        <Scorebelow70 />

      </div>
    );
  } else {
    return (
      <div>

        <h1>Indian Team</h1>

        <h2>Odd Players</h2>

        {OddPlayers(IndianTeam)}

        <hr />

        <h2>Even Players</h2>

        {EvenPlayers(IndianTeam)}

        <hr />

        <h2>List of Indian Players Merged</h2>

        <ListofIndianPlayers IndianPlayers={IndianPlayers} />

      </div>
    );
  }
}

export default App;