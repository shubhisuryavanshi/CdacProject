import React from 'react'
import AdminSidebar from '../AdminSidebar'
import Navbar from '../Navbar'
import RightSidebar from '../RightSidebar'
import DrivingTable from './DrivingTable'
import Footer from '../Footer'

import InsuranceTale from './InsuranceTale'

const InsuranceDash = () => {
  return (
    <div className="container-scroller">
    {/* Navbar */}
   <Navbar/>
  <div className="container-fluid page-body-wrapper">

     
      <RightSidebar/>
      <AdminSidebar/>
      <InsuranceTale/>
  </div>
  <Footer/>
</div>
  )
}

export default InsuranceDash