import React from 'react';

const DeveloperBios = (props) => {
	return (
		<>
			<h1>Developer Bio</h1>
			<div class="card" style={{ width: "18rem" }}>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">ID : {props.id}</li>
					<li class="list-group-item">First Name : {props.firstName}</li>
					<li class="list-group-item">Last Name : {props.lastName}</li>
					<li class="list-group-item">Favorite Language : {props.favoriteLanguage} </li>
					<li class="list-group-item">Year Started : {props.yearStarted}</li>
				</ul>
			</div>
		</>
	)
}

export default DeveloperBios;