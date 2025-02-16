import React from "react";
import { Navigate } from "react-router-dom";

const PrivateRoute = ({ children }) => {
  // Check for dummy credentials
  const isDummyUser = sessionStorage.getItem("userId") === "dummy_user";
  const isAuthenticated = sessionStorage.getItem("userId") !== null || isDummyUser;

  return isAuthenticated ? children : <Navigate to="/login" />;
};

export default PrivateRoute;