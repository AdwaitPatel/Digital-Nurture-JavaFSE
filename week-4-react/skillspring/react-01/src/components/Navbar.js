import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark mb-5">
      <div className="container">

        <Link className="navbar-brand" to="/">
           App
        </Link>

        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <Link className="nav-link" to="/">
                Home
              </Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/add_dev">
                Add Developer
              </Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/developer_bio">
                Developer Bios
              </Link>
            </li>
          </ul>
        </div>
		
      </div>
    </nav>
  );
}

export default Navbar;