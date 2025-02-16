import React, { useState, useEffect } from 'react';
import Swal from 'sweetalert2';

const VehicleRegistrationForm = () => {
  const [registrationId, setRegistrationId] = useState('');
  const [vehicleId, setVehicleId] = useState('');
  const [userId, setUserId] = useState('');
  const [registrationDate, setRegistrationDate] = useState('');
  const [expiryDate, setExpiryDate] = useState('');
  const [registrationNumber, setRegistrationNumber] = useState('');

  useEffect(() => {
    const storedUserId = sessionStorage.getItem('userId');
    if (storedUserId) {
      setUserId(storedUserId);
    } else {
      Swal.fire('Error', 'User not logged in or session expired.', 'error');
    }
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const vehicleRegistrationData = {
      registrationId,
      vehicle_id: vehicleId,
      registrationDate,
      expiryDate,
      registrationNumber,
    };

    try {
      const response = await fetch(
        `http://localhost:8080/VehicleSaveData?user_id=${userId}`,
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(vehicleRegistrationData),
        }
      );

      if (response.ok) {
        Swal.fire('Success', 'Vehicle data submitted successfully.', 'success');
        setRegistrationId('');
        setVehicleId('');
        setRegistrationDate('');
        setExpiryDate('');
        setRegistrationNumber('');
      } else {
        const errorData = await response.json();
        console.error('Server Error:', errorData);
        Swal.fire('Error', 'Failed to submit vehicle data.', 'error');
      }
    } catch (error) {
      console.error('Network Error:', error);
      Swal.fire('Error', 'Network error occurred. Please try again.', 'error');
    }
  };

  return (
    <div className="col-12 grid-margin">
      <div className="cardstyle">
        <div className="cardstyle-body">
          <h4 className="cardstyle-title">Vehicle Registration Form</h4>
          <form className="form-sample" onSubmit={handleSubmit}>
            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Registration ID</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={registrationId}
                      onChange={(e) => setRegistrationId(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Vehicle Number</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={vehicleId}
                      onChange={(e) => setVehicleId(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>
            </div>

            <div className="row">
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

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Registration Date</label>
                  <div className="col-sm-9">
                    <input
                      type="date"
                      className="form-control"
                      value={registrationDate}
                      onChange={(e) => setRegistrationDate(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>
            </div>

            <div className="row">
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

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Registration Number</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={registrationNumber}
                      onChange={(e) => setRegistrationNumber(e.target.value)}
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

export default VehicleRegistrationForm;
