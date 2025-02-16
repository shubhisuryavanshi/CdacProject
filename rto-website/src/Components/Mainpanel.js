
import React, { useState, useEffect } from 'react';
import axios from 'axios';


const MainPanel = () => {

  const [userName, setUserName] = useState('');

  useEffect(() => {
    const userId = sessionStorage.getItem('userId');
    if (userId) {
      fetchUserName(userId);
    }
  }, []);

  const fetchUserName = async (userId) => {
    try {
      const response = await axios.get(`http://localhost:8080/findById?user_id=${userId}`);
      setUserName(response.data.firstName || 'User');
    } catch (error) {
      console.error('Error fetching user name:', error);
    }
  };
  return (
    <div className="main-panel">
      <div className="content-wrapper">
        <div className="row">
          <div className="col-md-12 grid-margin">
            <div className="row">
              <div className="col-12 col-xl-8 mb-4 mb-xl-0">
                <h3 className="font-weight-bold">Welcome {userName}</h3>
                <h6 className="font-weight-normal mb-0">
                  All systems are running smoothly! You have <span className="text-primary">3 unread alerts!</span>
                </h6>
              </div>
              
            </div>
          </div>
        </div>
        <div className="row">
          <div className="col-md-6 grid-margin stretch-card">
            <div className="">
              <div className="card-people mt-auto">
                <img src="img/carousel-2.jpg" alt="people" />
               
              </div>
            </div>
          </div>
          <div className="col-md-6 grid-margin transparent">
          <div className="row">
  <div className="col-md-6 mb-4 stretch-card transparent">
    <a href="/divinglisence" className="card card-tale text-decoration-none">
     
        <div className="card-body">
          <h4 className="mb-4" style={{ color: "white" }}>Driving License</h4>
          <p className="fs-30 mb-2">4006</p>
          <p>10.00% (30 days)</p>
        </div>
      
    </a>
  </div>
  <div className="col-md-6 mb-4 stretch-card transparent">
    <a href="/learner-license" className="card card-dark-blue text-decoration-none">
     
        <div className="card-body">
          <h4 className="mb-4" style={{ color: "white" }}>Learner Licenses</h4>
          <p className="fs-30 mb-2">61344</p>
          <p>22.00% (30 days)</p>
        </div>
      
    </a>
  </div>
</div>

              <div className="row">
                <div className="col-md-6 mb-4 mb-lg-0 stretch-card transparent">
                <a href="/vehicle-registration" className="card card-light-blue text-decoration-none">
                 
                    <div className="card-body">
                    <h4 className="mb-4" style={{ color: "white" }}>Vehicle Registration</h4>

                      <p className="fs-30 mb-2">34040</p>
                      <p>2.00% (30 days)</p>
                    </div>
                  </a>
                </div>
                <div className="col-md-6 stretch-card transparent">
                  
                  <a href='/insurance-tables' className="card card-light-danger text-decoration-none">
                    <div className="card-body">
                      <h4 className="mb-4" style={{ color: "white" }}>Insurance</h4>
                      <p className="fs-30 mb-2">47033</p>
                      <p>0.22% (30 days)</p>
                    </div>
                  </a>
                </div>
              </div>
            </div>
        </div>
      </div>
      {/* content-wrapper ends */}
      
    </div>
  );
};

export default MainPanel;
