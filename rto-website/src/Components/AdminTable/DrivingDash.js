import React from 'react'
import AdminSidebar from '../AdminSidebar'
import Navbar from '../Navbar'
import RightSidebar from '../RightSidebar'
import DrivingTable from './DrivingTable'
import Footer from '../Footer'



const DrivingDash = () => {
  return (
    <div className="container-scroller">
    {/* Navbar */}
   <Navbar/>
  <div className="container-fluid page-body-wrapper">

     
      <RightSidebar/>
      <AdminSidebar/>
      <DrivingTable/>
  </div>
  <Footer/>
</div>
  )
}

export default DrivingDash