import React, { useState } from "react";
import Swal from "sweetalert2";

const LoginPage = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
  
    try {
      const response = await fetch(
        `http://localhost:8080/Login?username=${username}&password=${password}`,
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
  
      if (response.ok) {
        const userData = await response.json();
  
        // Store user ID in sessionStorage
        sessionStorage.setItem("userId", userData.user_id);
  
        Swal.fire({
          title: "Login Successful",
          text: "You are now logged in.",
          icon: "success",
          confirmButtonText: "Go to Dashboard",
          confirmButtonColor: "#F3BD00",
        }).then(() => {
          window.location.href = "/dashboard";
        });
      } else {
        Swal.fire({
          title: "Invalid Credentials",
          text: "Please check your username or password.",
          icon: "error",
          confirmButtonText: "Try Again",
          confirmButtonColor: "#F3BD00",
        });
      }
    } catch (error) {
      if (error instanceof TypeError) {
        if (username === "user" && password === "pass") {
          sessionStorage.setItem("userId", "dummy_user");
          Swal.fire({
            title: "Login Successful (Offline Mode)",
            text: "Logged in with dummy credentials.",
            icon: "success",
            confirmButtonText: "Go to Dashboard",
            confirmButtonColor: "#F3BD00",
          }).then(() => {
            window.location.href = "/dashboard";
          });
        }
        else {
          Swal.fire({
            title: "Invalid Username or Password",
            text: "Server unreachable or incorrect credentials. Use user/pass if offline.",
            icon: "error",
            confirmButtonText: "Try Again",
            confirmButtonColor: "#F3BD00",
          });
        }
      } else {
        Swal.fire({
          title: "Unexpected Error",
          text: "Please check your username or password.",
          icon: "error",
          confirmButtonText: "Try Again",
          confirmButtonColor: "#F3BD00",
        });
      }
    }
  };
  

  return (
    <div className="container-scroller">
      <div className="container-fluid page-body-wrapper full-page-wrapper">
        <div className="content-wrapper d-flex align-items-center auth px-0">
          <div className="row w-100 mx-0">
            <div className="col-lg-4 mx-auto">
              <div className="auth-form-light text-left py-5 px-4 px-sm-5">
              <div className="brand-logo">
              <h2 className="m-0">
                <i className="fa fa-car me-2" style={{ color: "#F3BD00" }}></i>Drivin
              </h2>
            </div>
            <h4>Hello! Let's get started</h4>
            <h6 className="font-weight-light">Sign in to continue.</h6>
           
              
                <form className="pt-3" onSubmit={handleSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className="form-control form-control-lg"
                      placeholder="Username"
                      value={username}
                      onChange={(e) => setUsername(e.target.value)}
                      required
                    />
                  </div>
                  <div className="form-group">
                    <input
                      type="password"
                      className="form-control form-control-lg"
                      placeholder="Password"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                      required
                    />
                  </div>
                  <div className="mt-3">
                    <button
                      type="submit"
                      className="btn btn-block btn-lg font-weight-medium auth-form-btn"
                      style={{ backgroundColor: "#F3BD00", color: "#fff" }}
                    >
                      SIGN IN
                    </button>

                  </div>
                
              <div className="text-center mt-4">
                <span>Don't have an account? </span>
                    <a href="/register" style={{ color: "#F3BD00", fontWeight: "bold" }}>
                         Register
                    </a>
 
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
