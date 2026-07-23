import officeImage from "./Images/office.jpg";
import "./App.css";

function App() {

	const officeSpaces = [
		{
			Name: "DBS",
			Rent: 50000,
			Address: "Chennai"
		},
		{
			Name: "WeWork",
			Rent: 75000,
			Address: "Bangalore"
		},
		{
			Name: "SmartWorks",
			Rent: 45000,
			Address: "Hyderabad"
		}
	];

	return (
		<div className="container">
			<h1>Office Space, at Affordable Range</h1>

			<div className="office-container">
				{officeSpaces.map((item, index) => {
					const rentStyle = {
						color: item.Rent <= 60000 ? "red" : "green",
					};

					return (
						<div key={index} className="office-card">
							<img
								src={officeImage}
								alt="Office Space"
							/>

							<h2>Name: {item.Name}</h2>

							<h3 style={rentStyle}>
								Rent: Rs. {item.Rent}
							</h3>

							<h3>Address: {item.Address}</h3>
						</div>
					);
				})}
			</div>
		</div>
	);
}

export default App;