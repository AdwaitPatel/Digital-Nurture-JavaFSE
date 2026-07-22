import { useState } from "react";

function DeveloperForm({ addDeveloper }) {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [favoriteLanguage, setFavoriteLanguage] = useState("");
  const [yearStarted, setYearStarted] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    addDeveloper({
      firstName,
      lastName,
      favoriteLanguage,
      yearStarted,
    });

    setFirstName("");
    setLastName("");
    setFavoriteLanguage("");
    setYearStarted("");
  };

  return (
    <>
      <h1>Add Developer</h1>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="First Name"
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)}
        />

        <br /><br />

        <input
          type="text"
          placeholder="Last Name"
          value={lastName}
          onChange={(e) => setLastName(e.target.value)}
        />

        <br /><br />

        <input
          type="text"
          placeholder="Favorite Language"
          value={favoriteLanguage}
          onChange={(e) => setFavoriteLanguage(e.target.value)}
        />

        <br /><br />

        <input
          type="number"
          placeholder="Year Started"
          value={yearStarted}
          onChange={(e) => setYearStarted(e.target.value)}
        />

        <br /><br />

        <button type="submit">
          Submit
        </button>
      </form>
    </>
  );
}

export default DeveloperForm;
