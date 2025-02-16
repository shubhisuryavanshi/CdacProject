import React from 'react'
import AdminSidebar from '../AdminSidebar'
import Navbar from '../Navbar'
import RightSidebar from '../RightSidebar'
import DrivingTable from './DrivingTable'
import Footer from '../Footer'
import profileTable from './profileTable'

const ProfileDash = () => {
  return (
    <div className="container-scroller">
    {/* Navbar */}
   <Navbar/>
  <div className="container-fluid page-body-wrapper">

     
      <RightSidebar/>
      <AdminSidebar/>
      <profileTable/>
  </div>
  <Footer/>
</div>
  )
}

export default ProfileDash