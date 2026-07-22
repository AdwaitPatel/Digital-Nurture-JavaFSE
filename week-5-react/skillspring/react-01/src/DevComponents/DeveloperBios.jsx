function DeveloperBios({
  firstName,
  lastName,
  favoriteLanguage,
  yearStarted,
}) {
  return (
    <div className="card p-3 my-2">
      <h3>
        {firstName} {lastName}
      </h3>

      <p>
        <strong>Favorite Language:</strong> {favoriteLanguage}
      </p>

      <p>
        <strong>Started:</strong> {yearStarted}
      </p>
    </div>
  );
}

export default DeveloperBios;