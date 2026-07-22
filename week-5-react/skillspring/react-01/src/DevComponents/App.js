import { useState } from "react";

import Developer from "./Developer";
import DeveloperForm from "./DeveloperForm";
import DisplayBios from "./DisplayBios";

function App() {
  const [developers, setDevelopers] = useState([
    new Developer(1, "Adwait", "Patel", "Java", 2025),
    new Developer(2, "Kunal", "Kushwah", "JavaScript", 2019),
  ]);

  const addDeveloper = (developerData) => {
    const newDeveloper = new Developer(
      developers.length + 1,
      developerData.firstName,
      developerData.lastName,
      developerData.favoriteLanguage,
      developerData.yearStarted
    );

    setDevelopers([...developers, newDeveloper]);
  };

  return (
    <div className="container mt-4">
      <DeveloperForm addDeveloper={addDeveloper} />

      <hr />

      <DisplayBios developers={developers} />
    </div>
  );
}

export default App;