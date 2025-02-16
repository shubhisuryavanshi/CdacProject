import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import HomePage from "./Components/Home/HomePage";
import LoginPage from "./Components/Login/LoginPage";
import RegistrationPage from "./Components/Registration/RegistrationPage";
import Dashboard from "./Components/Dashboard/Dashboard";
import DrivingLicense from "./Components/Driving/DrivingLicense";
import Dashboardpage from "./Components/Dashboardpage";
import UserProfile from "./Components/profile/UserProfile";
import LearnerLicense from "./Components/Learner/LearnerLicense";
import VehicleRegistration from "./Components/VehicleRegistration ";
import Payments from "./Components/pay/Payments";
import FeeSchedules from "./Components/Fee/FeeSchedules";
import InsuranceTables from "./Components/Insurance/InsuranceTables";
import PrivateRoute from "./Components/PrivateRoute";
import AdminLogin from "./Components/Login/AdminLogin";
import AdminPrivateRoute from "./Components/AdminPrivateRoute";
import AdminDashboard from "./Components/Dashboard/AdminDashboard";
import ProfileDash from "./Components/AdminTable/ProfileDash";
import LearnerDash from "./Components/AdminTable/LearnerDash";
import InsuranceDash from "./Components/AdminTable/InsuranceDash";
import DrivingDash from "./Components/AdminTable/DrivingDash";
import VehicalDash from "./Components/AdminTable/VehicalDash";

const App = () => {
  return (
    <Router>
      <Routes>
        {/* Public Routes */}
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegistrationPage />} />
        <Route path="/adminLogin" element={<AdminLogin/>}/>

        {/* Protected Routes */}
        <Route
          path="/dashboard"
          element={
            <PrivateRoute>
              <Dashboard />
            </PrivateRoute>
          }
        />
        <Route
          path="/divinglisence"
          element={
            <PrivateRoute>
              <DrivingLicense />
            </PrivateRoute>
          }
        />
        <Route
          path="/dash"
          element={
            <PrivateRoute>
              <Dashboardpage />
            </PrivateRoute>
          }
        />
        <Route
          path="/user-profile"
          element={
            <PrivateRoute>
              <UserProfile />
            </PrivateRoute>
          }
        />
        <Route
          path="/learner-license"
          element={
            <PrivateRoute>
              <LearnerLicense />
            </PrivateRoute>
          }
        />
        <Route
          path="/vehicle-registration"
          element={
            <PrivateRoute>
              <VehicleRegistration />
            </PrivateRoute>
          }
        />
        <Route
          path="/payments"
          element={
            <PrivateRoute>
              <Payments />
            </PrivateRoute>
          }
        />
        <Route
          path="/fee-schedules"
          element={
            <PrivateRoute>
              <FeeSchedules />
            </PrivateRoute>
          }
        />
        <Route
          path="/insurance-tables"
          element={
            <PrivateRoute>
              <InsuranceTables />
            </PrivateRoute>
          }
        />
        <Route
          path="/admindashboard"
          element={
            <AdminPrivateRoute>
              <AdminDashboard/>
            </AdminPrivateRoute>
          }
        />
        <Route
          path="/profiledash"
          element={
            <AdminPrivateRoute>
             <ProfileDash/>
            </AdminPrivateRoute>
          }
        />
        <Route
          path="/learnerdash"
          element={
            <AdminPrivateRoute>
              <LearnerDash/>
            </AdminPrivateRoute>
          }
        />
        <Route
          path="/insurancedash"
          element={
            <AdminPrivateRoute>
              <InsuranceDash/>
            </AdminPrivateRoute>
          }
        />
        <Route
          path="/drivingdash"
          element={
            <AdminPrivateRoute>
              <DrivingDash/>
            </AdminPrivateRoute>
          }
        />
        <Route
          path="/vehicaldash"
          element={
            <AdminPrivateRoute>
              <VehicalDash/>
            </AdminPrivateRoute>
          }
        />
      </Routes>
    </Router>
  );
};

export default App;
