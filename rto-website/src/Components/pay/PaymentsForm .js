import React, { useState, useEffect } from "react";

const PaymentsForm = () => {
  const [userId, setUserId] = useState("");
  const [paymentAmount, setPaymentAmount] = useState("");
  const [paymentDate, setPaymentDate] = useState("");
  const [paymentMethod, setPaymentMethod] = useState("");
  const [transactionId, setTransactionId] = useState("");
  const [serviceName, setServiceName] = useState("");

  useEffect(() => {
    const storedUserId = sessionStorage.getItem("userId");
    if (storedUserId) setUserId(storedUserId);
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const paymentData = {
      user_id: userId,
      payment_amount: paymentAmount,
      payment_date: paymentDate,
      paymentMethod: paymentMethod,
      transaction_id: transactionId,
      service_name: serviceName,
    };

    try {
      const response = await fetch(`http://localhost:8080/SavePaymentData?user_id=${userId}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(paymentData),
      });

      if (response.ok) {
        const result = await response.json();
        console.log("Payment Data Saved:", result);
        alert("Payment data saved successfully!");
      } else {
        console.error("Failed to save payment data");
        alert("Failed to save payment data");
      }
    } catch (error) {
      console.error("Error:", error);
      alert("An error occurred while saving payment data.");
    }
  };

  return (
    <div className="col-12 grid-margin">
      <div className="cardstyle">
        <div className="cardstyle-body">
          <h4 className="cardstyle-title">Payments Form</h4>
          <form className="form-sample" onSubmit={handleSubmit}>
            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Payment Date</label>
                  <div className="col-sm-9">
                    <input
                      type="date"
                      className="form-control"
                      value={paymentDate}
                      onChange={(e) => setPaymentDate(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Payment Method</label>
                  <div className="col-sm-9">
                    <select
                      className="form-control"
                      value={paymentMethod}
                      onChange={(e) => setPaymentMethod(e.target.value)}
                      required
                    >
                      <option value="">Select Method</option>
                      <option value="Cash">Cash</option>
                      <option value="Card">Card</option>
                      <option value="Online">Online</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>

            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Transaction ID</label>
                  <div className="col-sm-9">
                    <input
                      type="text"
                      className="form-control"
                      value={transactionId}
                      onChange={(e) => setTransactionId(e.target.value)}
                      required
                    />
                  </div>
                </div>
              </div>

              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Service Name</label>
                  <div className="col-sm-9">
                    <select
                      className="form-control"
                      value={serviceName}
                      onChange={(e) => setServiceName(e.target.value)}
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

            <div className="row">
              <div className="col-md-6">
                <div className="form-group row">
                  <label className="col-sm-3 col-form-label">Payment Amount</label>
                  <div className="col-sm-9">
                    <input
                      type="number"
                      className="form-control"
                      value={paymentAmount}
                      onChange={(e) => setPaymentAmount(e.target.value)}
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

export default PaymentsForm;
