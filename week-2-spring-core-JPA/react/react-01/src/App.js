import React, { Component } from 'react';
import './App.css';
import DeveloperBios from './components/DeveloperBios';

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

class Developer {
	constructor(id, firstName, lastName, favoriteLanguage, yearStarted) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.favoriteLanguage = favoriteLanguage;
		this.yearStarted = yearStarted;
	}
}

class DisplayBios extends Component {
	constructor(props) {
		super(props);

		this.state = {
			developers: [
				new Developer(1, "adwait", "patel", "js", 2025),
				new Developer(2, "kunal", "kushwah", "java", 2019)
			]
		}

	}

	render() {
		return (
			this.state.developers.map(developer => <DeveloperBios {...developer} />)
		)
	}
}

function App() {
	return (
		<div class="d-flex flex-column justify-content-center align-items-center" style={{ height: "100vh" }}>
			{/* <DeveloperBios {...devInfo} /> */}
			{/* <ClassComponent /> */}
			<DisplayBios />
		</div>
	);
}

export default App;
