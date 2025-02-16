import React from "react";
import { Navigate } from "react-router-dom";

const AdminPrivateRoute = ({ children }) => {
  const isAdminAuthenticated = sessionStorage.getItem("isAdminLoggedIn") === "true";

  return isAdminAuthenticated ? children : <Navigate to="/adminLogin" />;
};

export default AdminPrivateRoute;
