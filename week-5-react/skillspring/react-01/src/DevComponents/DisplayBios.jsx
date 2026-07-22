import DeveloperBios from "./DeveloperBios";

function DisplayBios({ developers }) {
  return (
    <>
      <h1>Developer Bios</h1>

      {developers.map((developer) => (
        <DeveloperBios
          key={developer.id}
          {...developer}
        />
      ))}
    </>
  );
}

export default DisplayBios;

