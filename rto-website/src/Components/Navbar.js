import React from 'react';

const Navbar = () => {


  const handleLogout = () => {
    sessionStorage.clear();
    window.location.href = "/";
  };

  return (
    <nav className="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div className="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
        <a className="navbar-brand brand-logo mt-4" href="index.html">
        <h2 className="m-0">
                    <i className="fa fa-car me-2" style={{ color: "#F3BD00" }}></i>Drivin
                  </h2>
        </a>
        <a className="navbar-brand brand-logo-mini mt-4" href="index.html">
        <h2 className="m-0">
                    <i className="fa fa-car me-2" style={{ color: "#F3BD00" }}></i>
                  </h2>
        </a>
      </div>
      <div className="navbar-menu-wrapper d-flex align-items-center justify-content-end">
        <button className="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
          <span className="icon-menu"></span>
        </button>
        
        <ul className="navbar-nav navbar-nav-right">
          
          <li className="nav-item nav-profile dropdown">
            <a className="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
              <img src="images/faces/face28.jpg" alt="profile" />
            </a>
            <div className="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
              <a className="dropdown-item">
                <i className="ti-settings text-primary"></i>
                Settings
              </a>
              <a
                href="#"
                onClick={(e) => {
                  e.preventDefault(); // Prevent navigation
                  handleLogout();
                }}
                className="dropdown-item"
              >
                <i className="ti-power-off text-primary"></i>
                Logout
              </a>
            </div>
          </li>
          
        </ul>
        <button className="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span className="icon-menu"></span>
        </button>
      </div>
    </nav>
  );
};

export default Navbar;
