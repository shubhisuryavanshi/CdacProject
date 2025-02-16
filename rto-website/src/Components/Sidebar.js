import React from 'react';

const Sidebar = () => {
  return (
    <nav className="sidebar sidebar-offcanvas" id="sidebar">
      <ul className="nav">
        <li className="nav-item">
          <a className="nav-link" href="/dashboard">
            <i className="icon-grid menu-icon"></i>
            <span className="menu-title">Dashboard</span>
          </a>
        </li>
        <li className="nav-item">
          <a   className="nav-link" href="/user-profile">
            <i className="icon-head menu-icon"></i>
            <span className="menu-title">User profile</span>      
          </a>
          
        </li>
        <li className="nav-item">
          <a
            className="nav-link"
            data-toggle="collapse"
            href="#ui-basic"
            aria-expanded="false"
            aria-controls="ui-basic"
          >
            <i className="icon-layout menu-icon"></i>
            <span className="menu-title">License</span>
            <i className="menu-arrow"></i>
          </a>
          <div className="collapse" id="ui-basic">
            <ul className="nav flex-column sub-menu">
              <li className="nav-item">
                <a className="nav-link" href="/divinglisence">
                  Driving License
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="learner-license">
                  Learner License
                </a>
              </li>
              
            </ul>
          </div>
        </li>
        <li className="nav-item">
          <a
            className="nav-link"
           
            href="/vehicle-registration"
          
          >
            <i className="icon-columns menu-icon"></i>
            <span className="menu-title">Vehical Registration</span>
            
          </a>
          
        </li>
        <li className="nav-item">
          <a
            className="nav-link"
            data-toggle="collapse"
            href="#charts"
            aria-expanded="false"
            aria-controls="charts"
          >
            <i className="icon-bar-graph menu-icon"></i>
            <span className="menu-title">Fees & Payments</span>
            <i className="menu-arrow"></i>
          </a>
          <div className="collapse" id="charts">
            <ul className="nav flex-column sub-menu">
              <li className="nav-item">
                <a className="nav-link" href="/payments">
                  Payments
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/fee-schedules">
                  Fee_schedules
                </a>
              </li>
            </ul>
          </div>
        </li>
        <li className="nav-item">
          <a
            className="nav-link"
            href="/insurance-tables"
          >
            <i className="icon-grid-2 menu-icon"></i>
            <span className="menu-title">Insurance Tables</span>
            
          </a>
         
        </li>
   
        
      </ul>
    </nav>
  );
};

export default Sidebar;
