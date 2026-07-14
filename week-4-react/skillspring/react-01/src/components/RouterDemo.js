import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
} from "react-router-dom";

import Home from "./Home";
import About from "./DeveloperForm";
import Dashboard from "./Dashboard";
import Navbar from "./Navbar";
import { DisplayBios } from "../App";
import DeveloperForm from "./DeveloperForm";

export default function RouterDemo() {
  return (
	<>
		<Router>
			<Navbar />

			<Routes>
			<Route path="/" element={<Home />} />
			<Route path="/about" element={<About />} />
			<Route path="/add_dev" element={<DeveloperForm />} />
			<Route path="/developer_bio" element={<DisplayBios />} />
			</Routes>
		</Router>
	</>
  );
}