import React from "react";
import RightSidebar from "../RightSidebar";
import Sidebar from "../Sidebar";
import MainPanel from "../Mainpanel";
import Navbar from "../Navbar";
import Footer from "../Footer";


const Dashboard = () => {
  return (
    <div className="container-scroller">
        {/* Navbar */}
       <Navbar/>
      <div className="container-fluid page-body-wrapper">

         
          <RightSidebar/>
          <Sidebar/>
          <MainPanel/>
      </div>
      <Footer/>
    </div>
  );
};

export default Dashboard;
