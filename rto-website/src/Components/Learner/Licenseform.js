import React, { useState, useEffect } from 'react';

const LicenseForm = () => {
  const [learnerId, setLearnerId] = useState('');
  const [issueDate, setIssueDate] = useState('');
  const [expiryDate, setExpiryDate] = useState('');

  // Get userId from session storage
  const [userId, setUserId] = useState(null);

  useEffect(() => {
    const storedUserId = sessionStorage.getItem('userId');
    if (storedUserId) {
      setUserId(storedUserId);
    } else {
      alert('User not logged in or session expired.');
    }
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!userId) {
      alert('User ID is missing.');
      return;
    }

    const learnerLicenseData = {
      learnerId,
      issue_date :issueDate,
      expiry_date :expiryDate,
    };

    try {
      const response = await fetch(`http://localhost:8080/SaveLearnerData?user_id=${userId}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(learnerLicenseData),
      });

      if (response.ok) {
        const data = await response.json();
        alert('Data saved successfully!');
        console.log('Response:', data);
      } else {
        console.error('Failed to save data');
        alert('Failed to save data. Please check the input and try again.');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('An error occurred while saving data.');
    }
  };

  return (
    <div className="col-12 grid-margin">
      <div className="cardstyle">
        <div className="cardstyle-body">
          <h4 className="cardstyle-title">Learner License Form</h4>
          <form className="form-sample" onSubmit={handleSubmit}>
            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Learner ID</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={learnerId}
                      onChange={(e) => setLearnerId(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>

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

export default LicenseForm;
