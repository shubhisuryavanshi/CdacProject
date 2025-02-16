import React, { useState, useEffect } from "react";
import Swal from "sweetalert2";
import '../Card.css';

const DrivingForm = () => {
  const [licenseId, setLicenseId] = useState("");
  const [userId, setUserId] = useState("");
  const [licenseType, setLicenseType] = useState("");
  const [issueDate, setIssueDate] = useState("");
  const [expiryDate, setExpiryDate] = useState("");
  const [licenseNumber, setLicenseNumber] = useState("");
  const [vehicleType, setVehicleType] = useState("");

  useEffect(() => {
    // Retrieve user ID from sessionStorage
    const storedUserId = sessionStorage.getItem("userId");
    if (storedUserId) setUserId(storedUserId);
  }, []);
  const handleSubmit = async (e) => {
    e.preventDefault();
  
    const licenseData = {
      licenseId,
      user_Entity: {
        user_id: userId,
      },
      license_Type: licenseType,
      issue_date: issueDate,
      expiry_date: expiryDate,
      license_number: licenseNumber,
      vehicle_Type: vehicleType,
    };
  
    try {
      const response = await fetch(
        `http://localhost:8080/LicensesSaveData?user_id=${userId}`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(licenseData),
        }
      );
  
      if (response.ok) {
        Swal.fire({
          title: "Success",
          text: "License data submitted successfully.",
          icon: "success",
          confirmButtonText: "OK",
        });
  
        // Clear form fields by resetting state
        setLicenseId("");
        setLicenseType("");
        setIssueDate("");
        setExpiryDate("");
        setLicenseNumber("");
        setVehicleType("");
      } else {
        Swal.fire({
          title: "Error",
          text: "Failed to submit license data.",
          icon: "error",
          confirmButtonText: "Try Again",
        });
      }
    } catch (error) {
      Swal.fire({
        title: "Error",
        text: "Network error. Please try again.",
        icon: "error",
        confirmButtonText: "OK",
      });
    }
  };
  

  return (
    <div className="col-12 grid-margin">
      <div className="cardstyle">
        <div className="cardstyle-body">
          <h4 className="cardstyle-title">Driving License Details Form</h4>
          <form className="form-sample" onSubmit={handleSubmit}>
            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">License ID</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={licenseId}
                      onChange={(e) => setLicenseId(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">User ID</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={userId}
                      disabled
                    />
                  </div>
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">License Type</label>
                  <div className="col-sm-9">
                    <select
                      className="form-control"
                      value={licenseType}
                      onChange={(e) => setLicenseType(e.target.value)}
                      required
                    >
                      <option value="">Select Type</option>
                      <option value="Private">Private</option>
                      <option value="Commercial">Commercial</option>
                    </select>
                  </div>
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Vehicle Type</label>
                  <div className="col-sm-9">
                    <select
                      className="form-control"
                      value={vehicleType}
                      onChange={(e) => setVehicleType(e.target.value)}
                      required
                    >
                      <option value="">Select Vehicle</option>
                      <option value="Bike">Bike</option>
                      <option value="Car">Car</option>
                      <option value="Truck">Truck</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Issue Date</label>
                  <div className="col-sm-9">
                    <input
                      type="date"
                      className="form-control"
                      value={issueDate}
                      onChange={(e) => setIssueDate(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Expiry Date</label>
                  <div className="col-sm-9">
                    <input
                      type="date"
                      className="form-control"
                      value={expiryDate}
                      onChange={(e) => setExpiryDate(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">License Number</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={licenseNumber}
                      onChange={(e) => setLicenseNumber(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>
            </div>

            <div className="mt-3">
              <button type="submit" className="btn btn-primary mr-2">
                Submit
              </button>
              <button type="reset" className="btn btn-light">
                Cancel
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default DrivingForm;
