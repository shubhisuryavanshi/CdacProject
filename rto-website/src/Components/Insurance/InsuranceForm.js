import React, { useState , useEffect} from 'react';
import Swal from 'sweetalert2';
import '../Card.css';

const InsuranceForm = () => {

  const [userId, setUserId] = useState("");
  const [vehicleId, setVehicleId] = useState('');
  const [insuranceCompany, setInsuranceCompany] = useState('');
  const [policyNumber, setPolicyNumber] = useState('');
  const [expiryDate, setExpiryDate] = useState('');
  const [premiumAmount, setPremiumAmount] = useState('');

   useEffect(() => {
      // Retrieve user ID from sessionStorage
      const storedUserId = sessionStorage.getItem("userId");
      if (storedUserId) setUserId(storedUserId);
    }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    const insuranceData = {
     
      vehicle_id : vehicleId,
      insurance_company: insuranceCompany,
      policy_number: policyNumber,
      expiry_date : expiryDate,
      premium_amount :premiumAmount,

     
    };

    try {
      const response = await fetch(`http://localhost:8080/InsuranceSaveData?user_id=${userId}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(insuranceData),
      });

      if (response.ok) {
        Swal.fire({
          title: 'Success',
          text: 'Insurance data submitted successfully.',
          icon: 'success',
          confirmButtonText: 'OK',
        });

        // Clear form fields
      
        setVehicleId('');
        setInsuranceCompany('');
        setPolicyNumber('');
        setExpiryDate('');
        setPremiumAmount('');
      } else {
        Swal.fire({
          title: 'Error',
          text: 'Failed to submit insurance data.',
          icon: 'error',
          confirmButtonText: 'Try Again',
        });
      }
    } catch (error) {
      Swal.fire({
        title: 'Error',
        text: 'Network error. Please try again.',
        icon: 'error',
        confirmButtonText: 'OK',
      });
    }
  };

  return (
    <div className="col-12 grid-margin">
      <div className="cardstyle">
        <div className="cardstyle-body">
          <h4 className="cardstyle-title">Vehicle Insurance Form</h4>
          <form className="form-sample" onSubmit={handleSubmit}>
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
                  <label className="col-sm-3 col-form-label">Vehicle ID</label>
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
                  <label className="col-sm-3 col-form-label">Insurance Company</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={insuranceCompany}
                      onChange={(e) => setInsuranceCompany(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Policy Number</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={policyNumber}
                      onChange={(e) => setPolicyNumber(e.target.value)}
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
                  <label className="col-sm-3 col-form-label">Premium Amount</label>
                  <div className="col-sm-9">
                    <input
                      type="number"
                      className="form-control"
                      value={premiumAmount}
                      onChange={(e) => setPremiumAmount(e.target.value)}
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

export default InsuranceForm;
