import React, { useState } from 'react';

const FeeScheduleForm = () => {
  const [feeId, setFeeId] = useState('');
  const [serviceName, setServiceName] = useState('');
  const [feeAmount, setFeeAmount] = useState('');
  const [serviceCategory, setServiceCategory] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const feeScheduleData = {
      feeId,
      serviceName,
      feeAmount,
      serviceCategory,
    };
    console.log('Fee Schedule Data Submitted:', feeScheduleData);
  };

  return (
    <div className="col-12 grid-margin">
      <div className="cardstyle">
        <div className="cardstyle-body">
          <h4 className="cardstyle-title">Fee Schedule Form</h4>
          <form className="form-sample" onSubmit={handleSubmit}>
            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Fee ID</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={feeId}
                      onChange={(e) => setFeeId(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Service Name</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={serviceName}
                      onChange={(e) => setServiceName(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Fee Amount</label>
                  <div className="col-sm-9">
                    <input
                      type="number"
                      className="form-control"
                      value={feeAmount}
                      onChange={(e) => setFeeAmount(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Service Category</label>
                  <div className="col-sm-9">
                    <select
                      className="form-control"
                      value={serviceCategory}
                      onChange={(e) => setServiceCategory(e.target.value)}
                      required
                    >
                      <option value="">Select Category</option>
                      <option value="Driver’s License">Driver’s License</option>
                      <option value="Vehicle Registration">Vehicle Registration</option>
                    </select>
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

export default FeeScheduleForm;
