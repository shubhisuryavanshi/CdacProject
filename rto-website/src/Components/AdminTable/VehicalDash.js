import React from 'react'
import AdminSidebar from '../AdminSidebar'
import Navbar from '../Navbar'
import RightSidebar from '../RightSidebar'
import DrivingTable from './DrivingTable'
import Footer from '../Footer'
import VehicalTable from './VehicalTable'

const VehicalDash = () => {
  return (
    <div className="container-scroller">
    {/* Navbar */}
   <Navbar/>
  <div className="container-fluid page-body-wrapper">

     
      <RightSidebar/>
      <AdminSidebar/>
      <VehicalTable/>
  </div>
  <Footer/>
</div>
  )
}

export default VehicalDash