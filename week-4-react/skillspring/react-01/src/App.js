import React, { Component } from 'react';
import './App.css';
import DeveloperBios from './components/DeveloperBios';
import RouterDemo from './components/RouterDemo';
import DeveloperForm from "./components/DeveloperForm";

const devInfo = {
	firstName: "Adwait",
	lastName: "Patel",
	favoriteLanguage: "JS",
	yearStarted: 2025
}

class ClassComponent extends Component {
	constructor(props) {
		super(props);

		this.state = {
			header: "header from state",
			content: "content from state"
		}
	}
	render() {
		return (
			<div>
				<h1>{this.state.header}</h1>
				<h2>{this.state.content}</h2>
			</div>
		)
	}
}

export class Developer {
	constructor(id, firstName, lastName, favoriteLanguage, yearStarted) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.favoriteLanguage = favoriteLanguage;
		this.yearStarted = yearStarted;
	}
}

export function DisplayBios({ developers }) {
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

// function App() {
// 	return (
// 		<div class="d-flex flex-column justify-content-center align-items-center" style={{ height: "100vh" }}>
// 			{/* <DeveloperBios {...devInfo} /> */}
// 			{/* <ClassComponent /> */}
// 			{/* <DisplayBios /> */}
// 			<RouterDemo />
// 		</div>
// 	);
// }

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
